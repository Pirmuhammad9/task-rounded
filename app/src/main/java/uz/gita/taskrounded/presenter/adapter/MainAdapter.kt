package uz.gita.taskrounded.presenter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import uz.gita.taskrounded.R
import uz.gita.taskrounded.data.local.room.entity.DataEntity
import uz.gita.taskrounded.data.model.Data
import uz.gita.taskrounded.databinding.ItemBinding

class MainAdapter : PagingDataAdapter<DataEntity, MainAdapter.ViewHolder>(MainDiffUtil) {

    private var onClickListener:(()->Unit)? = null

    object MainDiffUtil : DiffUtil.ItemCallback<DataEntity>() {
        override fun areItemsTheSame(oldItem: DataEntity, newItem: DataEntity): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: DataEntity, newItem: DataEntity): Boolean = oldItem == newItem
    }
    inner class ViewHolder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                onClickListener?.invoke()
            }
        }
        fun bind(data: DataEntity) = with(binding) {
            Glide.with(image).load(data.image).placeholder(R.drawable.placeholder).into(image)
            name.text = "Name: ${data.name}"
            status.text = "Status: ${data.status}"
            origin.text = "Origin: ${data.origin}"
        }
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.apply {
            holder.bind(this)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        ItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    fun setOnClickLister(bl:()->Unit){
        onClickListener = bl
    }

}