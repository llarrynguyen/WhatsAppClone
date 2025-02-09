package com.larrynguyen.whatsappclone.repository

import com.larrynguyen.whatsappclone.model.BaseModel
import com.larrynguyen.whatsappclone.utils.ResourceUtil
import java.lang.reflect.Type
import kotlin.collections.ArrayList

open class BaseRepository<Model>(
    resourceId: Int,
    collectionType: Type,
    resourceUtil: ResourceUtil
) : BaseRepositoryInterface<Model> where Model: BaseModel {
    protected var data: ArrayList<Model> = resourceUtil.load(resourceId, collectionType)

    override fun getById(id: String): Model? {
        return data.find { it.id == id }
    }

    override fun deleteById(id: String) {
        data.removeAll { it.id == id }
    }

    override fun loadAll(): ArrayList<Model> {
        return data
    }
}