package src;

import java.util.ArrayList;

public class Student extends User {
    private ArrayList<Subject> subjects;

    public Student(String userId, String name) {
        super(userId, name);
        this.subjects = new ArrayList<>();
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
        System.out.println("Added subject " + subject.getSubjectName() + " for " + name);
    }

    public void markWeeklyAttendance(String subjectName, int weekNumber, int attendedLectures) {
        for (Subject subject : subjects) {
            if (subject.getSubjectName().equals(subjectName)) {
                subject.markWeeklyAttendance(weekNumber, attendedLectures);
                return;
            }
        }
        System.out.println("Subject " + subjectName + " not found for " + name);
    }

    @Override
    public void viewAttendance() {
        System.out.println("Attendance report for " + name + ":");
        for (Subject subject : subjects) {
            System.out.printf("Subject: %s, Attendance: %.2f%%\n", 
                               subject.getSubjectName(), subject.getAttendancePercentage());
        }
    }

    public void generateMonthlyAttendanceReport() {
        System.out.println("Monthly Attendance Report for " + name + ":");
        for (Subject subject : subjects) {
            double attendancePercentage = subject.getAttendancePercentage();
            String eligibility = subject.isEligible() ? "Eligible" : "Not Eligible";

            System.out.printf("Subject: %s, Attendance: %.2f%%, Status: %s\n", 
                              subject.getSubjectName(), attendancePercentage, eligibility);
        }
    }
}
