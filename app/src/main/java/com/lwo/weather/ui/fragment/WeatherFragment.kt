package com.lwo.weather.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.format.DateFormat
import android.view.View
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import com.airbnb.mvrx.MavericksView
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import com.bumptech.glide.Glide
import com.lwo.weather.R
import com.lwo.weather.core.cloud.ExceptionHandler
import com.lwo.weather.core.viewBinding
import com.lwo.weather.databinding.FragmentWeatherLayoutBinding
import com.lwo.weather.ui.custom.LoadingDialog
import com.lwo.weather.ui.fragment.state.ScreenState
import com.lwo.weather.ui.fragment.state.State
import com.lwo.weather.ui.fragment.state.UiEvent
import com.lwo.weather.ui.fragment.state.getState
import com.lwo.weather.utils.bugger
import com.lwo.weather.utils.setTextAnimation
import com.lwo.weather.utils.showSnackBar
import java.util.Calendar

class WeatherFragment : Fragment(R.layout.fragment_weather_layout), MavericksView {

    private val viewModel: WeatherViewModel by fragmentViewModel()
    private val binding: FragmentWeatherLayoutBinding by viewBinding()
    private var loadingDialog = LoadingDialog()
    private val searchCallback: (Editable?) -> Unit = {
        it?.let { viewModel.processEvent(UiEvent.Search(it.toString())) }
    }
    private val clickCallback: (String) -> Unit = {
        viewModel.processEvent(UiEvent.NewCity(it))
        binding.search.hidePanel()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.search.setSearchCallback(searchCallback, clickCallback)
    }

    override fun invalidate(): Unit = withState(viewModel) { state ->
        when (state.getState()) {
            State.Loading -> {
                loadingDialog.showDialog(requireContext())
            }

            State.Success -> {
                handleSuccessState(state)
            }

            State.Search -> {
                bugger(state.search)
                binding.search.updateList(state.search ?: emptyList())
            }

            State.Error -> {
                loadingDialog.hideDialog()
                showSnackBar(ExceptionHandler.recognizeReason(state.error))
            }
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun handleSuccessState(state: ScreenState) = binding.apply {
        loadingDialog.hideDialog()
        state.data?.let { data ->
            root.background = AppCompatResources.getDrawable(requireContext(), if (data.isDay) R.drawable.day else R.drawable.night)
            root.setOnTouchListener { _, _ ->
                search.hidePanel()
                false
            }
            tvDate.text = getCurrentDateString()
            tvCity.setTextAnimation(data.city)
            tvTemp.setTextAnimation(requireContext().getString(R.string.temp, data.temp ?: "No data"))
            tvWind.setTextAnimation(requireContext().getString(R.string.wind, data.wind ?: "No data"))
            tvHumidity.setTextAnimation(requireContext().getString(R.string.humidity, data.humidity ?: "No data"))
            tvCondition.setTextAnimation(data.condition)
            Glide.with(requireContext()).load(data.conditionIcon).into(ivCondition)
            ivSearch.setOnClickListener {
                search.showPanel()
            }
            if (data.forecast?.size != 3) {
                showSnackBar(R.string.something_is_wrong)
                return@apply
            }
            data.forecast.forEachIndexed { index, forecastDataUi ->
                when (index) {
                    0 -> {
                        Glide.with(requireContext()).load(forecastDataUi.icon).into(ivForecast1)
                        tvForecast1Temp.setTextAnimation(requireContext().getString(R.string.temp, forecastDataUi.minMaxTemp))
                    }

                    1 -> {
                        Glide.with(requireContext()).load(forecastDataUi.icon).into(ivForecast2)
                        tvForecast2Temp.setTextAnimation(requireContext().getString(R.string.temp, forecastDataUi.minMaxTemp))
                    }

                    2 -> {
                        Glide.with(requireContext()).load(forecastDataUi.icon).into(ivForecast3)
                        tvForecast3Temp.setTextAnimation(requireContext().getString(R.string.temp, forecastDataUi.minMaxTemp))
                        tvForecast3Day.text =
                            resources.getStringArray(R.array.day_of_week)[Calendar.getInstance().get(Calendar.DAY_OF_WEEK) + 1]
                    }
                }
            }
        }
    }

    private fun getCurrentDateString(): String {
        val date = Calendar.getInstance().time
        val dayOfTheWeek = DateFormat.format("EEEE", date).toString()
        val day = DateFormat.format("dd", date).toString()
        val month = DateFormat.format("MMM", date).toString()
        val year = DateFormat.format("yyyy", date).toString()
        return dayOfTheWeek.plus(", ").plus(day).plus(" ").plus(month).plus("").plus(year)
    }

    override fun onStop() {
        super.onStop()
        binding.search.hidePanel()
    }
}