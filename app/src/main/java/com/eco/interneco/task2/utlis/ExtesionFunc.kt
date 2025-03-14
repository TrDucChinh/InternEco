

import com.eco.interneco.task2.models.Book
import com.eco.interneco.task2.models.LibraryItem
import com.eco.interneco.task2.models.Magazine


fun Book.formatDisplay(): String {
    return """
        =================================
        ID: $id
        Title: $name
        Author: $author
        Published: $publishDate
        Category: $category
        Type: $type
        Status: ${if (borrowed) "Borrowed" else "Available"}
        =================================
    """.trimIndent()
}

fun Magazine.formatDisplay(): String {
    return """
        =================================
        ID: $id
        Title: $name
        Published: $publishDate
        Type: $type
        Publisher: $publisher
        Issue Number: $issueNumber
        Status: ${if (borrowed) "Borrowed" else "Available"}
        =================================
    """.trimIndent()
}

fun User.addBorrowedProduct(item: LibraryItem) {
    this.productBorrowedList.add(item)
}

fun User.formatBorrowed(): String {
    return if (productBorrowedList.isEmpty()) {
        "No product borrowed"
    } else {
        productBorrowedList.joinToString("\n") {
            when (it) {
                is Book -> {
                    it.formatDisplay()
                }

                is Magazine -> {
                    it.formatDisplay()
                }
                else -> {
                    ""
                }
            }
        }
    }
}