package com.eco.interneco.task2.libsystem

import com.eco.interneco.task2.utlis.Menu


class Admin {
    private val manager = LibraryManager()
    //normal func
    fun adminAction() {
        while (true) {
            Menu.adminMenu()
            val choose = readlnOrNull()?.toIntOrNull()
            println()
            when (choose) {
                1 -> manager.showAllBooks() // done
                2 -> manager.addBook() // done
                3 -> manager.updateBook() // done
                4 -> manager.deleteBook() // done
                5 -> manager.searchBook() // done
                6 -> manager.showBorrowedBooks() //done
                7 -> manager.showBorrower() //done
                8 -> {
                    println("Returning to main menu...")
                    return
                }

                else -> println("Invalid choice. Please choose again.")
            }
        }
    }
}