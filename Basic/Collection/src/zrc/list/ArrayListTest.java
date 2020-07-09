package zrc.list;

import java.util.ArrayList;
import java.util.HashSet;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<Object> arrayList1 = new ArrayList<>(20);
        ArrayList<Object> arrayList2 = new ArrayList<>();
        HashSet<Object> objects = new HashSet<>();
        ArrayList arrayList = new ArrayList(objects);
    }
}
