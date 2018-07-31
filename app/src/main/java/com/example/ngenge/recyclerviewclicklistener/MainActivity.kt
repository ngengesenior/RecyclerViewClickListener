package com.example.ngenge.recyclerviewclicklistener

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Toast

class MainActivity : AppCompatActivity(),OnItemClickListener {
    private lateinit var adapter: RecyclerAdapter

    val users = mutableListOf<User>(User("Ngenge Senior","1234"),
            User("Ngenge Junior","6796"),User("Random","908773"),
            User("Random User","908321"),
            User("Random Another","908743"),
            User("Random Man","908773"),User("Random","908273"))

    override fun onItemClicked(user: User) {
        Toast.makeText(this,"User name ${user.username} \n Phone:${user.phone}",Toast.LENGTH_LONG)
                .show()
        Log.i("USER_",user.username)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val usersList = findViewById<RecyclerView>(R.id.usersList)
        usersList.layoutManager = LinearLayoutManager(this)
        adapter = RecyclerAdapter(users,this)
        usersList.adapter = adapter

    }
}
