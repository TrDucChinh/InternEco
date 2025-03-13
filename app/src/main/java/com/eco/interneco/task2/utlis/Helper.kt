package com.eco.interneco.task2.utlis

import com.eco.interneco.task2.models.CategoryBook
import com.eco.interneco.task2.models.TypeBook


// Singletons
object Helper {
    fun showOptionCategory(){
        print(CategoryBook.entries.withIndex().joinToString { "\n${it.index + 1}: ${it.value}" })
    }
    fun showOptionType(){
        print(TypeBook.entries.withIndex().joinToString { "\n${it.index + 1}: ${it.value}" })
    }

}