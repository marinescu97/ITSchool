package session_13_OOP_4.Homework.Ex_2;

import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Admin admin = new Admin("Admin");
        ConstructorEngineer constructorEngineer = new ConstructorEngineer("Constructor Engineer");
        ProjectManager projectManager = new ProjectManager("Project manager");

        Employee johnDoe = new Employee("John Doe", "johndoe@gmail.com");
        Employee liamHarris = new Employee("Liam Harris", "liamharris@gmail.com");
        Employee benjaminReed = new Employee("Benjamin Reed", "breed@gmail.com");
        Employee alexanderScott = new Employee("Alexander Scott", "ascott@gmail.com");

        ConstructionProject project = new ConstructionProject("Small House");

        Task foundation = new Task("Lay Foundation");
        Task wiring = new Task("Electrical Wiring");

        Team alpha = new Team("Team alpha");

        projectManager.setProject(project);
        projectManager.addProjectTask(foundation);
        projectManager.addProjectTask(wiring);
        projectManager.setTaskTeam(foundation, alpha);

        for (Employee employee : List.of(johnDoe, liamHarris, benjaminReed, alexanderScott)){
            projectManager.addTeamMember(alpha, employee);
        }

        projectManager.setLead(alpha, johnDoe);

        projectManager.setTaskTeam(wiring, alpha);

        constructorEngineer.addNeededResource(foundation, "Cement", 50);
        constructorEngineer.addNeededResource(foundation, "Bricks", 100);

        projectManager.addAvailableResource(foundation, "Cement", 20);
        projectManager.addAvailableResource(foundation, "Bricks", 50);

        admin.applyChanges();

        System.out.println();

        Team beta = new Team("Team Beta");
        Employee brooks = new Employee("Nathan Brooks", "nbrooks@gmail.com");
        Employee coleman = new Employee("Matthew Coleman", "nbrooks@gmail.com");
        Employee donovan = new Employee("Lucas Donovan", "nbrooks@gmail.com");

        projectManager.setTaskTeam(wiring, beta);

        for (Employee employee : Arrays.asList(brooks, coleman, donovan)){
            projectManager.addTeamMember(beta, employee);
        }
        projectManager.setTaskTeam(wiring, beta);
        projectManager.setLead(beta, coleman);

        projectManager.displayEmployees();
        System.out.println();
        projectManager.displayEmployees(beta);

        projectManager.deleteEmployee(alpha, liamHarris);

        projectManager.setTaskStatus(foundation, Status.IN_PROGRESS);

        projectManager.addAvailableResource(foundation, "Cement", 30);

        projectManager.displayAvailableResources(foundation);
        projectManager.displayNeededResources(foundation);

        projectManager.setMember(beta, coleman);

        for (Employee employee : Arrays.asList(brooks, coleman, donovan)){
            projectManager.sendEmail(employee, "Company Safety Policy Update", "Please review the updated safety guidelines before Monday.");
        }

        constructorEngineer.displayProjectProgress();
    }
}
