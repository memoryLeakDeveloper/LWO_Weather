package com.lwo.weather.ui.fragment.epoxy

import android.view.View
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.lwo.weather.R

@EpoxyModelClass
abstract class CitiesModel : EpoxyModelWithHolder<CitiesModel.CitiesHolder>() {

    @EpoxyAttribute
    var callback: ((String) -> Unit)? = null

    @EpoxyAttribute
    var text: String = ""

    override fun getDefaultLayout(): Int {
        return R.layout.item_city
    }

    override fun bind(holder: CitiesHolder) {
        holder.textView.text = text
        holder.root.setOnClickListener {
            callback?.invoke(text)
        }
    }

    inner class CitiesHolder : EpoxyHolder() {

        lateinit var root: View
        lateinit var textView: TextView

        override fun bindView(itemView: View) {
            root = itemView
            textView = itemView.findViewById(R.id.tv_city)
        }

    }

}