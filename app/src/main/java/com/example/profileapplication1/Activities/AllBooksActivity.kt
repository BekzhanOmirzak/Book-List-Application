package com.example.profileapplication1.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.profileapplication1.Adapter.BookAdapter
import com.example.profileapplication1.R
import com.example.profileapplication1.SmalDataBase.Utils

class AllBooksActivity : AppCompatActivity() {

    private lateinit var bookRecView:RecyclerView
    private lateinit var bookAdapter:BookAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_books)
        bookRecView=findViewById(R.id.recViewALlBooks)

        bookRecView.layoutManager= LinearLayoutManager(this)
        bookRecView.setHasFixedSize(true)
        bookAdapter= BookAdapter(this,Utils.allBooks)
        bookRecView.adapter=bookAdapter

    }
}