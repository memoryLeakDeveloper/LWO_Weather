package com.lwo.weather.ui.custom

import android.content.Context
import android.widget.ProgressBar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class LoadingDialog(private val minShowingTime: Long = 300) {

    private var baseDialog = BaseDialog()

    private var dialogShowAt = 0L

    fun showDialog(context: Context) {
        dialogShowAt = System.currentTimeMillis()
        baseDialog.showDialog(ProgressBar(context), cancelable = false)
    }

    fun hideDialog() {
        if (System.currentTimeMillis() > dialogShowAt + minShowingTime) {
            baseDialog.hideDialog()
            dialogShowAt = 0L
        } else {
            CoroutineScope(Dispatchers.Main).launch {
                delay((dialogShowAt + minShowingTime) - System.currentTimeMillis())
                hideDialog()
            }
        }
    }

}