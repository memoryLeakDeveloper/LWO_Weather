package com.lwo.weather.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.airbnb.mvrx.MavericksView
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import com.lwo.weather.R
import com.lwo.weather.core.cloud.ExceptionHandler
import com.lwo.weather.core.viewBinding
import com.lwo.weather.databinding.FragmentWeatherLayoutBinding
import com.lwo.weather.ui.custom.LoadingDialog
import com.lwo.weather.ui.fragment.state.ScreenState
import com.lwo.weather.ui.fragment.state.State
import com.lwo.weather.ui.fragment.state.getState
import com.lwo.weather.utils.bugger
import com.lwo.weather.utils.showSnackBar

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
            }

            State.Error -> {
                loadingDialog.hideDialog()
                requireView().showSnackBar(ExceptionHandler.recognizeReason(state.error))
            }
        }
    }

}