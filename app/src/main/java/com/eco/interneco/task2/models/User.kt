package com.eco.interneco.task2.models

data class User(
    val id: Long,
    val name: String,
    val listBookBorrowed: MutableList<Book>,
) {
    override fun toString(): String {
        return "id: $id\nname : $name\nlistBookBorrowed : \n${listBookBorrowed.joinToString("\n")}" +
                "\n============================="
    }

}