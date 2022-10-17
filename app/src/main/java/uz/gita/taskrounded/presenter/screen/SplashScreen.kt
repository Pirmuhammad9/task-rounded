package uz.gita.taskrounded.presenter.screen

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.taskrounded.R
import uz.gita.taskrounded.databinding.ScreenSplashBinding
import uz.gita.taskrounded.presenter.viewmodel.SplashScreenViewModel
import uz.gita.taskrounded.presenter.viewmodel.impl.SplashScreenViewModelImpl

@AndroidEntryPoint
class SplashScreen : Fragment(R.layout.screen_splash) {
    private val viewModel: SplashScreenViewModel by viewModels<SplashScreenViewModelImpl>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.openNextScreenLiveData.observe(this@SplashScreen, openNextScreenObserver)
    }

    private val openNextScreenObserver = Observer<Unit> {
        findNavController().navigate(SplashScreenDirections.actionSplashScreenToMainScreen())
    }

}