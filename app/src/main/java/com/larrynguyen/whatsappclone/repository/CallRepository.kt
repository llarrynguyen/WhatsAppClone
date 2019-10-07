package com.larrynguyen.whatsappclone.repository

import android.content.res.Resources
import com.google.gson.reflect.TypeToken
import com.larrynguyen.whatsappclone.R
import com.larrynguyen.whatsappclone.model.Call
import com.larrynguyen.whatsappclone.utils.ResourceUtil

class CallRepository(
    resources: Resources
): BaseRepository<Call>(
    R.raw.calls,
    object : TypeToken<ArrayList<Call>>(){}.type,
    ResourceUtil(resources)
), CallRepositoryInterface {
}