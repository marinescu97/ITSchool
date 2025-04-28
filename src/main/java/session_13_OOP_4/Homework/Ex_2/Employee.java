package session_13_OOP_4.Homework.Ex_2;

import java.util.Objects;

public class Employee {
    private final String name;
    private EmployeeType type;
    private final String email;

    public Employee(String name, EmployeeType type, String email) {
        this.name = name;
        this.type = type;
        this.email = email;
    }

    public Employee(String name, String email) {
        this(name, EmployeeType.MEMBER, email);
    }

    public String getName() {
        return name;
    }

    public EmployeeType getType() {
        return type;
    }

    public String getEmail() {
        return email;
    }

    public void setType(EmployeeType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && type == employee.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }

    @Override
    public String toString() {
        return name + " -> " + type;
    }
}
