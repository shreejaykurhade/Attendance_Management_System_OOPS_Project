package src;


import java.util.ArrayList;


public class Student extends User {
    private ArrayList<Subject> subjects; //arraylist concept


    public Student(String userId, String name) {  //use of super keyword to set student details
        super(userId, name);
        this.subjects = new ArrayList<>();
    }


    public void addSubject(Subject subject) {  //allot subject to student
        subjects.add(subject);
        System.out.println("Added subject " + subject.getSubjectName() + " for " + name);
    }


    public void markWeeklyAttendance(String subjectName, int weekNumber, int attendedLectures) {
        for (Subject subject : subjects) {  //use of for-each loop
            if (subject.getSubjectName().equals(subjectName)) {  
                subject.markWeeklyAttendance(weekNumber, attendedLectures);  //mark wwekly attendance
                return;
            }
        }
        System.out.println("Subject " + subjectName + " not found for " + name);
    }


    @Override
    public void viewAttendance() {
        System.out.println("Attendance report for " + name + ":");   //get attendance report for student
        for (Subject subject : subjects) {
            System.out.printf("Subject: %s, Attendance: %.2f%%\n",
                               subject.getSubjectName(), subject.getAttendancePercentage());
        }
    }


    public void generateMonthlyAttendanceReport() { //Include eligibility in report
        System.out.println("Monthly Attendance Report for " + name + ":");
        for (Subject subject : subjects) {
            double attendancePercentage = subject.getAttendancePercentage();
            String eligibility = subject.isEligible() ? "Eligible" : "Not Eligible";


            System.out.printf("Subject: %s, Attendance: %.2f%%, Status: %s\n",
                              subject.getSubjectName(), attendancePercentage, eligibility);
        }
    }
}
