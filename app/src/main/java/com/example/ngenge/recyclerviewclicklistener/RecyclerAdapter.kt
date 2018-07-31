package com.example.ngenge.recyclerviewclicklistener

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_user.view.*

class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
{
    val name = itemView.username
    val phone = itemView.phone


    fun bind(user: User,clickListener: OnItemClickListener)
    {
        name.text = user.username
        phone.text = user.phone

        itemView.setOnClickListener {
            clickListener.onItemClicked(user)
        }
    }

}


class RecyclerAdapter(var users:MutableList<User>, val itemClickListener: OnItemClickListener):RecyclerView.Adapter<MyHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): MyHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user,parent,false)
        return MyHolder(view)


    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(myHolder: MyHolder, position: Int) {
        val user = users.get(position)
        myHolder.bind(user,itemClickListener)


    }
}


interface OnItemClickListener{
    fun onItemClicked(user: User)
}