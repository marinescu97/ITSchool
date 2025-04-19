package session_16_Hash.Homework;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONBook {
    static int counter = 0;
    private int id;
    private String title;
    private String author;
    private int pages;

    public JSONBook(String title, String author, int pages) {
        this.id = ++counter;
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    //    @Override
//    public String toString() {
//        return "{\n" +
//                "\t\"id\": " + id + ",\n" +
//                "\t\"title\": \"" + title + "\",\n" +
//                "\t\"author\": \"" + author + "\",\n" +
//                "\t\"pages\": " + pages + "\n" +
//                "}";
//    }


    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}

class TestJSON{
    public static void main(String[] args) {
        JSONBook book = new JSONBook("Clean Code", "Robert C. Martin", 462);
        System.out.println(book);
    }
}
