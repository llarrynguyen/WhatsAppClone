package com.larrynguyen.whatsappclone.repository

import android.content.res.Resources
import com.google.gson.reflect.TypeToken
import com.larrynguyen.whatsappclone.R
import com.larrynguyen.whatsappclone.model.Chat
import com.larrynguyen.whatsappclone.utils.ResourceUtil

class ChatRepository(
    resources: Resources
): BaseRepository<Chat>(
    R.raw.chats,
    object : TypeToken<ArrayList<Chat>>(){}.type,
    ResourceUtil(resources)
), ChatRepositoryInterface {

}