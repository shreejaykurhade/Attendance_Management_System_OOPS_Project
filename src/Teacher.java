package src;

public class Teacher extends User {

    public Teacher(String userId, String name) {    
        super(userId, name);
    }

    @Override
    public void viewAttendance() {      // overriding viewAttendance abstract method 
        System.out.println("Teacher " + name + " is viewing attendance.");
    }

    public void markAttendanceForStudent(Student student, String subjectName, int weekNumber, int attendedLectures) {
        student.markWeeklyAttendance(subjectName, weekNumber, attendedLectures);
    }     // Marking weekly attendance from Student.java method
}
