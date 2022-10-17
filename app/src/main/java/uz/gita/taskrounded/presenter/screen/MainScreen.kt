package uz.gita.taskrounded.presenter.screen

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import uz.gita.taskrounded.R
import uz.gita.taskrounded.databinding.ScreenMainBinding
import uz.gita.taskrounded.presenter.adapter.MainAdapter
import uz.gita.taskrounded.presenter.viewmodel.MainScreenViewModel
import uz.gita.taskrounded.presenter.viewmodel.impl.MainScreenViewModelImpl
import uz.gita.taskrounded.util.isInternetAvailable

@AndroidEntryPoint
class MainScreen : Fragment(R.layout.screen_main) {

    private val viewModel: MainScreenViewModel by viewModels<MainScreenViewModelImpl>()
    private val binding by viewBinding(ScreenMainBinding::bind)
    private val adapter = MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter.setOnClickLister {
            val intent  = Intent(Intent.ACTION_VIEW, Uri.parse("https://rickandmortyapi.com/"))
            if (isInternetAvailable(requireActivity())) startActivity(intent)
            else{
                showMessage()
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        val items = viewModel.items
        recycler.adapter = adapter
        lifecycleScope.launch {
            adapter.submitData(items.first())
        }
        adapter.addOnPagesUpdatedListener {
            appendProgress.isVisible = true
        }
        lifecycleScope.launch {
            adapter.onPagesUpdatedFlow.collect {
                delay(500)
                appendProgress.isVisible = false
            }
        }
        recycler.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun showMessage(){
        Toast.makeText(requireContext(), "No internet connection", Toast.LENGTH_SHORT).show()
    }
}