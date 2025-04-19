package session_16_Hash.Homework;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Entity {
    private int id;
    private String name;
    private LocalDateTime createdAt;

    public Entity(int id, String name, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o){
        if (o == null || getClass() != o.getClass()) return false;

        Entity entity = (Entity) o;
        return id == entity.id;
    }

    @Override
    public int hashCode(){
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Entity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}

class EntityTest{
    public static void main(String[] args) {
        Set<Entity> entitySet = new HashSet<>();
        entitySet.add(new Entity(1, "Alice", LocalDateTime.now()));
        entitySet.add(new Entity(2, "Alice", LocalDateTime.now()));
        entitySet.add(new Entity(1, "Jane", LocalDateTime.now().plusDays(1)));

        System.out.println("The list of entities: " + entitySet);
    }
}
