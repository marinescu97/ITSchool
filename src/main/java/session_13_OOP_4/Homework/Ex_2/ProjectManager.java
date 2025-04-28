package session_13_OOP_4.Homework.Ex_2;

public class ProjectManager extends User implements EmailService{
    public ProjectManager(String name) {
        super(name);
    }

    public void setProject(ConstructionProject project){
        User.project = project;
    }

    public void addProjectTask(Task task){
        if (project.addTask(task)){
            project.addProgress(getName() + " added task " + task.getName() + " to the " + project.getName() + " project.");
        }
    }

    public void setTaskTeam(Task task, Team team){
        if (project.getTasks().contains(task)){
            task.setAssignedTo(team);
            project.addProgress(getName() + " assigned task " + task.getName() + " to team " + team.getName() + ".");
        }
    }

    public void addTeamMember(Team team, Employee employee){
        if (project.containsTeam(team) && team.addEmployee(employee)){
            project.addProgress(getName() + " added member " + employee.getName() + " to team " + team.getName() + ".");
        }
    }

    public void deleteEmployee(Team team, Employee employee){
        if (project.containsTeam(team) && team.deleteEmployee(employee)){
            project.addProgress(getName() + " deleted " + employee.getName() + " from team " + team.getName() + ".");
        }
    }

    public void addAvailableResource(Task task, String resource, int quantity){
        if (project.getTasks().contains(task)){
            task.addAvailableResource(resource, quantity);
            project.addProgress(String.format("%s added available resource (%s -> %d) to task %s.", getName(), resource, quantity, task.getName()));
        }
    }

    public void setLead(Team team, Employee employee){
        if (project.containsTeam(team)){
            team.setLead(employee);
            project.addProgress(getName() + " changed type of " + employee.getName() + " to " + EmployeeType.TEAM_LEAD.getType());
        }
    }

    public void setMember(Team team, Employee employee){
        if (project.containsTeam(team)){
            team.setMember(employee);
            project.addProgress(getName() + " changed type of " + employee.getName() + " to " + EmployeeType.MEMBER.getType());
        }
    }

    public void displayEmployees(){
        for (Task task : project.getTasks()){
            Team team = task.getAssignedTo();
            System.out.println(team.getName());
            team.displayEmployees();
        }
    }

    public void displayEmployees(Team team){
        if (project.containsTeam(team)){
            team.displayEmployees();
        }
    }

    public void setTaskStatus(Task task, Status status){
        if (project.getTasks().contains(task)){
            task.setStatus(status);
            project.addProgress(getName() + " changed status of task " + task.getName() + " to " + status.getStatus() + ".");
        }
    }

    public void displayAvailableResources(Task task){
        if (project.getTasks().contains(task)){
            task.displayAvailableResources();
        }
    }

    public void displayNeededResources(Task task){
        if (project.getTasks().contains(task)){
            task.displayNeededResources();
        }
    }

    @Override
    public void sendEmail(Employee to, String subject, String body) {
        System.out.println("Sending email to " + to.getEmail());
        System.out.println("Subject: " + subject);
        System.out.println("Message: " + body);
        System.out.println("-----------------------------------");
    }
}
