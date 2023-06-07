package com.lwo.weather.ui.custom

import android.content.Context
import android.text.Editable
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.widget.doAfterTextChanged
import androidx.recyclerview.widget.LinearLayoutManager
import com.lwo.weather.R
import com.lwo.weather.data.search.SearchData
import com.lwo.weather.databinding.LayoutCustomSearchBinding
import com.lwo.weather.ui.fragment.epoxy.CitiesController
import com.lwo.weather.utils.showKeyboard

class CustomSearch(context: Context, attrs: AttributeSet) : LinearLayoutCompat(context, attrs) {

    private val binding = LayoutCustomSearchBinding.inflate(LayoutInflater.from(context), this)
    private var controller: CitiesController? = null
    private var searchCallback: ((Editable?) -> Unit)? = null
    private var clickCallback: ((String) -> Unit)? = null

    init {
        orientation = VERTICAL
        layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        setBackgroundColor(context.getColor(R.color.white))
        binding.etSearch.doAfterTextChanged {
            searchCallback?.invoke(it)
        }
        initRecycler()
    }

    private fun initRecycler() {
        val linearLayoutManager = LinearLayoutManager(context)
        binding.recyclerCities.apply {
            layoutManager = linearLayoutManager
            setHasFixedSize(true)
            adapter = controller?.adapter
        }
        controller?.requestModelBuild()
    }

    fun updateList(list: List<SearchData>) {
        controller = clickCallback?.let { CitiesController(list, it) }
        binding.recyclerCities.adapter = controller?.adapter
        controller?.requestModelBuild()
    }

    fun setSearchCallback(callback: (Editable?) -> Unit, clickCallback: (String) -> Unit) {
        searchCallback = callback
        this.clickCallback = clickCallback
    }

    fun focus() {
        binding.etSearch.showKeyboard()
    }

}