package src;

public class Subject {
    private final String subjectName;
    private final int totalLecturesPerWeek;
    private final int[] attendedLecturesPerWeek;
    private static final int WEEKS_IN_MONTH = 4;

    public Subject(String subjectName, int totalLecturesPerWeek) {
        this.subjectName = subjectName;
        this.totalLecturesPerWeek = totalLecturesPerWeek;
        this.attendedLecturesPerWeek = new int[WEEKS_IN_MONTH];
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void markWeeklyAttendance(int weekNumber, int attendedLectures) {
        if (weekNumber >= 1 && weekNumber <= WEEKS_IN_MONTH) {
            attendedLecturesPerWeek[weekNumber - 1] = attendedLectures;
            System.out.println("Marked attendance for week " + weekNumber + " in subject: " + subjectName);
        } else {
            System.out.println("Invalid week number.");
        }
    }

    public int getTotalLecturesForMonth() {
        return totalLecturesPerWeek * WEEKS_IN_MONTH;
    }

    public int getTotalAttendedLecturesForMonth() {
        int totalAttended = 0;
        for (int i = 0; i < WEEKS_IN_MONTH; i++) {
            totalAttended += attendedLecturesPerWeek[i];
        }
        return totalAttended;
    }

    public double getAttendancePercentage() {
        int totalAttended = getTotalAttendedLecturesForMonth();
        int totalLectures = getTotalLecturesForMonth();
        return (double) totalAttended / totalLectures * 100;
    }

    public boolean isEligible() {
        return getAttendancePercentage() >= 75.0;
    }
}
