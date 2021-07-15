package com.rabitebank.task.base

import android.util.Log
import androidx.lifecycle.*
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel : ViewModel(), LifecycleObserver, CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main
    private val mLaunchManager: MutableList<Job> = mutableListOf()

    protected fun launchOnUITryCatch(
        tryBlock: suspend CoroutineScope.() -> Unit,
        cacheBlock: suspend CoroutineScope.(Throwable) -> Unit,
        finallyBlock: suspend CoroutineScope.() -> Unit
    ) {
        launchOnUI {
            tryCatch(tryBlock, cacheBlock, finallyBlock)
        }
    }

    /**
     * add launch task to [mLaunchManager]
     */
    private fun launchOnUI(block: suspend CoroutineScope.() -> Unit) {
        val job = launch { block() }
        mLaunchManager.add(job)
        job.invokeOnCompletion { mLaunchManager.remove(job) }
    }

    private suspend fun tryCatch(
        tryBlock: suspend CoroutineScope.() -> Unit,
        catchBlock: suspend CoroutineScope.(Throwable) -> Unit,
        finallyBlock: suspend CoroutineScope.() -> Unit
    ) {
        coroutineScope {
            try {
                tryBlock()
            } catch (e: Throwable) {
                catchBlock(e)
            } finally {
                finallyBlock()
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestory() {
        Log.i("tt", "onDestory")
        clearLaunchTask()
    }

    override fun onCleared() {
        clearLaunchTask()
        super.onCleared()
    }

    fun clearLaunchTask() {
        for (job in mLaunchManager) {
            job.cancel()
        }
        mLaunchManager.clear()
    }

    private val loading = MutableLiveData<Boolean>()
    private val message = MutableLiveData<Int>()
    val errorLiveData = MutableLiveData<Throwable>()
    val loadingState: LiveData<Boolean>
        get() = loading

    fun getMessage(): LiveData<Int> {
        return message
    }

    fun getErrorLiveData(): LiveData<Throwable> {
        return errorLiveData
    }

    fun loading(isLoading: Boolean) {
        loading.value = isLoading
    }

    fun showMessage(message: Int) {
        this.message.value = message
    }
}