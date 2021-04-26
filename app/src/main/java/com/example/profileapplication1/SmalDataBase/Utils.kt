package com.example.profileapplication1.SmalDataBase

import com.example.profileapplication1.Models.Book

object Utils {
    var book_id = 0
    var allBooks: MutableList<Book> = mutableListOf()

    init {
        allBooks.add(
            Book(
                getId(),
                "Kaharly Kunder",
                "Muxtar Auezov",
                "This book is about the challenged faced by my Nomads during WW2. The author's description for that time is detailed and the books has about more than 1000pages",
                "https://cdn.pixabay.com/photo/2015/06/02/12/59/book-794978__340.jpg"
            )
        )
        allBooks.add(
            Book(
                getId(),
                "Maxabbat kyzyk mol zhyldar",
                "Berdibek Sokpakbaev",
                "As the name of the book implies, this book describes the love between couples named Erbol and Aydana. This couple feel in love to each other at university and dated for two years followed by the death of Aydana",
                "https://cdn.pixabay.com/photo/2016/09/10/17/18/book-1659717__340.jpg"
            )
        )
        allBooks.add(
            Book(
                getId(),
                "Maxabbat kyzyk mol zhyldar",
                "Berdibek Sokpakbaev",
                "As the name of the book implies, this book describes the love between couples named Erbol and Aydana. This couple feel in love to each other at university and dated for two years followed by the death of Aydana",
                "https://cdn.pixabay.com/photo/2018/07/01/20/01/book-3510326__340.jpg"
            )
        )
        allBooks.add(
            Book(
                getId(),
                "Maxabbat kyzyk mol zhyldar",
                "Berdibek Sokpakbaev",
                "As the name of the book implies, this book describes the love between couples named Erbol and Aydana. This couple feel in love to each other at university and dated for two years followed by the death of Aydana",
                "https://cdn.pixabay.com/photo/2015/11/19/21/14/glasses-1052023__340.jpg"
            )
        )
        allBooks.add(
            Book(
                getId(),
                "Maxabbat kyzyk mol zhyldar",
                "Berdibek Sokpakbaev",
                "As the name of the book implies, this book describes the love between couples named Erbol and Aydana. This couple feel in love to each other at university and dated for two years followed by the death of Aydana",
                "https://cdn.pixabay.com/photo/2015/11/19/21/11/book-1052014__340.jpg"
            )
        )

    }

    private fun getId(): Int {
        book_id++
        return book_id
    }

    fun getBookById(id:Int):Book?{
        for(book in allBooks){
            if(book.book_id==id){
                return book
            }
        }
        return null
    }
    fun getCurrentlyReadingBook():ArrayList<Book>{
        val result= arrayListOf<Book>()
        for(book in allBooks){
            if(book.currentlyReading){
                result.add(book)
            }
        }
        return result
    }

    fun getAlreadyReadBooks():ArrayList<Book>{
        val result= arrayListOf<Book>()
        for(book in allBooks){
            if(book.alreadyBook){
                result.add(book)
            }
        }
        return result
    }

    fun getWantToReadBook():ArrayList<Book>{
        val result= arrayListOf<Book>()
        for(book in allBooks){
            if(book.wantToReadBook){
                result.add(book)
            }
        }
        return result
    }

    fun getFavouriteBooks():ArrayList<Book>{
        val result= arrayListOf<Book>()
        for(book in allBooks){
            if(book.addToFavourities){
                result.add(book)
            }
        }
        return result
    }



}