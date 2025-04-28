package session_13_OOP_4.Homework.Ex_2;

import java.util.HashSet;
import java.util.Set;

public class Team {
    private final String name;
    private final Set<Employee> employees;

    public Team(String name) {
        this.name = name;
        this.employees = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public boolean addEmployee(Employee employee){
        return employees.add(employee);
    }

    public boolean deleteEmployee(Employee employee){
        return employees.remove(employee);
    }

    public void setMember(Employee employee){
        if (employees.contains(employee) && !employee.getType().equals(EmployeeType.MEMBER)){
            employee.setType(EmployeeType.MEMBER);
        }
    }

    public void setLead(Employee employee){
        if (employees.contains(employee) && !containsLeader() && !employee.getType().equals(EmployeeType.TEAM_LEAD)){
            employee.setType(EmployeeType.TEAM_LEAD);
        }
    }

    private boolean containsLeader(){
        for (Employee employee : employees){
            if (employee.getType().equals(EmployeeType.TEAM_LEAD)){
                return true;
            }
        }
        return false;
    }

    public void displayEmployees(){
        employees.forEach(System.out::println);
    }
}
