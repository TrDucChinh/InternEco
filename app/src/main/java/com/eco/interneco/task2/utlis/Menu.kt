package com.eco.interneco.task2.utlis

import com.eco.interneco.task2.models.TypeLibraryItem

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
        println("\nGuest")
        println("1. Show all books")
        println("2. Search product by title")
        println("3. Borrow books")
        println("4. Exit")
        print("Choose option: ")
    }
    fun adminMenu() {
        println("\nAdmin")
        println("1. Show all products")
        println("2. Add new product")
        println("3. Update product")
        println("4. Delete product")
        println("5. Search product by title")
        println("6. Show borrowed product")
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

    fun menuAddProduct(){
        println("Choose option to add product:")
        println(TypeLibraryItem.entries.joinToString("\n") { "${it.ordinal + 1}. ${it.name}" })
        println("${TypeLibraryItem.entries.size + 1}. Exit")
        print("Choose option: ")
    }

    fun menuUpdateProduct(){
        println("Choose option to update product:")
        println(TypeLibraryItem.entries.joinToString("\n") { "${it.ordinal + 1}. ${it.name}" })
        println("${TypeLibraryItem.entries.size + 1}. Exit")
        print("Choose option: ")
    }
}