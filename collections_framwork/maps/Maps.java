package collections_framwork.maps;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Maps {
    public static void main(String[] args) {
        
        Object x = "Hello";
        String y = (String)x;
        System.out.println(y);
        Map<String,Integer> map1 = new TreeMap<>((key1,key2) -> key2.compareTo(key1));
        map1.put("Ahmed", 10);
        map1.put("Mohamed", 11);
        map1.put("Yasser", 30);
        map1.replace("Ahmed",   22);

        for(Map.Entry<String,Integer> entry: map1.entrySet())
        System.out.println(entry.getKey()+ " > " + entry.getValue());

    }
}
