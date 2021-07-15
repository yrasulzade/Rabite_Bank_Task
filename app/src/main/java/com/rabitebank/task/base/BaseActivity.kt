package com.rabitebank.task.base

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import com.rabitebank.task.R

abstract class BaseActivity<T : ViewDataBinding?, V : BaseViewModel> :
    AppCompatActivity() {
    private var mViewDataBinding: T? = null
    private var mViewModel: V? = null

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun getViewModel(): V
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDataBinding()
    }

    open fun getViewDataBinding(): T {
        return this.mViewDataBinding!!
    }

    open fun getViewModel2(): V {
        return this.mViewModel!!
    }


    open fun performDataBinding() {

        mViewDataBinding = DataBindingUtil.setContentView<T>(this, getLayoutId())

        mViewModel = if (mViewModel == null) getViewModel() else mViewModel

        mViewDataBinding?.executePendingBindings()
    }

    open fun hideKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    open fun showMessage(message: String) {
        val parentLayout = findViewById<View>(android.R.id.content)
        Snackbar.make(parentLayout, message, Snackbar.LENGTH_LONG).show()
    }
}