package session_13_OOP_4.Homework.Ex_2;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Task {
    private final String name;
    private Status status;
    private Team assignedTo;
    private final Map<String, Integer> availableResources;
    private final Map<String, Integer> neededResources;

    public Task(String name) {
        this.name = name;
        this.status = Status.NOT_STARTED;
        this.assignedTo = null;
        this.availableResources = new HashMap<>();
        this.neededResources = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Team getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(Team assignedTo) {
        this.assignedTo = assignedTo;
    }

    public void addAvailableResource(String resource, int quantity){
        Integer initialQuantity = availableResources.get(resource);
        if (initialQuantity != null){
            availableResources.replace(resource, initialQuantity+quantity);
        } else {
            availableResources.put(resource, quantity);
        }
        updateNeededResource(resource, quantity);
    }

    public void addNeededResource(String resource, int quantity){
        Integer initialQuantity = neededResources.get(resource);
        if (initialQuantity != null){
            neededResources.replace(resource, initialQuantity+quantity);
        } else {
            neededResources.put(resource, quantity);
        }
    }

    private void updateNeededResource(String resource, int quantity){
        Integer initialQuantity = neededResources.get(resource);
        if (initialQuantity != null){
            if (initialQuantity <= quantity){
                neededResources.remove(resource);
            } else {
                neededResources.replace(resource, initialQuantity - quantity);
            }
        }
    }

    public void displayAvailableResources(){
        System.out.println("Available resources: ");
        for (Map.Entry<String, Integer> entry : availableResources.entrySet()){
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public void displayNeededResources(){
        System.out.println("Needed resources: ");
        for (Map.Entry<String, Integer> entry : neededResources.entrySet()){
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(getName(), task.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getName());
    }
}
