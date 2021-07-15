package com.rabitebank.task.repository

import com.rabitebank.task.model.ChatDialogMessage
import com.rabitebank.task.util.DumbData

class ChatDialogRepository {
    fun getLastMessages(): ArrayList<ChatDialogMessage> {
        return DumbData.getLatestMessages()
    }
}