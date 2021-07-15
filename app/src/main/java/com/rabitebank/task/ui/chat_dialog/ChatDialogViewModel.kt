package com.rabitebank.task.ui.chat_dialog

import com.rabitebank.task.repository.ChatDialogRepository
import com.rabitebank.task.base.BaseViewModel
import com.rabitebank.task.model.ChatDialogMessage
import com.rabitebank.task.util.SingleLiveEvent

class ChatDialogViewModel : BaseViewModel() {

    val lastMessages = SingleLiveEvent<List<ChatDialogMessage>>()
    val filteredMessages = SingleLiveEvent<ArrayList<ChatDialogMessage>>()
    private val chatDialogRepository = ChatDialogRepository()

    init {
        getLastMessages()
    }

    // fake API request
    fun getLastMessages() {
        launchOnUITryCatch({
            lastMessages.value =chatDialogRepository.getLastMessages()
        }, { _ ->
            // error happened
        }, {
            //stop loading
        })
    }

    fun filter(text: String, lastMessages: ArrayList<ChatDialogMessage>) {

        if (text.isEmpty()) {
            getLastMessages()
        } else {
            val filteredMessages = ArrayList<ChatDialogMessage>()

            for (message in lastMessages) {
                if (message.userName?.lowercase()?.contains(text.lowercase())!!) {
                    filteredMessages.add(message)
                }
            }
            this.filteredMessages.value = filteredMessages
        }
    }

}