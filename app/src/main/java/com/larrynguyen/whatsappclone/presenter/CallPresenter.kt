package com.larrynguyen.whatsappclone.presenter

import android.content.res.Resources
import com.larrynguyen.whatsappclone.model.Call
import com.larrynguyen.whatsappclone.model.User
import com.larrynguyen.whatsappclone.repository.CallRepository
import com.larrynguyen.whatsappclone.repository.CallRepositoryInterface
import com.larrynguyen.whatsappclone.repository.UserRepository
import com.larrynguyen.whatsappclone.repository.UserRepositoryInterface

class CallPresenter(
    resources: Resources
): CallPresenterInterface {
    private val callRepository: CallRepositoryInterface = CallRepository(resources)
    private val userRepository: UserRepositoryInterface = UserRepository(resources)

    override fun loadAll(): ArrayList<Call> {
        val list = callRepository.loadAll()

        list.forEach { call ->
            call.owner = userRepository.getById(call.ownerId)
            call.participants = call.participantsId.map { participantId ->
                userRepository.getById(participantId)!!
            } as ArrayList<User>
        }

        return list
    }
}