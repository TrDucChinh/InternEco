package com.eco.interneco.task2.libsystem

import com.eco.interneco.task2.sampledata.SampleData
import com.eco.interneco.task2.utlis.Login
import com.eco.interneco.task2.utlis.Menu


class LibrarySystem {

    // companion object
    companion object {
        // enum class
        enum class ACCOUNT_ADMIN_INFO(val username: String, val password: String) {
            ADMIN("admin", "admin");
        }

        val booksList = SampleData.booksList
        var countRePas = 0
        val borrowedBooksList = booksList.filter { it.borrowed }.toMutableList()
        val borrowerList = SampleData.borrowerList
    }

}

fun main() {
    while (true) {
        Menu.mainMenu()
        val choose = readlnOrNull()?.toIntOrNull()
        when (choose) {
            1 -> {
                Login.adminLogin()
            }
            2 -> {
                val guest = Guest()
                guest.guestAction()
            }
            3 -> return
            else -> println("Invalid choice. Please choose again.")
        }
    }
}