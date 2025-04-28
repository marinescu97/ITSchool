package session_13_OOP_4.Homework.Ex_2;

import java.util.Objects;

public class User {
    private final String name;
    public static ConstructionProject project = null;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void displayProjectProgress(){
        project.displayProgress();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getName(), user.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getName());
    }

    @Override
    public String toString() {
        return name;
    }
}
