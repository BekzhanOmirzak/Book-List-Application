package com.example.profileapplication1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.profileapplication1.Activities.AlreadyReadBooksActivity
import com.example.profileapplication1.Activities.CurrentlyReadingActivity
import com.example.profileapplication1.Activities.FavouriteBookActivity
import com.example.profileapplication1.Activities.WantToReadBooksActivity
import com.example.profileapplication1.Models.Book
import com.example.profileapplication1.SmalDataBase.Utils

class BookActivity : AppCompatActivity() {
    private lateinit var btnCurrentlyReading:Button
    private lateinit var btnWantToRead:Button
    private lateinit var btnAlreadyRead:Button
    private lateinit var btnAddToFavourite:Button
    private lateinit var txtTitle:TextView
    private lateinit var txtAuthor:TextView
    private lateinit var txtPages:TextView
    private lateinit var txtDescription:TextView
    private lateinit var txtLongDesc:TextView
    private lateinit var imgImageBook:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)
        initViews()


        val book_id=intent.getIntExtra("book_id",-1)
        Log.i("tag", "onCreate: Book ID $book_id")
        if(book_id!=-1){
            val book=Utils.getBookById(book_id)
             setData(book!!)
             handleCurrentlyReadingBook(book)
             handleAlreadyReadBook(book)
             handleWantToReadBook(book)
             handleFavourities(book)
        }

    }

    private fun initViews() {
        btnCurrentlyReading=findViewById(R.id.button)
        btnWantToRead=findViewById(R.id.button2)
        btnAlreadyRead=findViewById(R.id.button4)
        btnAddToFavourite=findViewById(R.id.button5)
        txtTitle=findViewById(R.id.txtBookTitle)
        txtAuthor=findViewById(R.id.txtAuthor)
        txtPages=findViewById(R.id.txtPages)
        txtDescription=findViewById(R.id.txtDescription)
        txtLongDesc=findViewById(R.id.txtLongDescription)
        imgImageBook=findViewById(R.id.imgBook)
    }

    private fun setData(book: Book){
        txtTitle.text=book.title
        txtPages.text="500"
        txtAuthor.text=book.author
        txtDescription.text=book.description
        txtLongDesc.setText("Our circle of influence, those areas that we can effect, can be expanded by being" +
                " proactive, having an end in mind, knowing what to put first, thinking win-win, listening, " +
                "finding synergy in the world around us and continually sharpening the saw. In other words, " +
                "through the 7 Habits of Highly Effective People.")
        Glide.with(this).asBitmap().load(book.imageUrl).centerCrop().into(imgImageBook)
    }

    private fun handleCurrentlyReadingBook(book: Book) {
         if(book.currentlyReading){
             btnCurrentlyReading.isEnabled=false
             btnCurrentlyReading.setBackgroundResource(R.drawable.disablied_button)
         }else {
             btnCurrentlyReading.setOnClickListener{
                 book.currentlyReading=true

                 val intent=Intent(this,CurrentlyReadingActivity::class.java)
                 intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                 startActivity(intent)
             }
         }
    }

    private fun handleAlreadyReadBook(book: Book) {
         if(book.alreadyBook){
             btnAlreadyRead.isEnabled=false
             btnAlreadyRead.setBackgroundResource(R.drawable.disablied_button)
         }else {

             btnAlreadyRead.setOnClickListener{
                 book.alreadyBook=true
                 val intent=Intent(this,AlreadyReadBooksActivity::class.java)
                 intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                 startActivity(intent)
             }
         }
    }

    private fun handleWantToReadBook(book:Book){
        if(book.wantToReadBook){
            btnWantToRead.isEnabled=false
            btnWantToRead.setBackgroundResource(R.drawable.disablied_button)
        }else {
            btnWantToRead.setOnClickListener{
                book.wantToReadBook=true
                val intent=Intent(this,WantToReadBooksActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
            }
        }
    }

    private fun handleFavourities(book:Book){
        if(book.addToFavourities){
            btnAddToFavourite.isEnabled=false
            btnAddToFavourite.setBackgroundResource(R.drawable.disablied_button)
        }else {
            btnAddToFavourite.setOnClickListener{
                book.addToFavourities=true
                val intent=Intent(this,FavouriteBookActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
            }
        }
    }


}