package zrc.course.collectionUnSafe;

import java.util.*;

public class ArrayListUnSafe {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(String.valueOf(random.nextDouble()));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}
