package com.robert.mvparch.base.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter


/**
 * ListView的基础adatper
 * Created by robert on 2018/3/10.
 */
abstract class BaseAdapter<T>(context: Context) : BaseAdapter() {
    protected var mInflater: LayoutInflater = LayoutInflater.from(context)
    protected var mContext: Context = context
    protected var mDataList: MutableList<T> = ArrayList()

    /**
     * 设置数据
     */
    fun setData(data: List<T>?) {
        if (data != null && data.isNotEmpty()) {
            this.mDataList.clear()
            this.mDataList.addAll(data)
            this.notifyDataSetChanged()
        }
    }

    fun getDataList(): List<T>? {
        return mDataList
    }

    override fun getCount(): Int {
        return mDataList.size
    }

    override fun getItem(position: Int): Any? {
        return mDataList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override abstract fun getView(position: Int, convertView: View, parent: ViewGroup): View
}