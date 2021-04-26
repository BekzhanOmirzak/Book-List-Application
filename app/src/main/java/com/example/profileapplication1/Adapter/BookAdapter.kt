package com.example.profileapplication1.Adapter

import android.content.Context
import android.content.Intent
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.profileapplication1.BookActivity
import com.example.profileapplication1.Models.Book
import com.example.profileapplication1.R
import com.google.android.material.card.MaterialCardView

class BookAdapter(val context:Context, var books:MutableList<Book>)  : RecyclerView.Adapter<BookAdapter.ViewHolder>(){

    companion object{
        const val book_id="book_id"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view:View=LayoutInflater.from(parent.context).inflate(R.layout.book_item,null,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       Glide.with(context).load(books.get(position).imageUrl)
           .centerCrop().into(holder.imageBook)
        holder.txtTitle.text=books[position].title
        holder.txtAuthor.text=books[position].author
        holder.txtDesciption.text=books[position].description


        if(books.get(position).isExpanded){
            TransitionManager.beginDelayedTransition(holder.parent)
            holder.detailLayout.visibility=View.VISIBLE
            holder.imgDownArrow.visibility=View.GONE
        }else {
            TransitionManager.beginDelayedTransition(holder.parent)
            holder.detailLayout.visibility=View.GONE
            holder.imgDownArrow.visibility=View.VISIBLE
        }


        holder.parent.setOnClickListener{
            val intent:Intent=Intent(context, BookActivity::class.java)
             intent.putExtra(book_id,books[position].book_id)
             context.startActivity(intent)
        }


    }

    override fun getItemCount(): Int {
        return books.count()
    }

    inner class ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        var txtTitle: TextView =itemView.findViewById(R.id.txtBookTitle)
        var txtAuthor:TextView=itemView.findViewById(R.id.txtAuthor)
        var imageBook:ImageView=itemView.findViewById(R.id.imgBook)
        var txtDesciption:TextView=itemView.findViewById(R.id.txtDescription)
        var detailLayout:RelativeLayout=itemView.findViewById(R.id.DetailLayout)
        var imgDownArrow:ImageView=itemView.findViewById(R.id.imgdownArrow)
        val imgUpArrow:ImageView=itemView.findViewById(R.id.imgUpArrow)
        val parent:MaterialCardView=itemView.findViewById(R.id.parent)

        init {
            imgDownArrow.setOnClickListener{
                val book:Book=books.get(adapterPosition)
                book.isExpanded=true
                notifyItemChanged(adapterPosition)
            }
            imgUpArrow.setOnClickListener{
                val book:Book=books[adapterPosition]
                book.isExpanded=false
                notifyItemChanged(adapterPosition)
            }
        }

    }
}