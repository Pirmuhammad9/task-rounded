package uz.gita.taskrounded.data.pagingsource

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import uz.gita.taskrounded.data.local.room.dao.DataDao
import uz.gita.taskrounded.data.local.room.entity.DataEntity
import uz.gita.taskrounded.data.remote.retrofit.api.BaseApi
import javax.inject.Inject

class AppPaginationSource @Inject constructor(private val api: BaseApi, private val dao: DataDao) :
    PagingSource<Int, DataEntity>() {
    override fun getRefreshKey(state: PagingState<Int, DataEntity>): Int? {
        return 0
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, DataEntity> {
        val start = params.key ?: 1
        var prev: Int? = null
        var next: Int? = null
        var items: List<DataEntity> = dao.getData(start)
        if (items.isEmpty()) {
            try {
                val info = api.getData(start)
                prev = getPrevOrNext(info.info.prev)
                next = getPrevOrNext(info.info.next)
                api.getData(start).results.map {
                    dao.insertData(
                        DataEntity(
                            id = it.id,
                            name = it.name,
                            status = it.status,
                            origin = it.origin.name,
                            image = it.image,
                            current = start,
                            prev = prev,
                            next = next
                        )
                    )
                }
                items = dao.getData(start)
            } catch (ex: Throwable) { }
        } else {
            prev = items[0].prev
            next = items[0].next
        }
        return LoadResult.Page(
            data = items,
            prevKey = prev,
            nextKey = next
        )
    }

    private fun getPrevOrNext(text: String?): Int? {
        if (text == null) return null
        return text.substring(48).toInt()
    }


}