package com.eco.interneco.task1

class StudentManager {
    private val students = mutableListOf<Student>()

    init {
        students.addAll(SampleData.listSv)
    }

    fun addStudent() {
        val id = students.size + 1
        print("Nhập tên sinh viên: ")
        val name = readln()
        print("Nhập tuổi sinh viên: ")
        val age = readln().toInt()
        print("Nhập điểm trung bình: ")
        val gpa = readln().toFloat()
        print("Nhập giới tính: ")
        val gender = readln().first()
        val scholarship = gpa >= 8.0
        students.add(Student(id.toLong(), name, age, gpa, gender, scholarship))
        println("Thêm sinh viên thành công")
    }

    fun displayAllStudents(){
        students.forEach {
            println(it)
        }
//        for (student in students) {
//            println(student)
//        }
//
//        for (i in 0..<students.size) {
//            println(students[i])
//        }
    }

    fun displayStudentsByAge() {
        val listStudent = students.filter { it.age in 18..22 }.toMutableList()
        val listGraduate = students.filter { it.age > 22 }.toMutableList()
        val listUnder18 = students.filter { it.age < 18 }.toMutableList()

        println("Sinh viên từ 18-22 tuổi: ")
        listStudent.forEach {
            println(it)
        }
        println("Sinh viên lớn hơn 22 tuổi: ")
        listGraduate.forEach {
            println(it)
        }
        println("Sinh viên nhỏ hơn 18 tuổi: ")
        listUnder18.forEach {
            println(it)
        }

//        for (student in listStudent) {
//            if (student.age in 18..22) {
//                listStudent.add(student)
//            } else if (student.age > 22) {
//                listGraduate.add(student)
//            } else {
//                listUnder18.add(student)
//            }
//        }
//
//        for (i in 0..<students.size) {
//            val student = students[i]
//            if (student.age in 18..22) {
//                listStudent.add(student)
//            } else if (student.age > 22) {
//                listGraduate.add(student)
//            } else {
//                listUnder18.add(student)
//            }
//        }
    }

    fun displayStudentsWithScholarship() {
        val listScholarship = students.filter { it.scholarship }.toMutableList()
        println("Danh sách sinh viên có học bổng: ")
        listScholarship.forEach {
            println(it)
        }
    }

    fun calculateTotalGPA() {
        val totalGPA = students.map { it.gpa }.sum()
        println("Tổng điểm trung bình của tất cả sinh viên: $totalGPA")
    }

    fun displayFirstAndLastStudent() {
        val firstStudent = students.first()
        val lastStudent = students.last()
        println("Sinh viên đầu tiên: $firstStudent")
        println("Sinh viên cuối cùng: $lastStudent")
    }

    fun sortStudentsByGPA() {
        val svSortByGPA = students.sortedBy { -it.gpa }
        println("Danh sách sinh viên sắp xếp theo điểm trung bình giảm dần: ")
        svSortByGPA.forEach {
            println(it)
        }

//        val svSortByGPA = students.sortByDescending { it.gpa }
    }
    fun displayStudentsNameDistinct() {
        val listStudentDistinct = students.distinctBy { it.name }
        println("Danh sách sinh viên không trùng tên: ")
        listStudentDistinct.forEach {
            println(it)
        }
    }

    fun displayMapIdName() {
        println("Map ID và tên sinh viên: ")
        students.associateBy({it.id}, {it.name}).forEach {
            println("ID: ${it.key} - Name: ${it.value}")
        }
    }

    fun displayStudentName() {
        println("Danh sách tên sinh viên: ")
        students.map { it.name }.forEach {
            println(it)
        }

    }
}