package zrc.course;

import java.util.HashMap;
import java.util.Random;

public class Course5 {

}

// 设计RandPool结构
/*
设计一种结构，在该结构中有三种功能：
1.insert(key):将某个key加入到该结构中，做到不重复
2.delete(key):将原本在结构中的某个key移除
3.getRandom():等概率随机返回结构中的任何一个key
 */
class RandPool {
    private HashMap<String, Integer> map1;
    private HashMap<Integer, String> map2;

    public RandPool() {
        this.map1 = new HashMap<>();
        this.map2 = new HashMap<>();
    }

    public void insert(String key) {
        if (!this.map1.containsKey(key)) {
            map1.put(key, map1.size());
            map2.put(map2.size(), key);
        }
    }

    public void delete(String key) {
        if (this.map1.containsKey(key)) {
            int deleteIndex = this.map1.get(key);
            int lastIndex = map1.size() - 1;
            String lastKey = this.map2.get(lastIndex);
            map1.put(lastKey, deleteIndex);
            map2.put(deleteIndex, lastKey);
            map1.remove(key);
            map2.remove(lastIndex);
        }
    }

    public String getRandom() {
        if (map1.size() == 0) {
            return null;
        }
        Random random = new Random();
        int i = random.nextInt(map1.size());
        return map2.get(i);
    }
}

