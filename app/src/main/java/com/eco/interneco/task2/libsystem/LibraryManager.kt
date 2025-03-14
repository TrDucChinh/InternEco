package com.eco.interneco.task2.libsystem

import LibrarySystem
import com.eco.interneco.task2.models.Magazine
import User
import addBorrowedProduct
import com.eco.interneco.task2.IActions
import com.eco.interneco.task2.models.Book
import com.eco.interneco.task2.models.CategoryBook
import com.eco.interneco.task2.models.LibraryItem
import com.eco.interneco.task2.models.TypeBook
import com.eco.interneco.task2.models.TypeMagazine
import com.eco.interneco.task2.utlis.Helper
import com.eco.interneco.task2.utlis.Menu
import formatBorrowed
import formatDisplay


class LibraryManager : IActions {
    override fun addProduct() {
        inputNewProduct()
//        inputNewBook()
    }

    override fun showAllProduct() {
//        LibrarySystem.booksList.forEach {
//            println(it.formatDisplay())
////            println(it.getItemType())
//        }
        LibrarySystem.productList.forEach {
            when (it) {
                is Book -> println(it.formatDisplay())
                is Magazine -> println(it.formatDisplay())
            }
        }
    }

    private fun showAllBook() {
        LibrarySystem.productList.forEach {
            if (it is Book) {
                println(it.formatDisplay())
            }
        }
    }

    private fun showAllMagazine() {
        LibrarySystem.productList.forEach {
            if (it is Magazine) {
                println(it.formatDisplay())
            }
        }
    }

    override fun updateProduct() {
//        inputUpdateBook()
        inputUpdateProduct()
    }

    override fun deleteProduct() {
        showAllProduct()
        inputDeleteProduct()
    }

    override fun showBorrower() {
        println("Borrower list:")
        LibrarySystem.borrowerList.forEach {
            println("\nName: ${it.name}")
            println(it.formatBorrowed())
        }
    }


    override fun borrowProduct() {
        showAllProduct()
        while (true) {
            print("Enter product id to borrow: ")
            val id = readln().toLongOrNull()
            if (id != null) {
                val product = findProductById(id)
                if (product != null) {
                    if (product.borrowed) {
                        println("Product is borrowed. Please choose another product.")
                    } else {
                        print("Enter borrower name: ")
                        val borrowerName = readln()
                        LibrarySystem.productList.replaceAll {
                            when (it) {
                                is Book -> {
                                    if (it.id == product.id) {
                                        it.copy(borrowed = true)
                                    } else {
                                        it
                                    }
                                }

                                is Magazine -> {
                                    if (it.id == product.id) {
                                        it.copy(borrowed = true)
                                    } else {
                                        it
                                    }
                                }

                                else -> it
                            }
                        }
                        LibrarySystem.borrowedProductList.add(
                            when (product) {
                                is Book -> product.copy(borrowed = true)
                                is Magazine -> product.copy(borrowed = true)
                                else -> product
                            }
                        )
                        val newUser = User(
                            LibrarySystem.borrowerList.size.toLong() + 1,
                            borrowerName,
                            mutableListOf()
                        )
                        newUser.addBorrowedProduct(product)
                        LibrarySystem.borrowerList.add(newUser)

                        println("Product borrowed successfully.")
                    }
                    break
                } else {
                    println("Product not found. Please enter again.")
                }
            } else {
                println("Invalid id. Please enter again.")
            }
        }

    }


    override fun searchProduct() {
        while (true) {
            print("Enter product name to search: ")
            val query = readln()
            if (query.isEmpty()) {
                println("Query is empty. Please enter again.")
            } else {
                val result =
                    LibrarySystem.productList.filter { it.name.contains(query, ignoreCase = true) }
                if (result.isEmpty()) {
                    println("No product found.")
                } else {
                    result.forEach {
                        when (it) {
                            is Book -> println(it.formatDisplay())
                            is Magazine -> println(it.formatDisplay())
                        }
                    }
                }
                break
            }
        }

    }


    override fun showBorrowedBooks() {
        println("Borrowed product:")
        LibrarySystem.borrowedProductList.forEach {
            when (it) {
                is Book -> println(it.formatDisplay())
                is Magazine -> println(it.formatDisplay())
            }
        }
    }


    private fun inputNewProduct() {
        while (true) {
            Menu.menuAddProduct()
            val option = readln().toIntOrNull()
            when (option) {
                1 -> inputNewBook()
                2 -> inputNewMagazine()
                3 -> break
                else -> println("Invalid option. Please enter again.")
            }

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
            Helper.showOptionBookCategory()
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
            Helper.showOptionBookType()

            print("\nChoose option: ")
            type = readln().toIntOrNull()
            if (type in 1..TypeBook.entries.size) break
            println("Invalid type. Please enter again.")
        }
        LibrarySystem.productList.add(
            // name Argument
            Book(
                id = LibrarySystem.productList.size.toLong() + 1,
                name = name,
                author = author,
                publishDate = publishYear,
                category = CategoryBook.entries[category!! - 1],
                type = TypeBook.entries[type!! - 1],
                borrowed = false
            )
        )
    }

    private fun inputNewMagazine() {
        print("Enter magazine name: ")
        val name = readln()
        print("Enter publisher: ")
        val publisher = readln()
        print("Enter issue number: ")
        val issueNumber = readln()
        print("Enter publish year: ")
        val publishYear = readln()
        var type: Int?
        while (true) {
            print("\nEnter type: ")
            Helper.showOptionMagazineType()
            print("\nChoose option: ")
            type = readln().toIntOrNull()
            if (type in 1..TypeMagazine.entries.size) break
            println("Invalid type. Please enter again.")
        }
        LibrarySystem.productList.add(
            Magazine(
                id = LibrarySystem.productList.size.toLong() + 1,
                name = name,
                publishDate = publishYear,
                borrowed = false,
                type = TypeMagazine.entries[type!! - 1],
                publisher = publisher,
                issueNumber = issueNumber.toInt()
            )
        )

    }

    private fun inputDeleteProduct() {
        while (true) {
            print("\nEnter product id to remove: ")
            val id = readln().toLongOrNull()
            if (id != null) {
                val product = findProductById(id)
                if (product != null) {
                    LibrarySystem.productList.remove(product)
                    println("Product removed successfully.")
                    break
                } else {
                    println("Product not found. Please enter again.")
                }
            } else {
                println("Invalid id. Please enter again.")
            }
        }
    }

    private fun inputUpdateBook() {
        showAllBook()
        while (true) {
            print("\nEnter book id to update: ")
            val id = readln().toLongOrNull()
            if (id != null) {
                val book = findProductById(id) as Book?
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

    private fun inputUpdateMagazine() {
        showAllMagazine()
        while (true) {
            print("\nEnter magazine id to update: ")
            val id = readln().toLongOrNull()
            if (id != null) {
                val magazine = findProductById(id) as Magazine?
                if (magazine != null) {
                    println("Magazine information: $magazine")
                    while (true) {
                        Menu.optionUpdateBook()
                        val option = readln().toIntOrNull()
                        if (option in 1..5) {
                            checkOption(option!!, magazine)
                            println("Magazine updated successfully.")
                            break
                        } else {
                            println("Invalid option. Please enter again.")
                        }
                    }
                    break
                } else {
                    println("Magazine not found. Please enter again.")
                }
            } else {
                println("Invalid id. Please enter again.")
            }
        }
    }

    private fun inputUpdateProduct() {
        while (true) {
            Menu.menuUpdateProduct()
            val option = readln().toIntOrNull()
            when (option) {
                1 -> inputUpdateBook()
                2 -> inputUpdateMagazine()
                3 -> break
                else -> println("Invalid option. Please enter again.")
            }
        }
    }

    private fun checkOption(option: Int, product: LibraryItem) {
        when (product) {
            is Book -> {
                checkOptionBook(option, product)
            }

            is Magazine -> {
                checkOptionMagazine(option, product)
            }
        }
    }

    private fun checkOptionBook(option: Int, book: LibraryItem) {
        when (option) {
            1 -> {
                print("Enter new name: ")
                val name = readln()
                LibrarySystem.productList.replaceAll {
                    if (it is Book) {
                        if (it.id == book.id) {
                            it.copy(name = name)
                        } else {
                            it
                        }
                    } else {
                        it
                    }
                }
            }

            2 -> {
                print("Enter new author: ")
                val author = readln()
                LibrarySystem.productList.replaceAll {
                    if (it is Book) {
                        if (it.id == book.id) {
                            it.copy(author = author)
                        } else {
                            it
                        }
                    } else {
                        it
                    }
                }
            }

            3 -> {
                print("Enter new publish year: ")
                val publishYear = readln()
                LibrarySystem.productList.replaceAll {
                    if (it is Book) {
                        if (it.id == book.id) {
                            it.copy(publishDate = publishYear)
                        } else {
                            it
                        }
                    } else {
                        it
                    }
                }

            }

            4 -> {
                var category: Int?
                while (true) {
                    print("\nEnter new category: ")
                    Helper.showOptionBookType()
                    print("\nChoose option: ")
                    category = readln().toIntOrNull()
                    if (category in 1..CategoryBook.entries.size) break
                    println("Invalid category. Please enter again.")
                }
                LibrarySystem.productList.replaceAll {
                    if (it is Book) {
                        if (it.id == book.id) {
                            it.copy(category = CategoryBook.entries[category!! - 1])
                        } else {
                            it
                        }
                    } else {
                        it
                    }
                }
            }

            5 -> {
                var type: Int?
                while (true) {
                    print("\nEnter new type: ")
                    Helper.showOptionBookType()
                    print("\nChoose option: ")
                    type = readln().toIntOrNull()
                    if (type in 1..TypeBook.entries.size) break
                    println("Invalid type. Please enter again.")
                }
                LibrarySystem.productList.replaceAll {
                    if (it is Book) {
                        if (it.id == book.id) {
                            it.copy(type = TypeBook.entries[type!! - 1])
                        } else {
                            it
                        }
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

    private fun checkOptionMagazine(option: Int, magazine: LibraryItem) {
        when (option) {
            1 -> {
                print("Enter new name: ")
                val name = readln()
                LibrarySystem.productList.replaceAll {
                    if (it is Magazine) {
                        if (it.id == magazine.id) {
                            it.copy(name = name)
                        } else {
                            it
                        }
                    } else {
                        it
                    }
                }
            }

            2 -> {
                print("Enter new publisher: ")
                val publisher = readln()
                LibrarySystem.productList.replaceAll {
                    if (it is Magazine) {
                        if (it.id == magazine.id) {
                            it.copy(publisher = publisher)
                        } else {
                            it
                        }
                    } else {
                        it
                    }
                }
            }

            3 -> {
                print("Enter new issue number: ")
                val issueNumber = readln()
                LibrarySystem.productList.replaceAll {
                    if (it is Magazine) {
                        if (it.id == magazine.id) {
                            it.copy(issueNumber = issueNumber.toInt())
                        } else {
                            it
                        }
                    } else {
                        it
                    }
                }

            }

            4 -> {
                print("Enter new publish year: ")
                val publishYear = readln()
                LibrarySystem.productList.replaceAll {
                    if (it is Magazine) {
                        if (it.id == magazine.id) {
                            it.copy(publishDate = publishYear)
                        } else {
                            it
                        }
                    } else {
                        it
                    }
                }

            }

            5 -> {
                var type: Int?
                while (true) {
                    print("\nEnter new type: ")
                    Helper.showOptionMagazineType()
                    print("\nChoose option: ")
                    type = readln().toIntOrNull()
                    if (type in 1..TypeMagazine.entries.size) break
                    println("Invalid type. Please enter again.")
                }
                LibrarySystem.productList.replaceAll {
                    if (it is Magazine) {
                        if (it.id == magazine.id) {
                            it.copy(type = TypeMagazine.entries[type!! - 1])
                        } else {
                            it
                        }
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

    private fun findProductById(id: Long): LibraryItem? {
        return LibrarySystem.productList.find { it.id == id }
    }

}