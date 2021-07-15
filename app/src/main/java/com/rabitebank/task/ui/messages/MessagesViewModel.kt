package com.rabitebank.task.ui.messages

import com.rabitebank.task.repository.MessagesRepository
import com.rabitebank.task.base.BaseViewModel
import com.rabitebank.task.model.Message
import com.rabitebank.task.util.SingleLiveEvent

class MessagesViewModel : BaseViewModel() {
    val messages = SingleLiveEvent<List<Message>>()
    private val messageRepository = MessagesRepository()

    init {
        getMessagesBetweenTwoUser()
    }

    // fake API request
    private fun getMessagesBetweenTwoUser() {
        launchOnUITryCatch({
            messages.value = messageRepository.getMessagesBetweenTwoUser()
        }, { _ ->
           // error happened
        }, {
            // stop loading
        })

    }

}