package session_10_OOP.Homework.SchoolGradebook;

public class TestGradebook {
    public static void main(String[] args) {
        Student alice = new Student("Alice");
        Student john = new Student("John");

        Course course = new Course("Math");
        course.addStudent(alice);
        course.addStudent(john);

        double[] aliceGrades = {10, 7.7, 9.4, 8.56};
        double[] johnGrades = {4.5, 9.7, 9.8, 6.9};

        for (double grade : aliceGrades){
            course.assignGrade(alice, grade);
        }

        for (double grade : johnGrades){
            course.assignGrade(john, grade);
        }

        System.out.println("\nList of students: ");
        course.displayStudents();

        System.out.println("\nList of students with grades:");
        course.displayStudentsWithGrades();

        System.out.println("\nAverage grade for Alice: " + course.calculateAvgGrade(alice));

        System.out.println("\nList of students with average grades:");
        course.displayStudentsWithAvgGrades();
    }

}
