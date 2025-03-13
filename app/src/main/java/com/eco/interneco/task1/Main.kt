package com.eco.interneco.task1

import com.eco.interneco.task1.Utils.showMenu


fun main() {
    val manager = StudentManager()
    while (true) {
        showMenu()
        print("Nhập lựa chọn: ")
        when (readln().toIntOrNull()) {
            1 -> manager.displayAllStudents()
            2 -> manager.addStudent()
            3 -> manager.displayStudentsByAge()
            4 -> manager.displayStudentsWithScholarship()
            5 -> manager.calculateTotalGPA()
            6 -> manager.displayFirstAndLastStudent()
            7 -> manager.sortStudentsByGPA()
            8 -> manager.displayStudentsNameDistinct()
            9 -> manager.displayMapIdName()
            10 -> manager.displayStudentName()
            11 -> {
                println("Thoát chương trình")
                return
            }
            else -> println("Lựa chọn không hợp lệ!")
        }
    }
}