package com.eco.interneco.task2.utlis

import com.eco.interneco.task2.models.TypeMagazine
import com.eco.interneco.task2.models.CategoryBook
import com.eco.interneco.task2.models.TypeBook

// Singletons
object Helper {
    fun showOptionBookCategory(){
        print(CategoryBook.entries.withIndex().joinToString { "\n${it.index + 1}: ${it.value}" })
    }
    fun showOptionBookType(){
        print(TypeBook.entries.withIndex().joinToString { "\n${it.index + 1}: ${it.value}" })
    }

    fun showOptionMagazineType(){
        print(TypeMagazine.entries.withIndex().joinToString { "\n${it.index + 1}: ${it.value}" })
    }



}