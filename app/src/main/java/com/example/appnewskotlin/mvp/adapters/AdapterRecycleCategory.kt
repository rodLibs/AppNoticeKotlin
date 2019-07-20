package com.example.appnewskotlin.mvp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appnewskotlin.R
import com.example.appnewskotlin.data.model.Category
import com.example.appnewskotlin.mvp.list_category.ItemClickCategoryListener



class AdapterRecycleCategory (var context: Context, var listCategory: ArrayList<Category>, var listener: ItemClickCategoryListener): RecyclerView.Adapter<AdapterRecycleCategory.MyViewHolderCategory>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderCategory {
        val view = LayoutInflater.from(context).inflate(R.layout.adapter_list_category, parent,false)
        val myViewHolder = MyViewHolderCategory(view)
        return myViewHolder
    }



    override fun onBindViewHolder(viewHolder: MyViewHolderCategory, position: Int) {
        val category = listCategory[position]
        viewHolder.txtTitle.text = category.name
        viewHolder.itemView.setOnClickListener{
            listener.onItemClick(position, category)
        }
    }



    override fun getItemCount(): Int = listCategory.size



    class MyViewHolderCategory(itemView: View): RecyclerView.ViewHolder(itemView) {
        var txtTitle: TextView = itemView.findViewById(R.id.txtTitle)
    }
}