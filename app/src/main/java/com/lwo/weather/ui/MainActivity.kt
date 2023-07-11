package com.lwo.weather.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lwo.weather.databinding.ActivityMainBinding
import com.lwo.weather.utils.hideKeyboard
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val mBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }

    override fun onStop() {
        super.onStop()
        mBinding.root.hideKeyboard()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}