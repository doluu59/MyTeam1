package com.example.myteam1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TimetableRVA(val items:ArrayList<MyData>) :RecyclerView.Adapter<TimetableRVA.ViewHolder>() {  //데이터 타입 시간표 리스트 객체 전체!
    interface OnItemClickListener {
        fun OnItemClick(holder: RecyclerView.ViewHolder, view: View, data: MyData, position: Int) //
    }
    var itemCLickListener:OnItemClickListener?=null

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val contentView: TextView = view.findViewById(R.id.content)

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }

        init {
            itemView.setOnClickListener {
                itemCLickListener?.OnItemClick(this, it, items[adapterPosition], adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //시간표 리스트 어떻게 가져올 건지에 대해서 생각해봐야합니당.
        val item = values[position]
        holder.contentView.text = item
    }

    override fun getItemCount(): Int = values.size
}