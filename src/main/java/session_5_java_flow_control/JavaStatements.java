package session_5_java_flow_control;

public class JavaStatements {
    public static void main(String[] args) {
        String day = "Thuersday";

        if (day.equals("Monday")){
            System.out.println("today is Monday");
        } else if(day.equals("Tuesday")){
            System.out.println("today is Tuesday");
        } else if(day.equals("Wednesday")){
            System.out.println("today is Wednesday");
        } else if(day.equals("Thursday")){
            System.out.println("today is Thursday");
        } else if(day.equals("Friday")){
            System.out.println("today is Friday");
        } else if(day.equals("Saturday")){
            System.out.println("today is Saturday");
        } else if(day.equals("Sunday")){
            System.out.println("today is Sunday");
        } else {
            System.out.println("Invalid day");
        }
    }
}
