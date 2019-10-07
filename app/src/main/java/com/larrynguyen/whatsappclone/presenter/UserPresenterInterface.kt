package com.larrynguyen.whatsappclone.presenter

import com.larrynguyen.whatsappclone.model.User

interface UserPresenterInterface {
    fun getUser(): User
    fun loadAll(): ArrayList<User>
}