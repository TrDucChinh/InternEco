package com.eco.interneco.task2.utlis

//Singleton class Menu
object Menu {
    fun mainMenu() {
        println("\nLibrary System")
        println("1. Admin")
        println("2. Guest")
        println("3. Exit")
        print("Choose option: ")
    }
    fun guestMenu() {
        println("\nGuest Menu")
        println("1. Show all books")
        println("2. Search book by title")
        println("3. Borrow books")
        println("4. Exit")
        print("Choose option: ")
    }
    fun adminMenu() {
        println("\nAdmin Menu")
        println("1. Show all books")
        println("2. Add new book")
        println("3. Update book")
        println("4. Delete book")
        println("5. Search book by title")
        println("6. Show borrowed books")
        println("7. Show borrowers")
        println("8. Exit")
        print("Choose option: ")
    }
    fun optionUpdateBook(){
        println("Choose option to update:")
        println("1. Update name")
        println("2. Update author")
        println("3. Update publish year")
        println("4. Update category")
        println("5. Update type")
        print("Choose option: ")
    }
    fun menuBorrowBook(){
        println("Choose option to borrow book:")
        println("1. Borrow book")
        println("2. Return book")
        print("Choose option: ")
    }
}