package chapter_20;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SequencedMap;

// Using a LinkedHashMap
public class LinkedHashMapDemo {
    public static void main(String[] args) {
        // Create a tree map.
        SequencedMap<String, Double> sm = new LinkedHashMap<>();

        // Put elements to the map.
        sm.put("Carla Dupres", 2749.50);
        sm.putFirst("David Garcia", 314.15);
        sm.putLast("Bella Yip", 1289.41);
        sm.putFirst("Elizabeth Johnson", 72.96);
        sm.put("Adam Smith", -34.99);

        // Display the elements.
        for (Map.Entry<String, Double> me : sm.entrySet()) {
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }
    }
}
