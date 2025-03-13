package session_7_Utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        localDateTimeExer2();
    }

    public static void localDateExer(){
        LocalDate today = LocalDate.now();
        System.out.println("Today date: " + today);

        LocalDate tenDays = today.plusDays(20);
        System.out.println("Twenty days from now: " + tenDays);

        LocalDate tenYears = today.plusYears(10);
        System.out.println("Ten years from now: " + tenYears);
    }

    public static void localDateTimeExer(){
        LocalDateTime today = LocalDateTime.now();
        System.out.println("Today date: " + today);

        LocalDateTime tenHours = today.plusHours(10);
        System.out.println("Ten hours from now: " + tenHours);

        String dateTimeString = "2025-01-01 10:30";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime parseDateTime = LocalDateTime.parse(dateTimeString, formatter);

        System.out.println("Parsed local date time: " + parseDateTime);

        DateTimeFormatter newFormat = DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm:ss");
        System.out.println("New format date time: " + parseDateTime.format(newFormat));

        System.out.println("New format today: " + today.format(newFormat));

        LocalDateTime future = LocalDateTime.of(2025, 3, 14, 10, 30, 21);
        System.out.println("Future date: " + future);

        String result = (future.isBefore(today)) ? "before" : "after";

        System.out.println("before or after? : " + result);

        System.out.println("day from the future: " + future.getDayOfWeek());

        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        System.out.println("Util date " + utilDate);
        System.out.println("Sql date " + sqlDate);

        Timestamp timeStamp = new Timestamp(sqlDate.getTime());
        System.out.println("Timestamp: " + timeStamp);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        String formattedTime = simpleDateFormat.format(utilDate);
        System.out.println("Simple date format: " + formattedTime);
    }

    public static void randomExer(){
        Random random = new Random();
        int randomNum = random.nextInt(100); // de la 0 pana la 99
        int randomNum1 = random.nextInt(100) + 1; // de la 1 pana la 100
        System.out.println(randomNum);

        double randomDouble = random.nextDouble();
        System.out.println(randomDouble); // de la 0 pana la 1

        String[] names = {"Ion", "Dan", "Marius"};
        System.out.println(names[random.nextInt(names.length)]);

        System.out.println(random.nextBoolean());
    }

    public static void mathExer(){
        int firstNumber = 11;
        int secondNumber = 32;

        System.out.println("Min: " + Math.min(firstNumber, secondNumber));
        System.out.println("Max: " + Math.max(firstNumber, secondNumber));
        System.out.println("PI value: " + Math.PI);

        int number = 50;

        System.out.println(Math.max(Math.max(firstNumber, secondNumber), number));
    }

    public static void localDateTimeExer2(){
        LocalDateTime time = LocalDateTime.now();
        LocalDateTime time2 = time.plusDays(1);

        Duration duration = Duration.between(time, time2).plusHours(5).plusSeconds(5356);


        System.out.println("Diferenta dintre ore este: " + duration.toHours());
        System.out.println("Diferenta dintre minute este: " + duration.toMinutes());
        System.out.println("Diferenta dintre secunde este: " + duration.toSeconds());
    }
}
