package com.eco.interneco.task2.utlis

import com.eco.interneco.task2.models.Book
import com.eco.interneco.task2.models.User

fun Book.formatDisplay(): String {
    return """
        =================================
        ID: $id
        Title: $name
        Author: $author
        Published: $publishDate
        Category: $category
        Type: $type
        Status: ${if (borrowed) "Borrowed" else "Available"}
        =================================
    """.trimIndent()
}

fun User.addBorrowedBook(book: Book) {
    this.listBookBorrowed.add(book)
}

fun User.formatBorrowedBooks(): String {
    return if (listBookBorrowed.isEmpty()) {
        "No books borrowed"
    } else {
        listBookBorrowed.joinToString("\n") { it.formatDisplay() }
    }
}