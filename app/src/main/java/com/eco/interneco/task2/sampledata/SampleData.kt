import com.eco.interneco.task2.models.Book
import com.eco.interneco.task2.models.CategoryBook
import com.eco.interneco.task2.models.Magazine
import com.eco.interneco.task2.models.TypeBook
import com.eco.interneco.task2.models.TypeMagazine

// Singletons
object SampleData {
    val booksList = mutableListOf(
        Book(1,"Harry Potter", "J.K. Rowling", "1997", CategoryBook.FANTASY, TypeBook.EBOOK, true),
        Book(2,"The Lord of the Rings", "J.R.R. Tolkien", "1954", CategoryBook.FANTASY, TypeBook.PAPER_BOOK, true),
        Book(3,"The Da Vinci Code", "Dan Brown", "2003", CategoryBook.MYSTERY, TypeBook.EBOOK, true),
        Book(4,"The Alchemist", "Paulo Coelho", "1988", CategoryBook.FANTASY, TypeBook.PAPER_BOOK, true),
        Book(5,"The Great Gatsby", "F. Scott Fitzgerald", "1925", CategoryBook.OTHER, TypeBook.EBOOK, false),
    )

    val productList = mutableListOf(
        Book(1,"Harry Potter", "J.K. Rowling", "1997", CategoryBook.FANTASY, TypeBook.EBOOK, true),
        Book(2,"The Lord of the Rings", "J.R.R. Tolkien", "1954", CategoryBook.FANTASY, TypeBook.PAPER_BOOK, true),
        Book(3,"The Da Vinci Code", "Dan Brown", "2003", CategoryBook.MYSTERY, TypeBook.EBOOK, true),
        Book(4,"The Alchemist", "Paulo Coelho", "1988", CategoryBook.FANTASY, TypeBook.PAPER_BOOK, true),
        Book(5,"The Great Gatsby", "F. Scott Fitzgerald", "1925", CategoryBook.OTHER, TypeBook.EBOOK, false),
        Book(6, "The Catcher in the Rye", "J.D. Salinger", "1951", CategoryBook.OTHER, TypeBook.PAPER_BOOK, true),
        Book(7, "The Hobbit", "J.R.R. Tolkien", "1937", CategoryBook.FANTASY, TypeBook.EBOOK, true),
        Magazine(8, "Time", "Time USA, LLC", false, TypeMagazine.OTHER, "Zin", 1),
        Magazine(9, "National Geographic", "National Geographic Society", true, TypeMagazine.NATURAL_SCIENCE, "Zin", 1),

    )
    val borrowerList = mutableListOf(
        User(1, "David", mutableListOf(productList[0], productList[1])),
        User(2, "John", mutableListOf(productList[2], productList[3])),
        User(3, "Peter", mutableListOf(productList[5], productList[8])),
        User(4, "Mary", mutableListOf(productList[6])),
    )
}