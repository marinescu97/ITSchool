package JavaBase;

import java.util.*;

public class CollectionsDemo {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Marcel");
        names.add("Bogdan");
        names.add("Vio");

        System.out.println(names.get(1));

        for (String s : names){
            if (s.equals("Bogdan")){
                System.out.println(s);
            }
        }

        names.add(1, "Dora");
        System.out.println(names);

        Map<String, Integer> inventory = new HashMap<>();
        inventory.put("Pix", 120);
        inventory.put("Carnet", 340);
        inventory.put("Creion", 32);

        System.out.println(inventory);

        System.out.println(inventory.get("Pix"));
        System.out.println(inventory.entrySet());

        Set<String> set = new HashSet<>();

        set.add("mar");
        set.add("par");
        set.add("mar");

        System.out.println(set);
    }
}
