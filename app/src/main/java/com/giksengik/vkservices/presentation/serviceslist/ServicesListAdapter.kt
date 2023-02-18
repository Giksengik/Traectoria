package com.giksengik.vkservices.presentation.serviceslist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.giksengik.vkservices.databinding.ItemVkServiceBinding
import com.giksengik.vkservices.presentation.serviceslist.ServicesListAdapter.ViewHolder.Companion.DIFF_CALLBACK

/**
 * @author e.a.vlasov
 */
class ServicesListAdapter(
    private val onServiceClick: (ServiceInformationUI) -> Unit,
) : ListAdapter<ServiceInformationUI, ServicesListAdapter.ViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemVkServiceBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        ).apply {
            onViewHolderCreated(this, binding)
        }
    }

    private fun onViewHolderCreated(
        viewHolder: RecyclerView.ViewHolder,
        binding: ItemVkServiceBinding,
    ) {

        binding.root.setOnClickListener { onServiceClick(getItem(viewHolder.adapterPosition)) }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        val binding: ItemVkServiceBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ServiceInformationUI) {
            binding.apply {
                serviceName.text = item.name
                Glide.with(serviceIcon)
                    .load(item.iconUrl)
                    .into(serviceIcon)
            }
        }

        companion object {
            val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ServiceInformationUI>() {
                override fun areItemsTheSame(
                    oldItem: ServiceInformationUI,
                    newItem: ServiceInformationUI
                ): Boolean = oldItem.name == newItem.name

                override fun areContentsTheSame(
                    oldItem: ServiceInformationUI,
                    newItem: ServiceInformationUI
                ): Boolean = oldItem == newItem
            }
        }
    }
}
