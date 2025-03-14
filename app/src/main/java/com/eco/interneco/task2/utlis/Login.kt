package com.eco.interneco.task2.utlis

import LibrarySystem.Companion.countRePas
import com.eco.interneco.task2.libsystem.Admin



object Login {
    fun adminLogin() {
        print("Enter username: ")
        val username = readlnOrNull()

        if (username == LibrarySystem.Companion.ACCOUNT_ADMIN_INFO.ADMIN.username) {
            print("Enter password: ")
            val password = readlnOrNull()
            if (password == LibrarySystem.Companion.ACCOUNT_ADMIN_INFO.ADMIN.password) {
                println("Login successfully")
                val admin = Admin()
                admin.adminAction()

            } else {
                do {
                    countRePas++
                    print("Re-enter password: ")
                    val rePassword = readlnOrNull()
                    if (rePassword == LibrarySystem.Companion.ACCOUNT_ADMIN_INFO.ADMIN.password) {
                        println("Login successfully\n")
                        val admin = Admin()
                        admin.adminAction()
                    } else {
                        println("Incorrect password")
                    }
                } while (countRePas != 3)
            }

        } else {
            println("Invalid username")
            adminLogin()
        }
    }
}