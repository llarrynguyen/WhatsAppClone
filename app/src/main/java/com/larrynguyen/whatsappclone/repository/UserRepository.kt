package com.larrynguyen.whatsappclone.repository

import android.content.res.Resources
import com.google.gson.reflect.TypeToken
import com.larrynguyen.whatsappclone.R
import com.larrynguyen.whatsappclone.model.User
import com.larrynguyen.whatsappclone.utils.ResourceUtil

class UserRepository(
    resources: Resources
): BaseRepository<User>(
    R.raw.users,
    object : TypeToken<ArrayList<User>>(){}.type,
    ResourceUtil(resources)
), UserRepositoryInterface {

    override fun getById(id: String): User? {
        return data.find { it.id == id }
    }
}