package com.rabitebank.task.repository

import com.rabitebank.task.model.Message
import com.rabitebank.task.util.DumbData

class MessagesRepository {
    fun getMessagesBetweenTwoUser(): ArrayList<Message> {
        return DumbData.getMessagesBetweenTwoUser()
    }
}