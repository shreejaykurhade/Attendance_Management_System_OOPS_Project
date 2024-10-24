package src;

public class Subject {   // 'final' keyword because these parameters are supposed to be fixed throughout
    private final String subjectName;
    private final int totalLecturesPerWeek;
    private final int[] attendedLecturesPerWeek;
    private static final int WEEKS_IN_MONTH = 4;

    public Subject(String subjectName, int totalLecturesPerWeek) {  //this is a parameterised constructor aka 'setters'
        this.subjectName = subjectName;  //Set the values of the class varaibles using 'this' keyword
        this.totalLecturesPerWeek = totalLecturesPerWeek;
        this.attendedLecturesPerWeek = new int[WEEKS_IN_MONTH];
    }

    public String getSubjectName() {    //return the subject name by 'getters'
        return subjectName;
    }

    public void markWeeklyAttendance(int weekNumber, int attendedLectures) {  //set number of lectures attended per week
        if (weekNumber >= 1 && weekNumber <= WEEKS_IN_MONTH) {
            attendedLecturesPerWeek[weekNumber - 1] = attendedLectures;
            System.out.println("Marked attendance for week " + weekNumber + " in subject: " + subjectName);
        } else {
            System.out.println("Invalid week number.");  //if week no. is entered wrong
        }
    }

    public int getTotalLecturesForMonth() {      //get the total no. of lectures conducted per month
        return totalLecturesPerWeek * WEEKS_IN_MONTH;
    }

    public int getTotalAttendedLecturesForMonth() {  //get the total no. of lectures attended by student per month
        int totalAttended = 0;
        for (int i = 0; i < WEEKS_IN_MONTH; i++) {     
            totalAttended += attendedLecturesPerWeek[i];   
        }
        return totalAttended;
    }

    public double getAttendancePercentage() {  //calculate attendance percentage
        int totalAttended = getTotalAttendedLecturesForMonth();
        int totalLectures = getTotalLecturesForMonth();
        return (double) totalAttended / totalLectures * 100;
    }

    public boolean isEligible() {   //Check for exam eligibilty
        return getAttendancePercentage() >= 75.0;  //return T or eligible if greater than 75% 
    }
}
