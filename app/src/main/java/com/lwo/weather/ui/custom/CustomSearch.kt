package com.lwo.weather.ui.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.appcompat.widget.LinearLayoutCompat
import com.lwo.weather.R
import com.lwo.weather.databinding.LayoutCustomSearchBinding
import com.lwo.weather.utils.showKeyboard

class CustomSearch(context: Context, attrs: AttributeSet) : LinearLayoutCompat(context, attrs) {

    private val binding = LayoutCustomSearchBinding.inflate(LayoutInflater.from(context), this)

    init {
        orientation = VERTICAL
        layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        setBackgroundColor(context.getColor(R.color.white))
    }

    fun focus() {
        binding.etSearch.showKeyboard()
    }

}