package com.example.recyclerdifutil.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerdifutil.Model.UserModel
import com.example.recyclerdifutil.R
import kotlinx.android.synthetic.main.custom_itemview.view.*

class Adapters :ListAdapter<UserModel,Adapters.MyViewHolder >(MyDifUrils()) {


    inner class MyViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
        fun setFields(model : UserModel){
            itemView.tv1.text=model.username
            itemView.tv2.text=model.userpass
        }
    }


    // TODO: this is bad code maybe error
    class  MyDifUrils : DiffUtil.ItemCallback<UserModel>() {
        override fun areItemsTheSame(oldItem : UserModel, newItem : UserModel) : Boolean {
            return oldItem.username.equals(newItem.username)
        }

        override fun areContentsTheSame(oldItem : UserModel, newItem : UserModel) : Boolean {
            return oldItem.userpass.equals(newItem.userpass)
        }
    }

    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int) : MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_itemview,parent,false))
    }

    override fun onBindViewHolder(holder : MyViewHolder, position : Int) {
        var userModel  = getItem(position)

        holder.setFields(userModel)

    }
}