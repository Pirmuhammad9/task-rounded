package uz.gita.taskrounded.presenter.viewmodel.impl

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import uz.gita.taskrounded.presenter.viewmodel.SplashScreenViewModel
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModelImpl @Inject constructor() : SplashScreenViewModel, ViewModel() {
    override val openNextScreenLiveData = MutableLiveData<Unit>()

    init {
        viewModelScope.launch {
            delay(3000)
            openNextScreenLiveData.value = Unit
        }
    }

}