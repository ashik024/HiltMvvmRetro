package com.example.mvvmretrohilt.widget

import android.content.res.Resources
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class MarginItemDecoration(spaceHeightDp: Int, private val clipBottom: Boolean = false) : RecyclerView.ItemDecoration() {

    private val spaceHeight = spaceHeightDp.px

    override fun getItemOffsets(outRect: Rect, view: View,
                                parent: RecyclerView, state: RecyclerView.State) {
        with(outRect) {
            if(!clipBottom || parent.getChildAdapterPosition(view) != parent.adapter?.itemCount?.minus(1) ?: -1) {
                bottom = spaceHeight
            }
        }
    }
}

val Int.px: Int get() {
    return (this * Resources.getSystem().displayMetrics.density).toInt()
}