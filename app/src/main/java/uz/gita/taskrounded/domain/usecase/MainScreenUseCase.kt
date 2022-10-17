package uz.gita.taskrounded.domain.usecase

import android.provider.ContactsContract
import uz.gita.taskrounded.data.model.Data
import uz.gita.taskrounded.data.pagingsource.AppPaginationSource

interface MainScreenUseCase {
    fun getData():AppPaginationSource
}