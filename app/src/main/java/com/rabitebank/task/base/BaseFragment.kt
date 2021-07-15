package com.rabitebank.task.base

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer

abstract class BaseFragment<T : ViewDataBinding?, V : BaseViewModel?> : Fragment() {

    lateinit var mActivity: BaseActivity<Nothing, Nothing>

    private var mRootView: View? = null
    var viewDataBinding: T? = null
    private var mViewModel: V? = null

    @LayoutRes
    abstract fun getLayoutId(): Int
    abstract fun getViewModel(): V

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BaseActivity<*, *>) {
            val activity = context
            mActivity = activity as BaseActivity<Nothing, Nothing>
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = getViewModel()
        setHasOptionsMenu(false)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDataBinding = DataBindingUtil.inflate<T>(inflater, getLayoutId(), container, false)
        mRootView = viewDataBinding!!.root
        return mRootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding!!.lifecycleOwner = this
        viewDataBinding!!.executePendingBindings()
    }

    val baseActivity: BaseActivity<Nothing, Nothing>
        get() = mActivity

    private fun hideKeyboard() {
        mActivity.hideKeyboard()
    }

    override fun onPause() {
        super.onPause()
        hideKeyboard()
    }
}