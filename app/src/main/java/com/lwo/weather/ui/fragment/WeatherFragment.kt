package com.lwo.weather.ui.fragment

import android.os.Bundle
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
import com.lwo.weather.ui.fragment.state.getState
import com.lwo.weather.utils.bugger
import com.lwo.weather.utils.hideKeyboard
import com.lwo.weather.utils.showSnackBar
import com.lwo.weather.utils.toGone
import com.lwo.weather.utils.toVisible
import java.util.Calendar

class WeatherFragment : Fragment(R.layout.fragment_weather_layout), MavericksView {

    private val viewModel: WeatherViewModel by fragmentViewModel()
    private val binding: FragmentWeatherLayoutBinding by viewBinding()
    private var loadingDialog = LoadingDialog()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.root
    }

    override fun invalidate(): Unit = withState(viewModel) { state ->
        bugger(state)
        handleState(state)
    }

    private fun handleState(state: ScreenState) {
        when (state.getState()) {
            State.Loading -> {
                loadingDialog.showDialog(requireContext())
            }

            State.Success -> {
                loadingDialog.hideDialog()
                state.data?.let { data ->
                    binding.apply {
                        //todo isDay
                        root.background = AppCompatResources.getDrawable(
                            requireContext(), if (data.current?.isDay == 1) R.drawable.day else R.drawable.night
                        )
                        root.setOnTouchListener { v, event ->
                            requireView().hideKeyboard()
                            search.toGone()
                            false
                        }
                        tvDate.text = getCurrentDateString()
                        tvCity.text = data.location?.name
                        tvTemp.text = requireContext().getString(R.string.temp, data.current?.tempC ?: "No data")
                        tvWind.text = requireContext().getString(R.string.wind, data.current?.windKph ?: "No data")
                        tvHumidity.text = requireContext().getString(R.string.humidity, data.current?.humidity ?: "No data")
                        tvCondition.text = data.current?.conditionData?.text
                        Glide.with(requireContext()).load(data.current?.conditionData?.getConditionIcon()).into(ivCondition)
                        ivSearch.setOnClickListener {
                            search.toVisible()
                            search.focus()
                        }
                    }

                }

            }

            State.Error -> {
                loadingDialog.hideDialog()
                requireView().showSnackBar(ExceptionHandler.recognizeReason(state.error))
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

}