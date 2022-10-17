package uz.gita.taskrounded.domain.usecase.impl

import uz.gita.taskrounded.data.pagingsource.AppPaginationSource
import uz.gita.taskrounded.domain.repository.Repository
import uz.gita.taskrounded.domain.usecase.MainScreenUseCase
import javax.inject.Inject

class MainScreenUseCaseImpl @Inject constructor(private val repository: Repository) :
    MainScreenUseCase {
    override fun getData(): AppPaginationSource = repository.getPagingSource()
}