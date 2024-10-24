package src;

import java.util.ArrayList;

public class Admin extends User {
    private ArrayList<Student> students;     // Arraylist of students of class Student

    public Admin(String userId, String name) {
        super(userId, name);
        this.students = new ArrayList<>();
    }

    @Override   
    public void viewAttendance() {     // overriding the viewAttendance abstract method
        System.out.println("Admin " + name + " does not view attendance directly.");
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Added student " + student.getName());
    }

    public void deleteStudent(String studentId) {
        boolean found = false;
        for (Student student : students) {     // finding student object through the Arraylist and deleting it by id
            if (student.getUserId().equals(studentId)) {
                students.remove(student);
                System.out.println("Deleted student with ID " + studentId);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student with ID " + studentId + " not found.");
        }
    }

    public Student findStudentById(String studentId) {      // finding student by id
        for (Student student : students) {
            if (student.getUserId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    public void generateAttendanceReport() {     // printing Atttendance from Student.java method
        System.out.println("Generating attendance report...");
        for (Student student : students) {
            System.out.println("Student: " + student.getName());
            student.generateMonthlyAttendanceReport();
        }
    }
}
