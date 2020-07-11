package zrc.set;

import java.util.Set;
import java.util.HashSet;

public class HashSetTest {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();
        hashSet.add("hello1");
        hashSet.add("hello2");
        hashSet.add("hello3");
        hashSet.add("hello4");
        hashSet.add("hello1");
        hashSet.add("hello2");
        hashSet.add("hello3");
        hashSet.add("hello4");
        for (String s : hashSet) {
            System.out.println(s);
        }
    }
}
