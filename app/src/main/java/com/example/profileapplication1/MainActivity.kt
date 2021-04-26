package com.example.profileapplication1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.example.profileapplication1.Activities.*
import com.example.profileapplication1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var btnAllBooks: Button
    private lateinit var btnCurrentReading: Button
    private lateinit var btnAlreadyRead: Button
    private lateinit var btnWishList: Button
    private lateinit var btnFavourite: Button
    private lateinit var btnAbout: Button

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
        initViews()

        handleLicences()
    }

    private fun initViews() {
        btnAllBooks = findViewById(R.id.btnSeeAllBooks)
        btnCurrentReading = findViewById(R.id.btnCurrentlyReading)
        btnAlreadyRead = findViewById(R.id.btnAlreadyRead)
        btnWishList = findViewById(R.id.btnWishList)
        btnFavourite = findViewById(R.id.btnSeeFavourite)
        btnAbout = findViewById(R.id.btnAbout)
    }

    fun changeColorClickedAndAction(view: View) {
        when (view.id) {
            R.id.btnSeeAllBooks -> {
                btnAllBooks.setBackgroundResource(R.drawable.btn_color_clicked)
                object : CountDownTimer(2000, 2000) {
                    override fun onFinish() {
                        btnAllBooks.setBackgroundResource(R.drawable.btn_color)
                    }

                    override fun onTick(millisUntilFinished: Long) {

                    }
                }.start()
                startActivity(Intent(this, AllBooksActivity::class.java))
            }
            R.id.btnAlreadyRead ->{
                btnAlreadyRead.setBackgroundResource(R.drawable.btn_color_clicked)
                object : CountDownTimer(2000, 2000) {
                    override fun onFinish() {
                        btnAlreadyRead.setBackgroundResource(R.drawable.btn_color)
                    }

                    override fun onTick(millisUntilFinished: Long) {

                    }
                }.start()
                startActivity(Intent(this, AlreadyReadBooksActivity::class.java))
            }
            R.id.btnCurrentlyReading -> {
                btnCurrentReading.setBackgroundResource(R.drawable.btn_color_clicked)
                object : CountDownTimer(2000, 2000) {
                    override fun onFinish() {
                        btnCurrentReading.setBackgroundResource(R.drawable.btn_color)
                    }

                    override fun onTick(millisUntilFinished: Long) {

                    }
                }.start()
                startActivity(Intent(this, CurrentlyReadingActivity::class.java))
            }
            R.id.btnWishList -> {
                btnWishList.setBackgroundResource(R.drawable.btn_color_clicked)
                object : CountDownTimer(2000, 2000) {
                    override fun onFinish() {
                        btnWishList.setBackgroundResource(R.drawable.btn_color)
                    }

                    override fun onTick(millisUntilFinished: Long) {

                    }
                }.start()
                startActivity(Intent(this, WantToReadBooksActivity::class.java))
            }
            else -> {
                btnFavourite.setBackgroundResource(R.drawable.btn_color_clicked)
                object : CountDownTimer(2000, 2000) {
                    override fun onFinish() {
                        btnFavourite.setBackgroundResource(R.drawable.btn_color)
                    }

                    override fun onTick(millisUntilFinished: Long) {

                    }
                }.start()
                startActivity(Intent(this, FavouriteBookActivity::class.java))
            }
        }
    }

    private fun handleLicences() {
       btnAbout.setOnClickListener{
           showdialog()
       }
    }

    private fun showdialog() {
        val view=layoutInflater.inflate(R.layout.dialog_about_licences,null)
        val alertDialog=AlertDialog.Builder(this).setView(view).create()
        alertDialog.show()
        val btnVisit=view.findViewById<Button>(R.id.btnVisit)
        val btnCancel=view.findViewById<Button>(R.id.btnCancel)
        btnVisit.setOnClickListener{
            startActivity(Intent(this,WebViewActivity::class.java))
        }
        btnCancel.setOnClickListener{
           alertDialog.dismiss()
        }

    }
}