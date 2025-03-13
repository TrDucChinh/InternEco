package com.eco.interneco.task2.libsystem

import com.eco.interneco.task2.IActions
import com.eco.interneco.task2.models.Book
import com.eco.interneco.task2.models.CategoryBook
import com.eco.interneco.task2.models.TypeBook
import com.eco.interneco.task2.models.User
import com.eco.interneco.task2.utlis.Helper
import com.eco.interneco.task2.utlis.Menu
import com.eco.interneco.task2.utlis.addBorrowedBook
import com.eco.interneco.task2.utlis.formatBorrowedBooks
import com.eco.interneco.task2.utlis.formatDisplay


class LibraryManager : IActions {
    override fun addBook() {
        inputNewBook()
    }

    override fun showAllBooks() {
        LibrarySystem.booksList.forEach {
            println(it.formatDisplay())
        }
    }

    override fun updateBook() {
        showAllBooks()
        inputUpdateBook()
    }

    override fun deleteBook() {
        showAllBooks()
        inputDeleteBook()
    }

    override fun showBorrower() {
        println("Borrower list:")
        LibrarySystem.borrowerList.forEach {
            println(it.formatBorrowedBooks())
        }
    }


    override fun borrowBook() {
        showAllBooks()
        while (true) {
            print("Enter book id to borrow: ")
            val id = readln().toLongOrNull()
            if (id != null) {
                val book = findBookById(id)
                if (book != null) {
                    if (book.borrowed) {
                        println("Book is borrowed. Please choose another book.")
                    } else {
                        print("Enter borrower name: ")
                        val borrowerName = readln()
                        LibrarySystem.booksList.replaceAll {
                            if (it.id == book.id) {
                                it.copy(borrowed = true)
                            } else {
                                it
                            }
                        }
                        LibrarySystem.borrowedBooksList.add(book.copy(borrowed = true))
                        val newUser = User(
                            LibrarySystem.borrowerList.size.toLong() + 1,
                            borrowerName,
                            mutableListOf()
                        )
                        newUser.addBorrowedBook(book)
                        LibrarySystem.borrowerList.add(newUser)

                        println("Book borrowed successfully.")
                    }
                    break
                } else {
                    println("Book not found. Please enter again.")
                }
            } else {
                println("Invalid id. Please enter again.")
            }
        }

    }


    override fun searchBook() {
        while (true) {
            print("Enter book name to search: ")
            val query = readln()
            if (query.isEmpty()) {
                println("Query is empty. Please enter again.")
            } else {
                val result = LibrarySystem.booksList.filter { it.name.contains(query, ignoreCase = true) }
                if (result.isEmpty()) {
                    println("No book found.")
                } else {
                    result.forEach {
                        println(it.formatDisplay())
                    }
                }
                break
            }
        }

    }


    override fun showBorrowedBooks() {
        println("Borrowed books:")
        LibrarySystem.borrowedBooksList.forEach {
            println(it.formatDisplay())
        }
    }


    private fun inputNewBook() {
        print("Enter book name: ")
        val name = readln()
        print("Enter author: ")
        val author = readln()
        var category: Int?
        while (true) {
            print("\nEnter category: ")
            Helper.showOptionCategory()
            print("\nChoose option: ")
            category = readln().toIntOrNull()
            if (category in 1..CategoryBook.entries.size) break
            println("Invalid category. Please enter again.")
        }
        print("Enter publish year: ")
        val publishYear = readln()
        var type: Int?
        while (true) {
            print("\nEnter type: ")
            Helper.showOptionType()

            print("\nChoose option: ")
            type = readln().toIntOrNull()
            if (type in 1..TypeBook.entries.size) break
            println("Invalid type. Please enter again.")
        }
        LibrarySystem.booksList.add(
            // name Argument
            Book(
                id = LibrarySystem.booksList.size.toLong(),
                name = name,
                author = author,
                publishDate = publishYear,
                category = CategoryBook.entries[category!! - 1],
                type = TypeBook.entries[type!! - 1],
                borrowed = false
            )
        )
    }

    private fun inputDeleteBook() {
        while (true) {
            print("\nEnter book id to remove: ")
            val id = readln().toLongOrNull()
            if (id != null) {
                val book = findBookById(id)
                if (book != null) {
                    LibrarySystem.booksList.remove(book)
                    println("Book removed successfully.")
                    break
                } else {
                    println("Book not found. Please enter again.")
                }
            } else {
                println("Invalid id. Please enter again.")
            }
        }
    }

    private fun inputUpdateBook() {
        while (true) {
            print("\nEnter book id to update: ")
            val id = readln().toLongOrNull()
            if (id != null) {
                val book = findBookById(id)
                if (book != null) {
                    println("Book information: $book")
                    while (true) {
                        Menu.optionUpdateBook()
                        val option = readln().toIntOrNull()
                        if (option in 1..5) {
                            checkOption(option!!, book)
                            println("Book updated successfully.")
                            break
                        } else {
                            println("Invalid option. Please enter again.")
                        }
                    }
                    break
                } else {
                    println("Book not found. Please enter again.")
                }
            } else {
                println("Invalid id. Please enter again.")
            }
        }
    }

    private fun checkOption(option: Int, book: Book) {
        when (option) {
            1 -> {
                print("Enter new name: ")
                val name = readln()
                LibrarySystem.booksList.replaceAll {
                    if (it.id == book.id) {
                        it.copy(name = name)
                    } else {
                        it
                    }
                }
            }

            2 -> {
                print("Enter new author: ")
                val author = readln()
                LibrarySystem.booksList.replaceAll {
                    if (it.id == book.id) {
                        it.copy(author = author)
                    } else {
                        it
                    }
                }
            }

            3 -> {
                print("Enter new publish year: ")
                val publishYear = readln()
                LibrarySystem.booksList.replaceAll {
                    if (it.id == book.id) {
                        it.copy(publishDate = publishYear)
                    } else {
                        it
                    }
                }

            }

            4 -> {
                var category: Int?
                while (true) {
                    print("\nEnter new category: ")
                    Helper.showOptionCategory()
                    print("\nChoose option: ")
                    category = readln().toIntOrNull()
                    if (category in 1..CategoryBook.entries.size) break
                    println("Invalid category. Please enter again.")
                }
                LibrarySystem.booksList.replaceAll {
                    if (it.id == book.id) {
                        it.copy(category = CategoryBook.entries[category!! - 1])
                    } else {
                        it
                    }
                }
            }

            5 -> {
                var type: Int?
                while (true) {
                    print("\nEnter new type: ")
                    Helper.showOptionType()
                    print("\nChoose option: ")
                    type = readln().toIntOrNull()
                    if (type in 1..TypeBook.entries.size) break
                    println("Invalid type. Please enter again.")
                }
                LibrarySystem.booksList.replaceAll {
                    if (it.id == book.id) {
                        it.copy(type = TypeBook.entries[type!! - 1])
                    } else {
                        it
                    }
                }
            }

            else -> {
                println("Invalid option. Please enter again.")
            }
        }
    }

    private fun findBookById(id: Long): Book? {
        return LibrarySystem.booksList.find { it.id == id }
    }
}