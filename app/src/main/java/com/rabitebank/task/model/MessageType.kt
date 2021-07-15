package com.rabitebank.task.model

enum class MessageType(val type: Int) {
    TEXT(0),
    IMAGE(1);

    fun getValue(): Int {
        return type
    }
}