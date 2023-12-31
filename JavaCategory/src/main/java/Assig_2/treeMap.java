/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assig_2;

import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 *
 * @author LENOVO
 */
public class treeMap {

    static TreeMap<Integer, String> tmap = new TreeMap<>();

    static void associateValueToKey() {
        System.out.println("<============associateValueToKey============>");
        tmap.put(1, "Amrita");
        tmap.put(2, "Ravi");
        tmap.put(3, "Vijay");
        tmap.put(4, "Rahul");
        for (Map.Entry<Integer, String> entry : tmap.entrySet()) {
            System.out.println(entry.getKey() + "=>" + entry.getValue());
        }
    }

    static void copyMapToAnotherMap() {
        System.out.println("<==================copyMapToAnotherMap============>");
        System.out.println("Initial Mappings are: " + tmap);
        System.out.println("The cloned map look like this: " + tmap.clone());
    }

    static void searchKeyInTreemap() {
        System.out.println("<==================searchKeyInTreemap============>");
        System.out.println("Initial Mappings are: " + tmap);

        // Checking for the key_element '2' 
        System.out.println("Is the key '2' present? " + tmap.containsKey(2));
        // Checking for the key_element '5' 
        System.out.println("Is the key '5' present? " + tmap.containsKey(5));
    }

    static void searchValueInTreemap() {
        System.out.println("<==================searchValueInTreemap============>");

        if (tmap.containsValue("Amrita")) {
            System.out.println("The TreeMap contains value Amrita");
        } else {
            System.out.println("The TreeMap does not contain value Amrita");
        }
        if (tmap.containsValue("Rahul")) {
            System.out.println("The TreeMap contains value Rahul");
        } else {
            System.out.println("The TreeMap does not contain value Rahul");
        }
    }

    static void getAllKey() {
        System.out.println("<==================getAllKey============>");
        System.out.println("Tree Mappings are: " + tmap);

        Set<Integer> keys = tmap.keySet();
        for (Integer key : keys) {
            System.out.println(key);
        }
    }

    static void deleteAllElement() {
        System.out.println("<==================deleteAllElement============>");
        System.out.println("Initial Mappings are: " + tmap);

        // Clearing the tree map using clear() 
        tmap.clear();
        System.out.println("Finally the map looks like: " + tmap);
    }

    /*static void sortkeyUsingComparator() {
        System.out.println("<==================sortkeyUsingComparator============>");
        TreeMap<String, String> map = new TreeMap<>(new sort_key());
        map.put(c, "Amrita");
        map.put(d, "Ravi");
        map.put(g, "Vijay");
        map.put(k, "Rahul");
        System.out.println("Mappings are: " + map);

        class sort_key implements Comparator<String> {

            @Override
            public int compare(String str1, String str2) {
                return str1.compareTo(str2);
            }
        }
    }*/
    
    static void keyValueMapping() {
        System.out.println("<==================keyValueMappingWithGreatestAndLeastKey============>");
        tmap.put(1, "Amrita");
        tmap.put(2, "Ravi");
        tmap.put(3, "Vijay");
        tmap.put(4, "Rahul");
        System.out.println("Tree Map are: " + tmap);

        System.out.println("Greatest key: " + tmap.firstEntry());
        System.out.println("Least key: " + tmap.lastEntry());
    }

    static void firstLowestAndLastHigdestKey() {
        System.out.println("<==========firstLowestAndLastHigdestKey==========>");

        System.out.println("TreeMap view : " + tmap);
        System.out.println("Greatest Key : " + tmap.firstKey());
        System.out.println("Least Key : " + tmap.lastKey());
    }

    static void reverseKey() {
        System.out.println("<===================reverseKey===============>");
        System.out.println("TreeMap content: " + tmap);
        System.out.println("Reverse order view of the keys: " + tmap.descendingKeySet());
    }

    static void kVMapping() {
        System.out.println("<=====keyValueMappingWithGreatestKey=========>");
        System.out.println("TreeMap content: " + tmap);
        System.out.println("Checking the entry for 1: ");
        System.out.println("Value is: " + tmap.floorEntry(1));
        System.out.println("Checking the entry for 3: ");
        System.out.println("Value is: " + tmap.floorEntry(3));
    }

    static void getGreatestKey() {
        System.out.println("<===============getGreatestKey===============>");
        System.out.println("Given TreeMap : " + tmap);
        System.out.println("Checking the 1 Key : " + tmap.floorKey(101));
        System.out.println("Checking the 5 Key : " + tmap.floorKey(106));
    }

    static void getKeysThatStrictlyLess() {
        System.out.println("<==========getKeysThatStrictlyLess===========>");

        System.out.println("Given TreeMap : " + tmap);
        System.out.println("Checking the entry for 1: ");
        System.out.println("Key(s): " + tmap.headMap(1));
        System.out.println("Checking the entry for 3: ");
        System.out.println("Key(s): " + tmap.headMap(3));
    }

    static void getKeysLessThanGivenKey() {
        System.out.println("<==========getKeysLessThanGivenKey===========>");
        System.out.println("Given TreeMap : " + tmap);
        System.out.println("Checking the entry for 1: ");
        System.out.println("Key(s): " + tmap.headMap(1, true));
        System.out.println("Checking the entry for 4: ");
        System.out.println("Key(s): " + tmap.headMap(4, true));
    }

    static void getLeastKeyStrictlyGreater() {
        System.out.println("<==========getLeastKeyStrictlyGreater===========>");
        System.out.println("Given TreeMap : " + tmap);
        System.out.println("Checking the entry for 1: ");
        System.out.println("Key(s): " + tmap.higherEntry(1));
        System.out.println("Checking the entry for 3: ");
        System.out.println("Key(s): " + tmap.higherEntry(3));
        System.out.println("Checking the entry for 5: ");
        System.out.println("Key(s): " + tmap.higherEntry(5));
    }

    static void kVMappingWithGreatestKey() {
        System.out.println("<==========kVMappingWithGreatestKey===========>");

        System.out.println("Given TreeMap : " + tmap);
        System.out.println("Checking the entry for 1: ");
        System.out.println("Key(s): " + tmap.lowerEntry(1));
        System.out.println("Checking the entry for 2: ");
        System.out.println("Key(s): " + tmap.lowerEntry(2));
        System.out.println("Checking the entry for 6: ");
        System.out.println("Key(s): " + tmap.lowerEntry(6));
    }

    static void greatestKeyStrictlyLessThanGivenKey() {
        System.out.println("<========greatestKeyStrictlyLessThanGivenKey=========>");

        System.out.println("Given TreeMap : " + tmap);
        System.out.println("Orginal TreeMap content: " + tmap);
        System.out.println("Checking the entry for 1: ");
        System.out.println("Key(s): " + tmap.lowerKey(1));
        System.out.println("Checking the entry for 2: ");
        System.out.println("Key(s): " + tmap.lowerKey(2));
        System.out.println("Checking the entry for 7: ");
        System.out.println("Key(s): " + tmap.lowerKey(7));
    }

    static void getNavigableSetView() {
        System.out.println("<========getNavigableSetView=========>");

        System.out.println("Given TreeMap : " + tmap);
        System.out.println("Checking key set value");
        System.out.println("Value is: " + tmap.navigableKeySet());
    }

    static void removeAndGetKeyvalue() {
        System.out.println("<========removeAndGetKeyvalue=========>");
        System.out.println("Given TreeMap : " + tmap);

        System.out.println("Value before poll: " + tmap);
        System.out.println("Value returned: " + tmap.pollLastEntry());
        System.out.println("Value after poll: " + tmap);
    }

    static void getKeyRange() {
        System.out.println("<================getKeyRange=================>");
        TreeMap<Integer, String> tmap = new TreeMap<>();
        SortedMap< Integer, String> sub_tree_map = new TreeMap<>();
        tmap.put(1, "Amrita");
        tmap.put(2, "Ravi");
        tmap.put(3, "Vijay");
        tmap.put(4, "Rahul");
        System.out.println("Given TreeMap : " + tmap);

        sub_tree_map = tmap.subMap(2, 4);
        System.out.println("Sub map key-values: " + sub_tree_map);
    }

    static void rangekey() {
        System.out.println("<================rangekey=================>");

        SortedMap<Integer, String> s2 = new TreeMap<>();
        System.out.println("Given TreeMap : " + tmap);
        s2 = tmap.subMap(1, true, 3, true);
        System.out.println("Sub TreeMap Key Values : " + s2);
    }

    static void keyGreaterThanOrEqualToGivenKey() {
        System.out.println("<=======keyGreaterThanOrEqualToGivenKey=======>");

        System.out.println("Given TreeMap: " + tmap);
        System.out.println("Keys are greater than or equal to 2: " + tmap.tailMap(2));
    }

    static void keyGreaterThanGivenKey() {
        System.out.println("<=======keyGreaterThanOrEqualToGivenKey=======>");
        System.out.println("Orginal TreeMap content: " + tmap);
        System.out.println("Keys are greater than 1: " + tmap.tailMap(1, false));
    }

    static void kVWithTheLeastKeyGreaterthanOrEqual() {
        System.out.println("<=======kVWithTheLeastKeyGreaterthanOrEqual=======>");

        System.out.println("Orginal TreeMap content: " + tmap);
        System.out.println("Keys greater than or equal to 2: " + tmap.ceilingEntry(2));
        System.out.println("Keys greater than or equal to 4: " + tmap.ceilingEntry(4));
    }

    static void leastkGreaterThanOrEqualToGivenKey() {
        System.out.println("<=======leastkGreaterThanOrEqualToGivenKey=======>");
        System.out.println("Given TreeMap : " + tmap);
        System.out.println("Keys greater than or equal to 2: " + tmap.ceilingKey(2));
        System.out.println("Keys greater than or equal to 3: " + tmap.ceilingKey(3));
        System.out.println("Keys greater than or equal to 5: " + tmap.ceilingKey(5));
    }

    public static void main(String[] args) {
        associateValueToKey();
        copyMapToAnotherMap();
        searchKeyInTreemap();
        searchValueInTreemap();
        getAllKey();
        deleteAllElement();
        //sortkeyUsingComparator();
        keyValueMapping();
        firstLowestAndLastHigdestKey();
        reverseKey();
        kVMapping();
        getGreatestKey();
        getKeysThatStrictlyLess();
        getKeysLessThanGivenKey();
        getLeastKeyStrictlyGreater();
        kVMappingWithGreatestKey();
        greatestKeyStrictlyLessThanGivenKey();
        getNavigableSetView();
        removeAndGetKeyvalue();
        getKeyRange();
        rangekey();
        keyGreaterThanOrEqualToGivenKey();
        keyGreaterThanGivenKey();
        kVWithTheLeastKeyGreaterthanOrEqual();
        leastkGreaterThanOrEqualToGivenKey();
    }
}
