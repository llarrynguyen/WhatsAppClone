package com.larrynguyen.whatsappclone.presenter

import com.larrynguyen.whatsappclone.model.Call

interface CallPresenterInterface {
    fun loadAll(): ArrayList<Call>
}