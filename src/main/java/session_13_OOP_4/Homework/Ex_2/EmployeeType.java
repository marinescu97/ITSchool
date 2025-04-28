package session_13_OOP_4.Homework.Ex_2;

public enum EmployeeType {
    MEMBER("Member"),
    TEAM_LEAD("Team lead");

    private String type;

    EmployeeType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
