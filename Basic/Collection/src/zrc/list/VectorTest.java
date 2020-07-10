package zrc.list;

import java.util.*;

public class VectorTest {
    /*
    线程安全，效率较低，使用较少
    初始默认容量为10，扩容大小为原来的两倍
     */
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();
        vector.add("1");
        vector.add("11");
        vector.add("111");
        vector.add("1111");
        vector.add("11111");
        vector.add("111111");
        Iterator<String> iterator = vector.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        ArrayList<String> arrayList = new ArrayList<>();
        Collections.synchronizedList(arrayList);
        arrayList.add("2");
        arrayList.add("22");
        arrayList.add("222");
        arrayList.add("2222");
        arrayList.add("22222");
        arrayList.add("222222");
    }
}
