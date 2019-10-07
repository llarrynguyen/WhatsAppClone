package com.larrynguyen.whatsappclone.presenter

import android.content.res.Resources
import com.larrynguyen.whatsappclone.model.Chat
import com.larrynguyen.whatsappclone.model.User
import com.larrynguyen.whatsappclone.repository.ChatRepository
import com.larrynguyen.whatsappclone.repository.ChatRepositoryInterface
import com.larrynguyen.whatsappclone.repository.UserRepository
import com.larrynguyen.whatsappclone.repository.UserRepositoryInterface

class ChatPresenter(
    resources: Resources
): ChatPresenterInterface {
    private val chatRepository: ChatRepositoryInterface = ChatRepository(resources)
    private val userRepository: UserRepositoryInterface = UserRepository(resources)

    override fun loadAll(): ArrayList<Chat> {
        val list = chatRepository.loadAll()

        list.forEach { chat ->
            chat.participants = chat.participantsId.map {
                userRepository.getById(it)!!
            } as ArrayList<User>
        }

        return list
    }

    override fun getChatByContact(id: String): Chat? {
        val list = loadAll()

        return list.find { it.participantsId.contains(id) }
    }
}