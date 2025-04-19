package session_16_Hash.Homework;

import java.util.Objects;

public class Student {
    private int studentId;
    private String name;
    private int age;
    private String email;

    public Student(int studentId, String name, int age, String email) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    @Override
    public boolean equals(Object o){
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;
        return Objects.equals(name, student.name) && age == student.age && Objects.equals(email, student.email);
    }

    @Override
    public int hashCode(){
        return Objects.hash(name, age, email);
    }
}

class StudentTest{
    public static void main(String[] args) {
        Student s1 = new Student(1, "Jane", 21, "jane@gmail.com");
        Student s2 = new Student(2, "Jane", 21, "jane@gmail.com");
        Student s3 = new Student(1, "John", 21, "jane@gmail.com");

        System.out.println("s1 equals to s2? " + s1.equals(s2));
        System.out.println("s1 equals to s3? " + s1.equals(s3));

        System.out.println("s1 hashcode: " + s1.hashCode());
        System.out.println("s2 hashcode: " + s2.hashCode());
        System.out.println("s3 hashcode: " + s3.hashCode());
    }
}
