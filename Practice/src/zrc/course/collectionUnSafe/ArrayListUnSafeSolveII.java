package zrc.course.collectionUnSafe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

// 可以使用Collections工具类中的synchronizedList()方法
public class ArrayListUnSafeSolveII {
    public static void main(String[] args) {
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(String.valueOf(random.nextDouble()));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}
