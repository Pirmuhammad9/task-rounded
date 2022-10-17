package uz.gita.taskrounded.presenter.viewmodel

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import uz.gita.taskrounded.data.local.room.entity.DataEntity
import uz.gita.taskrounded.data.model.Data

interface MainScreenViewModel {
    val items:Flow<PagingData<DataEntity>>
}