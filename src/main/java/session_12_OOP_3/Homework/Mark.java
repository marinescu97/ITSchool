package session_12_OOP_3.Homework;

public abstract class Mark {
    public abstract double getPercentage();
}

class StudentA extends Mark{
    private double subject1, subject2, subject3;

    public StudentA(double subject1, double subject2, double subject3) {
        this.subject1 = subject1;
        this.subject2 = subject2;
        this.subject3 = subject3;
    }

    @Override
    public double getPercentage() {
        double total = subject1 + subject2 + subject3;
        return (total / 300) * 100;
    }
}

class StudentB extends Mark{
    private double subject1, subject2, subject3, subject4;

    public StudentB(double subject1, double subject2, double subject3, double subject4) {
        this.subject1 = subject1;
        this.subject2 = subject2;
        this.subject3 = subject3;
        this.subject4 = subject4;
    }

    @Override
    public double getPercentage() {
        double total = subject1 + subject2 + subject3 + subject4;
        return (total / 400) * 100;
    }
}

class TestMarks{
    public static void main(String[] args) {
        StudentA studentA = new StudentA(85, 90, 80);
        System.out.println("Student A percentage: " + studentA.getPercentage());

        StudentB studentB = new StudentB(75, 80.5, 70, 90);
        System.out.println("Student B percentage: " + studentB.getPercentage());
    }
}
