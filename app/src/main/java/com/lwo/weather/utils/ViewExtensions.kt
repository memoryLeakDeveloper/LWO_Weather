package com.lwo.weather.utils

import android.app.Application
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.StringRes
import com.google.android.material.snackbar.Snackbar
import com.lwo.weather.R

fun View.toGone() {
    this.visibility = View.GONE
}

fun View.toInvisible() {
    this.visibility = View.INVISIBLE
}

fun View.toVisible() {
    this.visibility = View.VISIBLE
}

fun View.hideKeyboard() {
    clearFocus()
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}

fun EditText.showKeyboard() {
    val imm = context.getSystemService(Application.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
    requestFocus()
}

fun View.showSnackBar(@StringRes resId: Int) {
    val snackBar = Snackbar.make(this, context.getString(resId), Snackbar.LENGTH_LONG).apply {
        setAction(context.getString(R.string.ok)) { dismiss() }
    }
    (snackBar.view.findViewById(com.google.android.material.R.id.snackbar_text) as TextView).apply {
        textSize = 14F
    }
    snackBar.show()
}