package zrc.course.collectionUnSafe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

// 可以直接使用List接口的另外一个实现类
public class ArrayListUnSafeSolveI {
    public static void main(String[] args) {
        List<String> list = new Vector<>();
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(String.valueOf(random.nextDouble()));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}
