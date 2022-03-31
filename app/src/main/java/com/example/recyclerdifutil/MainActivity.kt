package com.example.recyclerdifutil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerdifutil.Adapters.Adapters
import com.example.recyclerdifutil.Model.UserModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var adapter : Adapters
    lateinit var userllis :ArrayList<UserModel>

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        runFist()
    }
    fun runFist() {
        userllis = ArrayList()
        rec1.layoutManager =LinearLayoutManager(this@MainActivity)
        adapter = Adapters()
        adapter.submitList(userllis)
        rec1.adapter  = adapter

        initView()
    }

    private fun initView() {
        button1.setOnClickListener(object :View.OnClickListener{
            override fun onClick(p0 : View?) {
                gotoWirte()
            }
        })


    }

    private fun gotoWirte() {
        if(!edit1.text.trim().isEmpty()&&!edit2.text.trim().isEmpty()){
            var userModel  = UserModel(edit1.text.toString(),edit2.text.toString())
            userllis.add(userModel)
            adapter.submitList(userllis)
            rec1.adapter = adapter

        }
    }
}