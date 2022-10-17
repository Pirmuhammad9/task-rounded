package uz.gita.taskrounded.presenter.viewmodel

import androidx.lifecycle.LiveData

interface SplashScreenViewModel {
    val openNextScreenLiveData: LiveData<Unit>
}