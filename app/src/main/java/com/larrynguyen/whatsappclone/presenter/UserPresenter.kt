package com.larrynguyen.whatsappclone.presenter

import android.content.res.Resources
import com.larrynguyen.whatsappclone.model.User
import com.larrynguyen.whatsappclone.repository.UserRepository
import com.larrynguyen.whatsappclone.repository.UserRepositoryInterface

class UserPresenter(
    resources: Resources
): UserPresenterInterface {
    private val userRepository: UserRepositoryInterface = UserRepository(resources)

    override fun getUser(): User {
        return userRepository.loadAll()[0]
    }

    override fun loadAll(): ArrayList<User> {
        return userRepository.loadAll()
    }
}