package src;

import java.util.Scanner;

public class AttendanceSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Admin admin = new Admin("A001", "Principal");
        Teacher teacher = new Teacher("T001", "Dr. Williams");

        // Main loop for input and actions
        boolean running = true;
        while (running) {
            System.out.println("\n1. Mark Weekly Attendance\n2. View Attendance\n3. Generate Monthly Report\n4. Add Student\n5. Delete Student\n6. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter student ID to mark weekly attendance:");
                    String studentId = scanner.next();
                    System.out.println("Enter subject name:");
                    String subjectName = scanner.next();
                    System.out.println("Enter week number (1-4):");
                    int weekNumber = scanner.nextInt();
                    System.out.println("Enter number of attended lectures:");
                    int attendedLectures = scanner.nextInt();

                    // Find student and mark weekly attendance
                    Student foundStudent = admin.findStudentById(studentId);
                    if (foundStudent != null) {
                        foundStudent.markWeeklyAttendance(subjectName, weekNumber, attendedLectures);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 2:
                    System.out.println("Enter student ID to view attendance:");
                    String viewStudentId = scanner.next();

                    // Find student and view attendance
                    Student viewStudent = admin.findStudentById(viewStudentId);
                    if (viewStudent != null) {
                        viewStudent.viewAttendance();
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 3:
                    admin.generateAttendanceReport();
                    break;
                case 4:
                    // Adding a student
                    System.out.println("Enter student ID:");
                    String newStudentId = scanner.next();
                    System.out.println("Enter student name:");
                    String newStudentName = scanner.next();
                    
                    Student newStudent = new Student(newStudentId, newStudentName);

                    // Adding subjects to the student
                    newStudent.addSubject(new Subject("ITVC", 4));
                    newStudent.addSubject(new Subject("OOPMT", 3));
                    newStudent.addSubject(new Subject("Data Structures", 4));
                    newStudent.addSubject(new Subject("Computer Architecture and Organization", 3));

                    admin.addStudent(newStudent);
                    break;
                case 5:
                    System.out.println("Enter student ID to delete:");
                    String deleteStudentId = scanner.next();
                    admin.deleteStudent(deleteStudentId);
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }

        scanner.close();
    }
}
