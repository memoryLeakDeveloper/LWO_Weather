package com.lwo.weather.ui.fragment.login

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.lwo.weather.R
import com.lwo.weather.core.App
import com.lwo.weather.core.BaseFragment
import com.lwo.weather.core.cloud.getResult
import com.lwo.weather.data.login.LoginRepository
import com.lwo.weather.databinding.LoginFragmentBinding
import com.lwo.weather.utils.bugger
import kotlinx.coroutines.launch

class LoginFragment : BaseFragment<LoginFragmentBinding>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            buttonSend.setOnClickListener {
                lifecycleScope.launch {
                    LoginRepository().loginUser(etLogin.text.toString(), etPassword.text.toString())
                        .getResult(
                            success = {
                                App.token = it.result.token
                                findNavController().navigate(R.id.action_loginFragment_to_weatherFragment)
                                bugger("success = ${it.result}")
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