package session_10_OOP.Homework.SchoolGradebook;

public class Student implements Comparable<Student>{
    private static int counter;
    private int id;
    private String name;

    public Student(String name) {
        this.id = ++counter;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%d: %s", id, name);
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(this.id, o.id);
    }
}
