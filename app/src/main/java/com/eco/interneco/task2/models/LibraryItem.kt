package com.eco.interneco.task2.models


abstract class LibraryItem(
    open val id: Long,
    open val name: String,
    open val publishDate: String,
    open val borrowed: Boolean
) {
    abstract fun getItemType(): String
    abstract fun getItemDetails(): String

    fun isAvailable(): Boolean {
        return !borrowed
    }

    open fun getDisplayInfo(): String {
        return "ID: $id | Name: $name | Published: $publishDate | Available: ${if (isAvailable()) "Yes" else "No"}"
    }
}