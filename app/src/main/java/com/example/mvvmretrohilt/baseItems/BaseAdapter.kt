package com.example.mvvmretrohilt.baseItems

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T> : RecyclerView.Adapter<BaseAdapter<T>.ViewHolder>() {

    private var dataList: List<T> = emptyList()

    fun setData(data: List<T>) {
        dataList = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(getLayoutRes(viewType), parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun getItemViewType(position: Int): Int {
        // Override this method to provide different view types if needed
        return super.getItemViewType(position)
    }

    abstract fun getLayoutRes(viewType: Int): Int

    abstract fun onBindData(item: T, itemView: View)

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: T) {
            onBindData(item, itemView)
        }
    }

}