package com.rabitebank.task.model

data class ChatDialogMessage(
    var userName: String?=null,
    var lastMessage: String?=null,
    var dateCreated: String?=null,
    var userImageUri: List<String>?=null,
    var messageType: DialogMessageType?=null
)