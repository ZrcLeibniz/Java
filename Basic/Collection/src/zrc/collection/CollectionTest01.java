package zrc.collection;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionTest01 {
    public static void main(String[] args) {
        Collection collection = new ArrayList();
        collection.add(1200);
        collection.add(3.14);
        collection.add(new Object());
        collection.add(new Student());
        collection.add(true);
        System.out.println(collection.size());
        collection.clear();
        System.out.println(collection.size());
        collection.add("Hello");
        collection.add("World");
        collection.contains("hello");
        collection.add(1);
        collection.remove(1);
        System.out.println(collection.isEmpty());
        collection.add(1200);
        collection.add(3.14);
        collection.add(new Object());
        collection.add(new Student());
        collection.add(true);
        Object[] objects = collection.toArray();
    }
}

class Student {

}