package session_13_OOP_4.Homework.Ex_2;

public enum Status {
    NOT_STARTED("Not started"),
    IN_PROGRESS("In progress"),
    COMPLETED("Completed");

    private final String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
