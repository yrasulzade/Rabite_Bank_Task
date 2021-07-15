package com.rabitebank.task.model

enum class DialogMessageType(val type: Int) {
    SINGLE_CHAT(0),
    GROUP_CHAT(1);

    fun getValue(): Int {
        return type
    }
}