package zrc.course.collectionUnSafe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

// 可以使用JUC包下的CopyOnWriteArrayList<>();
public class ArrayListUnSafeSolveIII {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(String.valueOf(random.nextDouble()));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}
