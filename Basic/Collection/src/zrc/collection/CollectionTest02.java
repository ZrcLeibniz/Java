package zrc.collection;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class CollectionTest02 {
    public static void main(String[] args) {
        Collection c = new HashSet<>();
        c.add("aaa");
        c.add("bbb");
        c.add("ccc");
        c.add("ddd");
        c.add(new Object());
        Iterator iterator = c.iterator();
        if (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
