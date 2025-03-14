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
                1 -> manager.showAllProduct() // done
                2 -> manager.searchProduct() // done
                3 -> manager.borrowProduct() // done
                4 -> {
                    println("Returning to main menu...")
                    return
                }
                else -> println("Invalid choice. Please choose again.")
            }
        }
    }
}