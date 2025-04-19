package session_16_Hash.Homework;

enum Day{
    MONDAY(""),
    TUESDAY(""),
    WEDNESDAY(""),
    THURSDAY(""),
    FRIDAY(""),
    SATURDAY(""),
    SUNDAY("");

    private String activity;

    Day(String activity) {
        this.activity = activity;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    @Override
    public String toString() {
        return name() + " -> " + activity;
    }
}

public class DayScheduler {

    public void setActivity(Day day, String activity){
        day.setActivity(activity);
    }

    public void deleteActivity(Day day){
        day.setActivity("");
    }


    public void printSchedule() {
        for (Day day : Day.values()){
            System.out.println(day);
        }
    }

    public void printDay(Day day){
        System.out.println(day);
    }
}

class TestDayScheduler{
    public static void main(String[] args) {
        DayScheduler scheduler = new DayScheduler();
        scheduler.setActivity(Day.FRIDAY, "Gym");
        scheduler.setActivity(Day.TUESDAY, "Learn Java");
        scheduler.setActivity(Day.SUNDAY, "Read a book");
        scheduler.printSchedule();

        System.out.println();
        scheduler.deleteActivity(Day.FRIDAY);

        scheduler.printDay(Day.FRIDAY);
    }
}
