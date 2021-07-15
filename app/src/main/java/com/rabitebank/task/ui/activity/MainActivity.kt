package com.rabitebank.task.ui.activity

import androidx.lifecycle.ViewModelProvider
import com.rabitebank.task.R
import com.rabitebank.task.base.BaseActivity
import com.rabitebank.task.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    private lateinit var viewModel: MainViewModel
    lateinit var binding: ActivityMainBinding

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun getViewModel(): MainViewModel {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        return viewModel
    }
}