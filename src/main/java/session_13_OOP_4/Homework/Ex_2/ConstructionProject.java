package session_13_OOP_4.Homework.Ex_2;

import java.util.*;

public class ConstructionProject {
    private String name;
    private final Set<Task> tasks;
    private final List<String> progress;

    public ConstructionProject(String name) {
        this.name = name;
        this.tasks = new HashSet<>();
        this.progress = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public boolean addTask(Task task){
        return tasks.add(task);
    }

    public void addProgress(String progress){
        this.progress.add(progress);
    }

    public boolean containsTeam(Team team){
        for (Task task : tasks){
            if (team.equals(task.getAssignedTo())){
                return true;
            }
        }
        return false;
    }

    public void displayProgress(){
        System.out.println(name + "'s progress: ");
        progress.forEach(System.out::println);
    }
}
