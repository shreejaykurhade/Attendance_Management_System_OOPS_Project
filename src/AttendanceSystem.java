package src;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AttendanceSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Admin admin = new Admin("A001", "Principal");
        Teacher teacher = new Teacher("T001", "Ayesha Maam");

        // Main loop for input and actions
        boolean running = true;
        while (running) {
            System.out.println("\n1. Add Student\n2. Mark Weekly Attendance\n3. View Attendance\n4. Generate Monthly Report\n5. Delete Student\n6. Exit");
            int choice = 0;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // clear the invalid input
                continue; // skip the rest of the loop
            }

            switch (choice) {
                case 1:
                    try {
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
                    } catch (Exception e) {
                        System.out.println("An error occurred while adding a student: " + e.getMessage());
                    }
                    break;

                case 2:
                    try {
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
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter the correct type of data.");
                        scanner.next(); // clear the invalid input
                    }
                    break;

                case 3:
                    try {
                        System.out.println("Enter student ID to view attendance:");
                        String viewStudentId = scanner.next();

                        // Find student and view attendance
                        Student viewStudent = admin.findStudentById(viewStudentId);
                        if (viewStudent != null) {
                            viewStudent.viewAttendance();
                        } else {
                            System.out.println("Student not found.");
                        }
                    } catch (Exception e) {
                        System.out.println("An error occurred while viewing attendance: " + e.getMessage());
                    }
                    break;

                case 4:
                    try {
                        admin.generateAttendanceReport();
                    } catch (Exception e) {
                        System.out.println("An error occurred while generating the report: " + e.getMessage());
                    }
                    break;

                case 5:
                    try {
                        System.out.println("Enter student ID to delete:");
                        String deleteStudentId = scanner.next();
                        admin.deleteStudent(deleteStudentId);
                    } catch (Exception e) {
                        System.out.println("An error occurred while deleting the student: " + e.getMessage());
                    }
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
