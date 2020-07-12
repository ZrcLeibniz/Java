package zrc.map;

import java.util.*;

public class HashMapTest02 {
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "张三");
        hashMap.put(2, "李四");
        hashMap.put(3, "王五");
        hashMap.put(2, "赵四");
        System.out.println(hashMap.size());
        Set<Map.Entry<Integer, String>> entries = hashMap.entrySet();
        Iterator<Map.Entry<Integer, String>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        HashMap<Student, Integer> map = new HashMap<>();
        Student student = new Student();
        student.setName("张三");
        Student student1 = new Student();
        student1.setName("张三");
        map.put(student, 1);
        map.put(student1, 2);
        System.out.println(map.size());
    }
}

class Student {
    String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}