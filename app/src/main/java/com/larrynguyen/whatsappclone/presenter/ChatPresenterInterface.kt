package com.larrynguyen.whatsappclone.presenter

import com.larrynguyen.whatsappclone.model.Chat

interface ChatPresenterInterface {
    fun loadAll(): ArrayList<Chat>
    fun getChatByContact(id: String): Chat?
}