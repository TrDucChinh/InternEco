package com.eco.interneco.task2.models

// Enum class
enum class TypeBook {
    EBOOK,
    PAPER_BOOK
}

enum class CategoryBook {
    FANTASY,
    MYSTERY,
    OTHER,
}

// Data class
data class Book(
    override val id: Long,
    override val name: String,
    val author: String,
    override val publishDate: String,
    val category: CategoryBook,
    val type: TypeBook,
    override val borrowed: Boolean,
) : LibraryItem(id, name, publishDate, borrowed) {
    override fun getItemType(): String {
        return  "Book"
    }

    override fun getItemDetails(): String {
        return "Author: $author | Category: $category | Type: $type"
    }

    override fun getDisplayInfo(): String {
        return "ID: $id | Name: $name | Author: $author | Published: $publishDate | Category: $category | Type: $type | Available: ${if (isAvailable()) "Yes" else "No"}"
    }
    override fun toString(): String {
        return "id: $id," +
                "name : $name, " +
                "author : $author, " +
                "publishDate : $publishDate, " +
                "category : $category, " +
                "type : $type, " +
                "borrowed : ${if (borrowed) "Yes" else "No"}\n"
    }
}