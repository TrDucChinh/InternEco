package com.eco.interneco.task1
data class Student(
    val id: Long,
    val name: String,
    val age: Int,
    val gpa: Float,
    val gender: Char,
    var scholarship: Boolean = gpa >= 8.0,
) {
    override fun toString(): String {
        return "id: $id - name: $name - age: $age - gpa: $gpa - gender: $gender - scholarship: $scholarship \n"
    }

}