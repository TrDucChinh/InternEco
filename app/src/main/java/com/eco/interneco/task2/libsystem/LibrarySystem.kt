import com.eco.interneco.task2.libsystem.Guest
import com.eco.interneco.task2.utlis.Login
import com.eco.interneco.task2.utlis.Menu


class LibrarySystem {

    // companion object
    companion object {
        // enum class
        enum class ACCOUNT_ADMIN_INFO(val username: String, val password: String) {
            ADMIN("admin", "admin");
        }
        var countRePas = 0
        val borrowerList = SampleData.borrowerList
        val productList = SampleData.productList
        val borrowedProductList = productList.filter { it.borrowed }.toMutableList()

    }

}

fun main() {
    while (true) {
        Menu.mainMenu()
        val choose = readlnOrNull()?.toIntOrNull()
        when (choose) {
            1 -> {
                Login.adminLogin()
            }

            2 -> {
                val guest = Guest()
                guest.guestAction()
            }

            3 -> return
            else -> println("Invalid choice. Please choose again.")
        }
    }
}