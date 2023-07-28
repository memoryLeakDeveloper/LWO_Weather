package com.lwo.weather.ui.fragment.registration

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.lwo.weather.R
import com.lwo.weather.core.App
import com.lwo.weather.core.BaseFragment
import com.lwo.weather.core.cloud.getResult
import com.lwo.weather.data.registration.RegistrationRepository
import com.lwo.weather.databinding.RegistrationFragmentBinding
import com.lwo.weather.utils.bugger
import kotlinx.coroutines.launch

class RegistrationFragment : BaseFragment<RegistrationFragmentBinding>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            buttonSend.setOnClickListener {
                lifecycleScope.launch {
                    RegistrationRepository().registerUser(etLogin.text.toString(), etEmail.text.toString(), etPassword.text.toString())
                        .getResult(
                            success = {
                                App.token = it.result.token
                                bugger("success = ${it.result}")
                                findNavController().navigate(R.id.action_registrationFragment_to_loginFragment)
                            },
                            failure = {
                                bugger("failure = ${it.exception}")
                            }
                        )
                }
            }
        }
    }
}