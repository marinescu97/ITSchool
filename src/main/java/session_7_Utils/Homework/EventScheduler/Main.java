package session_7_Utils.Homework.EventScheduler;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner input = new Scanner(System.in);
    private static boolean exit = false;
    private static final Scheduler scheduler = new Scheduler();
    private static final String pattern = "yyyy-MM-dd HH:mm";

    public static void main(String[] args) {
        Event doctorAppointment = new Event("Doctor's Appointment", "Check-up with Dr. Smith",
                LocalDateTime.of(2025, 4, 15, 10, 30),
                LocalDateTime.of(2025, 4, 14, 10, 30));
        Event carService = new Event("Car maintenance service", "Changing oil",
                LocalDateTime.of(2025, 3, 28, 9, 0));

        scheduler.addEvent(doctorAppointment);
        scheduler.addEvent(carService);

        do {
            showMenu();
        } while (!exit);
        input.close();
    }

    public static void showMenu(){
        System.out.println("""
                
                1 - Add event
                2 - Remove event
                3 - Get all events
                4 - Get all reminders
                5 - Upcoming events
                6 - Get events from a date
                0 - Exit
                """);
        System.out.print("Choice: ");
        int choice = input.nextInt();
        input.nextLine();

        handleChoice(choice);
    }

    public static void handleChoice(int choice){
        switch (choice){
            case 1 -> addEvent();
            case 2 -> removeEvent();
            case 3 -> getAllEvents();
            case 4 -> getReminders();
            case 5 -> getUpcomingEvents();
            case 6 -> getEventsByDate();
            case 0 -> exit = true;
            default -> System.out.println("Please insert a number from the menu.");
        }
    }

    public static void addEvent(){
        System.out.print("Event name: ");
        String name = input.nextLine();

        System.out.print("Event description: ");
        String description = input.nextLine();

        String eventDate = "", reminderDate = "";

        do{
            if (!isValidDate(eventDate, pattern)){
                System.out.print("Event date and time (" + pattern + "): ");
                eventDate = input.nextLine();
            }
            if (!isValidDate(reminderDate, pattern)) {
                System.out.print("Reminder date and time (" + pattern + "): ");
                reminderDate = input.nextLine();
            }

            if (!isValidDate(eventDate, pattern) || !isValidDate(reminderDate, pattern)){
                System.out.println("Please enter a valid date and time");
            }
        } while (!isValidDate(eventDate, pattern) && !isValidDate(reminderDate, pattern));

        LocalDateTime eDate = LocalDateTime.parse(eventDate, DateTimeFormatter.ofPattern(pattern));
        LocalDateTime rDate = LocalDateTime.parse(reminderDate, DateTimeFormatter.ofPattern(pattern));

        Event event = new Event(name, description, eDate, rDate);

        if (scheduler.addEvent(event)){
            System.out.println("Event added successfully!");
        }
    }

    public static void removeEvent(){
        System.out.print("Event name: ");
        String name = input.nextLine();

        if (scheduler.removeEvent(name)){
            System.out.println("The event was removed successfully");
        } else {
            System.out.println("The event doesn't exist in the list.");
        }
    }

    public static void getAllEvents(){
        if (scheduler.getEvents().isEmpty()){
            System.out.println("There are no events yet.");
        } else {
            System.out.println("\nEvents: ");
            for (Event event : scheduler.getEvents()){
                System.out.println(event);
            }
        }
    }

    public static void getReminders(){
        List<Event> reminders = scheduler.getPendingReminders();

        if (reminders.isEmpty()){
            System.out.println("You have no events to remind.");
        } else {
            for (Event event : reminders){
                System.out.println("You have a reminder for " + event);
            }
        }
    }

    public static void getUpcomingEvents(){
        System.out.print("The number of events: ");
        int number = input.nextInt();
        input.nextLine();

        Event[] eventList = scheduler.getUpcomingEvents(number);

        if (eventList.length > 0){
            for (Event event : eventList){
                System.out.println(event);
            }
        } else {
            System.out.println("There are no upcoming events.");
        }
    }

    public static void getEventsByDate(){
        String date;
        boolean validDate;
        do {
            System.out.print("Insert the date (yyyy-MM-dd): ");
            date = input.next();

            validDate = isValidDate(date, "yyyy-MM-dd");

            if (!validDate){
                System.out.println("The date is not valid!");
            }
        } while (!validDate);

        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        List<Event> eventList = scheduler.getEventsOn(localDate);

        if (eventList.isEmpty()){
            System.out.println("There are no events on " + localDate);
        } else {
            System.out.println("Events:");
            for (Event event : eventList){
                System.out.println(event);
            }
        }
    }

    public static boolean isValidDate(String date, String pattern){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

        try {
            formatter.parse(date);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
