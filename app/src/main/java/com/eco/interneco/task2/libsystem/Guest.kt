package com.eco.interneco.task2.libsystem

import com.eco.interneco.task2.utlis.Menu


class Guest {
    private val manager = LibraryManager()
    //normal func
    fun guestAction() {
        while (true) {
            Menu.guestMenu()
            val choose = readlnOrNull()?.toIntOrNull()
            println()
            when (choose) {
                1 -> manager.showAllBooks()
                2 -> manager.searchBook()
                3 -> manager.borrowBook()
                4 -> {
                    println("Returning to main menu...")
                    return
                }
                else -> println("Invalid choice. Please choose again.")
            }
        }
    }
}