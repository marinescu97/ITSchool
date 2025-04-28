package session_13_OOP_4.Homework.Ex_2;

public class ConstructorEngineer extends User{

    public ConstructorEngineer(String name) {
        super(name);
    }

    public void addNeededResource(Task task, String resource, int quantity){
        if (project.getTasks().contains(task)){
            task.addNeededResource(resource, quantity);
            project.addProgress(String.format("%s added needed resource (%s -> %d) to task %s.", getName(), resource, quantity, task.getName()));
        }
    }
}
