package uz.gita.taskrounded.presenter.viewmodel.impl

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import uz.gita.taskrounded.data.local.room.entity.DataEntity
import uz.gita.taskrounded.domain.usecase.MainScreenUseCase
import uz.gita.taskrounded.presenter.viewmodel.MainScreenViewModel
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModelImpl @Inject constructor(private val useCase: MainScreenUseCase) :
    MainScreenViewModel, ViewModel() {
    private val pageSize = 1
    override val items: Flow<PagingData<DataEntity>> = Pager(
        config = PagingConfig(pageSize = 20, maxSize = 800, enablePlaceholders = false),
        pagingSourceFactory = { useCase.getData() }
    ).flow
}