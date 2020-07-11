package zrc.map;

import java.util.*;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("法外狂徒", "张三");
        hashMap.put("万恶之源", "小明");
        hashMap.put("旷世奇才", "小红");
        hashMap.put("乱臣贼子", "李四");
        System.out.println(hashMap.get("法外狂徒"));
        System.out.println(hashMap.size());
        System.out.println(hashMap.remove("旷世奇才"));
        System.out.println(hashMap.containsKey("法外狂徒"));
        System.out.println(hashMap.containsValue("李四"));
        hashMap.clear();
        System.out.println(hashMap.isEmpty());
        hashMap.put("法外狂徒", "张三");
        hashMap.put("万恶之源", "小明");
        hashMap.put("旷世奇才", "小红");
        hashMap.put("乱臣贼子", "李四");
        // 获取所有的value返回一个collection
        Collection<String> values = hashMap.values();
        // 获取所有的key返回一个Set
        Set<String> strings = hashMap.keySet();
        for (String s:strings){
            System.out.println(s+":"+hashMap.get(s));
        }
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            String value = hashMap.get(key);
            System.out.println(key + ":" + value);
        }
        Set<Map.Entry<String, String>> entries = hashMap.entrySet();
        Iterator<Map.Entry<String, String>> iterator1 = entries.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }
    }
}
