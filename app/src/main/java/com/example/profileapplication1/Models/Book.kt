package com.example.profileapplication1.Models

data class Book(val book_id:Int,
           val title:String,
           val author:String,
           val description:String,
           val imageUrl:String,
           var isExpanded:Boolean=false){
    var alreadyBook:Boolean=false
    var wantToReadBook:Boolean=false
    var currentlyReading:Boolean=false
    var addToFavourities:Boolean=false
    override fun toString(): String {
        return this.title
    }
}