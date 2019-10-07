package com.larrynguyen.whatsappclone.presenter

import com.larrynguyen.whatsappclone.dto.StatusDTO

interface StatusPresenterInterface {
    fun loadAll(): ArrayList<StatusDTO>
}