import com.eco.interneco.task2.models.LibraryItem


data class User(
    val id: Long,
    val name: String,
    val productBorrowedList: MutableList<LibraryItem>
) {
    override fun toString(): String {
        return "id: $id\nname : $name\nlistBookBorrowed : \n${productBorrowedList.joinToString("\n")}" +
                "\n============================="
    }

}
