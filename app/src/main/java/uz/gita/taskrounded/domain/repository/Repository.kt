package uz.gita.taskrounded.domain.repository

import androidx.paging.PagingSource
import uz.gita.taskrounded.data.model.Data
import uz.gita.taskrounded.data.pagingsource.AppPaginationSource

interface Repository {
    fun getPagingSource():AppPaginationSource
}