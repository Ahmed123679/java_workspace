package collections_framwork.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/* 
 * Collections frame work introduction. 
*/
public class Collections {
    /*
     * main method.
     */
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        LinkedList<String> strings = new LinkedList<>();
        ListIterator<String> iterator = strings.listIterator();
        while(iterator.)
        strings.add("Hello world string");
        strings.set(0, "element");
        for(String str:strings)
        System.out.println("linked -> " + str);
        names.add("Ahmed");
        names.add("Mohamed");
        names.add("Ibrahim");
        for(String name:names)
        System.out.println(name);
    }
}
