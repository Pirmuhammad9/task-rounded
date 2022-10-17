package uz.gita.taskrounded.domain.repository.impl

import uz.gita.taskrounded.data.local.room.dao.DataDao
import uz.gita.taskrounded.data.pagingsource.AppPaginationSource
import uz.gita.taskrounded.data.remote.retrofit.api.BaseApi
import uz.gita.taskrounded.domain.repository.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val api: BaseApi, private val dao: DataDao) : Repository {
    override fun getPagingSource(): AppPaginationSource = AppPaginationSource(api, dao)
}