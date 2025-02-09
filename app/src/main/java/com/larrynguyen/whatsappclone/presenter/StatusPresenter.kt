package com.larrynguyen.whatsappclone.presenter

import android.content.res.Resources
import com.larrynguyen.whatsappclone.dto.StatusDTO
import com.larrynguyen.whatsappclone.repository.StatusRepository
import com.larrynguyen.whatsappclone.repository.StatusRepositoryInterface
import com.larrynguyen.whatsappclone.repository.UserRepository
import com.larrynguyen.whatsappclone.repository.UserRepositoryInterface
import kotlin.collections.ArrayList

class StatusPresenter(
    resources: Resources
): StatusPresenterInterface {
    private val statusRepository: StatusRepositoryInterface = StatusRepository(resources)
    private val userRepository: UserRepositoryInterface = UserRepository(resources)

    override fun loadAll(): ArrayList<StatusDTO> {
        val map = HashMap<String, StatusDTO>()
        val list = statusRepository.loadAll()

        list.forEach {
            it.owner = userRepository.getById(it.ownerId)

            if(!map.contains(it.ownerId)) {
                map[it.ownerId] = StatusDTO(it.owner!!)
            }

            map[it.ownerId]!!.addStatus(it)
        }

        return ArrayList(map.values)
    }
}