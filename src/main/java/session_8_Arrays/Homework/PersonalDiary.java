package session_8_Arrays.Homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PersonalDiary {
    private final List<String> diary;

    public PersonalDiary() {
        diary = new ArrayList<>();
    }

    private int getIndex(String data){
        return Collections.binarySearch(diary, data);
    }

    private boolean isValidDateFormat(String date){
        String regex = "^\\d{4}-\\d{2}-\\d{2}$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(date);

        return matcher.matches();
    }

    public void add(String date, String entry){
        int index = getIndex(date);

        if (index < 0){
            if (isValidDateFormat(date)){
                index = -(index + 1);
                diary.add(index, date + ": " + entry);
                System.out.println("The entry was added successfully.");
            } else {
                System.out.println("Please enter a date in the format yyy-MM-dd");
            }
        } else {
            System.out.println("The date already exist in the list.");
        }
    }

    public void edit(String date, String text){
        int index = findDateIndex(date);

        if (index > 0){
            StringBuilder result = new StringBuilder(diary.get(index));
            result.replace(result.indexOf(" ") + 1, result.length(), text);
            diary.set(index, result.toString());
            System.out.println("The entry was edited successfully.");
        } else {
            System.out.println("The date doesn't exist in the list.");
        }
    }

    public void delete(String date){
        int index = findDateIndex(date);

        if (index > 0){
            diary.remove(index);
            System.out.println("The entry was deleted successfully.");
        } else {
            System.out.println("The date doesn't exist in the list");
        }
    }

    public void display(){
        String[] reversed = diary.reversed().toArray(new String[diary.size()]);

        for (String entry : reversed){
            System.out.println(entry);
        }
    }

    private int findDateIndex(String date){
        for (int i = 0; i < diary.size(); i++){
            if (diary.get(i).contains(date)){
                return i;
            }
        }

        return -1;
    }
}
