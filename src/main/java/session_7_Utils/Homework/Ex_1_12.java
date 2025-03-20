package session_7_Utils.Homework;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Ex_1_12 {
    private final Scanner input = new Scanner(System.in);
    private final String dateFormat = "yyyy-MM-dd";

    /*
        Displaying Today's Date
        Write a method named displayTodaysDate that, when called, prints the current date to the console.
        Expected Output: Today's date in the format YYYY-MM-DD.
    */

    public void displayTodaysDate(){
        System.out.println(LocalDate.now());
    }

    /*
        Date Decomposition
        Write a method named displayDateComponents that accepts a date as an argument
        and prints its year, month, and day components separately.
        Input: A date in the format YYYY-MM-DD.
        Expected Output:
        makefile
        Copy code
        Year: YYYY
        Month: MM
        Day: DD
     */

    public void displayDateComponents(LocalDate date){
        System.out.printf("""
                Year: %d
                Month: %d
                Day: %d
                """, date.getYear(), date.getMonthValue(), date.getDayOfMonth());
    }

    /*
        Create a Specific Date
        Write a method named createSpecificDate that returns a date object representing 19th August 2025.
        Expected Output: A date object for 2025-8-19.
     */

    public LocalDate createSpecificDate(){
        return LocalDate.of(2025, 8, 19);
    }

    /*
        Comparing User-Entered Dates
        Write a method named areDatesEqual that reads two dates from the console and returns true
        if they are equal, and false otherwise.
        Input: Two dates entered by the user in the format YYYY-MM-DD.
        Expected Output:
        true if both dates are equal.
        false if they are different.
     */

    public boolean isValidDate(String date, String pattern){
        DateFormat formatter = new SimpleDateFormat(pattern);
        formatter.setLenient(false);

        try {
            formatter.parse(date);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    public boolean areDatesEqual(){
        System.out.print("Please insert a date: ");
        String firstStringDate = input.next();

        System.out.print("Please insert another date: ");
        String secondStringDate = input.next();

        input.close();

        if (isValidDate(firstStringDate, dateFormat) && isValidDate(secondStringDate, dateFormat)){
            LocalDate firstDate = LocalDate.parse(firstStringDate);
            LocalDate secondDate = LocalDate.parse(secondStringDate);

            return firstDate.equals(secondDate);
        }

        System.out.println("Invalid date format!");
        return false;
    }

    /*
        Is Today a Specific Date?
        Write a method named isTodaySpecificDate that checks if today's date is 10th December 2019.
        Expected Output:
        true if today's date is 2019-12-10.
        false otherwise.
     */

    public boolean isTodaySpecificDate(){
        LocalDate todaysDate = LocalDate.now();
        LocalDate specificDate = LocalDate.of(2019, 12, 10);

        return todaysDate.equals(specificDate);
    }

    /*
        Getting Current Time
        Write a method named displayCurrentTime that prints the current time to the console.
        Expected Output: The current time in the format HH:MM:SS.
     */

    public void displayCurrentTime(){
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        System.out.println(currentTime.format(formatter));
    }

    /*
        Date Arithmetic
        Write a method named addWeeksToToday that accepts an integer as its argument.
        This integer denotes the number of weeks.
        The method should add this number of weeks to today's date and return the resultant date.
        Input: An integer n (e.g., 4).
        Expected Output: A date object that is n weeks from today.
     */

    public LocalDate addWeeksToToday(int weeks){
        LocalDate today = LocalDate.now();
        return today.plusWeeks(weeks);
    }

    /*
        Weekday Identifier
        Construct a method named findDayOfWeek that takes in a date
        and returns the specific day of the week (e.g., Monday, Tuesday, etc.) for that date.
        Input: A date in the format YYYY-MM-DD.
        Expected Output: The day of the week in string format (e.g., "Wednesday").
     */

    public String findDayOfWeek(LocalDate date){
        return date.getDayOfWeek().toString();
    }

    /*
        Interval Between Dates
        Design a method titled daysBetween that reads two dates from the console
        and computes the total number of days between them.
        Input: Two dates given by the user in the format YYYY-MM-DD.
        Expected Output: An integer showcasing the difference in days between the two dates.
    */

    public void daysBetween(){
        System.out.print("Please enter the first date: ");
        String firstStringDate = input.next();

        System.out.print("Please enter the second date: ");

        String secondStringDate = input.next();

        if (isValidDate(firstStringDate, dateFormat) && isValidDate(secondStringDate, dateFormat)){
            LocalDate firstDate = LocalDate.parse(firstStringDate);
            LocalDate secondDate = LocalDate.parse(secondStringDate);

            long daysBetween;

            if (firstDate.isBefore(secondDate)){
                daysBetween = ChronoUnit.DAYS.between(firstDate, secondDate);
            } else {
                daysBetween = ChronoUnit.DAYS.between(secondDate, firstDate);
            }

            System.out.println("The total number of days between the two dates: " + daysBetween);
        } else {
            System.out.println("Invalid date format!");
        }
    }

    /*
        Date Authenticator
        Description: Engineer a method named isValidDate that captures a date string from the console
        and assesses if it conforms to a valid date format (YYYY-MM-DD).
        The method should also consider leap years when validating February dates.
        Input: A string of a date from the console.
        Expected Output:
        true if the input adheres to the date format and denotes a genuine date.
        false if otherwise.
     */

    public boolean isValidDate(){
        System.out.print("Please enter a date: ");
        String date = input.next();

        DateFormat formatter = new SimpleDateFormat(dateFormat);
        formatter.setLenient(false);

        input.close();
        try {
            formatter.parse(date);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    /*
        Duration Since
        Description: Construct a method dubbed elapsedTimeSince that ingests a prior time (in the HH:MM:SS format)
        as its input and displays the time duration from that moment to the present.
        Input: A time given in the format HH:MM:SS.
        Expected Output: The time span given as X hours, Y minutes, Z seconds.
     */

    public void elapsedTimeSince(LocalTime time){
        LocalTime currentTime = LocalTime.now();

        if (time.isAfter(currentTime)){
            System.out.println("Please insert a prior time.");
        } else {
            Duration duration = Duration.between(time, currentTime);
            System.out.printf("%d hours, %d minutes, %d seconds", duration.toHours(), duration.toMinutes() % 60, duration.toSeconds() % 60);
        }
    }

    /*
        Time Conversion Across Zones
        Develop a method named convertToTimeZone that collects a date and time from the console
        in the pattern YYYY-MM-DD HH:MM:SS and a timezone (like "EST", "PST").
        The objective is to transmute the specified date and time to align with the provided timezone
        and then showcase the result.
        Input:
            Date and time structured as YYYY-MM-DD HH:MM:SS.
            A string indicating the timezone (e.g., "EST").
        Expected Output: The recalibrated date and time synchronized with the inputted timezone.
     */

    public String convertToTimeZone(){
        System.out.print("Please enter a date and time (yyyy-MM-dd HH:mm:ss): ");
        String inputDateTime = input.nextLine();

        System.out.print("Please enter a timezone: ");
        String inputTimeZone = input.nextLine();

        input.close();
        String pattern = "yyyy-MM-dd HH:mm:ss";

        if (isValidDate(inputDateTime, pattern) && isValidZoneId(inputTimeZone)){
            LocalDateTime dateTime = LocalDateTime.parse(inputDateTime, DateTimeFormatter.ofPattern(pattern));
            ZoneId targetZoneId = ZoneId.of(inputTimeZone, ZoneId.SHORT_IDS);

            ZonedDateTime zonedDateTime = dateTime.atZone(ZoneId.systemDefault()).withZoneSameInstant(targetZoneId);

            return zonedDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        }
        return "Invalid date time or timezone.";
    }

    public boolean isValidZoneId(String zoneId){
        try {
            ZoneId.of(zoneId, ZoneId.SHORT_IDS);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
