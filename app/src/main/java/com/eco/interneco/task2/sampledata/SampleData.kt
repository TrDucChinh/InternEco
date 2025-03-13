package com.eco.interneco.task2.sampledata

import com.eco.interneco.task2.models.Book
import com.eco.interneco.task2.models.CategoryBook
import com.eco.interneco.task2.models.TypeBook
import com.eco.interneco.task2.models.User


// Singletons
object SampleData {
    val booksList = mutableListOf(
        Book(1,"Harry Potter", "J.K. Rowling", "1997", CategoryBook.FANTASY, TypeBook.EBOOK, true),
        Book(2,"The Lord of the Rings", "J.R.R. Tolkien", "1954", CategoryBook.FANTASY, TypeBook.PAPER_BOOK, true),
        Book(3,"The Da Vinci Code", "Dan Brown", "2003", CategoryBook.MYSTERY, TypeBook.EBOOK, true),
        Book(4,"The Alchemist", "Paulo Coelho", "1988", CategoryBook.FANTASY, TypeBook.PAPER_BOOK, true),
        Book(5,"The Great Gatsby", "F. Scott Fitzgerald", "1925", CategoryBook.OTHER, TypeBook.EBOOK, false),
    )
    val borrowerList = mutableListOf(
        User(1, "Alice", mutableListOf(booksList[0], booksList[1])),
        User(2, "Bob", mutableListOf(booksList[2])),
        User(3, "Charlie", mutableListOf(booksList[3])),
    )
}