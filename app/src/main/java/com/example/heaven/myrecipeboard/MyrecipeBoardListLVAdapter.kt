package com.example.heaven.myrecipeboard

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.LinearLayout
import android.widget.TextView
import com.example.heaven.R
import com.example.heaven.utils.FBAuth

class MyrecipeBoardListLVAdapter(val boardList : MutableList<MyrecipeBoardModel>) : BaseAdapter() {

    override fun getCount(): Int {
        return boardList.size
    }

    override fun getItem(position: Int): Any {
        return boardList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var view = convertView

        view = LayoutInflater.from(parent?.context).inflate(R.layout.myrecipeboard_list_item, parent, false)

        val itemLinearLayoutView = view?.findViewById<LinearLayout>(R.id.itemView)
        val title = view?.findViewById<TextView>(R.id.titleArea)
        val cate = view?.findViewById<TextView>(R.id.cateArea)
        val time = view?.findViewById<TextView>(R.id.timeArea)

//        if(boardList[position].uid.equals(FBAuth.getUid())) {
//            itemLinearLayoutView?.setBackgroundColor(Color.parseColor("#ffa500"))
//        }

        title!!.text = boardList[position].title
        cate!!.text = boardList[position].cate
        time!!.text = boardList[position].time


        return view!!
    }
}