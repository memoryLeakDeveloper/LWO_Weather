package com.lwo.weather.ui.custom

import android.content.Context
import android.text.Editable
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.widget.doAfterTextChanged
import com.lwo.weather.R
import com.lwo.weather.databinding.LayoutCustomSearchBinding
import com.lwo.weather.utils.showKeyboard

class CustomSearch(context: Context, attrs: AttributeSet) : LinearLayoutCompat(context, attrs) {

    private val binding = LayoutCustomSearchBinding.inflate(LayoutInflater.from(context), this)
    private var searchCallback: ((Editable?) -> Unit)? = null

    init {
        orientation = VERTICAL
        layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        setBackgroundColor(context.getColor(R.color.white))
        binding.etSearch.doAfterTextChanged {
            searchCallback?.invoke(it)
        }
    }

    fun setSearchCallback(callback: (Editable?) -> Unit) {
        searchCallback = callback
    }

    fun focus() {
        binding.etSearch.showKeyboard()
    }

}