package com.example.profileapplication1.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.profileapplication1.Adapter.BookAdapter
import com.example.profileapplication1.MainActivity
import com.example.profileapplication1.R
import com.example.profileapplication1.SmalDataBase.Utils

class AlreadyReadBooksActivity : AppCompatActivity() {
    private lateinit var recViewAlreadyBook: RecyclerView
    private lateinit var adapter: BookAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_already_read_books)

        recViewAlreadyBook=findViewById(R.id.recViewAlreadyRead)
        adapter= BookAdapter(this, Utils.getAlreadyReadBooks())
        recViewAlreadyBook.layoutManager= LinearLayoutManager(this)
        recViewAlreadyBook.adapter=adapter
    }

    override fun onBackPressed() {
        val intent= Intent(this,MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }

}