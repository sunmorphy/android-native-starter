package com.andikas.nativestarter.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class GenericAdapter<T : Any>(
    @LayoutRes private val layoutId: Int,
    private val bindInterface: GenericInterfaceAdapter<T>,
) : ListAdapter<T, GenericAdapter.GenericViewHolder>(GenericClassDifferCallback<T>()) {

    class GenericClassDifferCallback<T : Any> : DiffUtil.ItemCallback<T>() {
        override fun areItemsTheSame(oldItem: T, newItem: T): Boolean =
            oldItem.toString() == newItem.toString()

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: T, newItem: T): Boolean =
            oldItem == newItem
    }

    class GenericViewHolder(
        private val view: View,
    ) : RecyclerView.ViewHolder(view) {
        fun <T : Any> bind(
            item: T,
            genericInterfaceAdapter: GenericInterfaceAdapter<T>,
        ) = genericInterfaceAdapter.bindData(item, view, adapterPosition)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenericViewHolder {
        val mItemVIew = LayoutInflater.from(parent.context)
            .inflate(layoutId, parent, false)
        return GenericViewHolder(mItemVIew)
    }

    override fun onBindViewHolder(holder: GenericViewHolder, position: Int) {
        val item = currentList[position]
        holder.bind(item, bindInterface)
    }

    override fun submitList(list: List<T>?) {
        super.submitList(list?.let { ArrayList(it) })
    }

    interface GenericInterfaceAdapter<T : Any> {
        fun bindData(item: T, view: View, adapterPosition: Int)
    }
}