package zrc.challenge;

import java.util.HashMap;

/*
设计一个RandomPool结构:
    1.insert(key): 将某个key加入到此结构中，做到不重复加入
    2.delete(key): 将原本在结构中的某个key删除
    3.getRandom(): 等概率随机返回结构中的任何一个key
    4.三种操作的时间复杂度都为O(1)
 */
public class RandPool<K> {
    private HashMap<K, Integer> keyIndexMap;
    private HashMap<Integer, K> indexKeyMap;
    private int size;

    public RandPool() {
        this.keyIndexMap = new HashMap<>();
        this.indexKeyMap = new HashMap<>();
        this.size = 0;
    }

    public void insert(K key) {
        if (!keyIndexMap.containsKey(key)) {
            keyIndexMap.put(key, size);
            indexKeyMap.put(size++, key);
        }
    }

    public void delete(K key) {
        int index = keyIndexMap.get(key);
        int lastIndex = size--;
        keyIndexMap.put(indexKeyMap.get(lastIndex), index);
        indexKeyMap.put(index, indexKeyMap.get(lastIndex));
        keyIndexMap.remove(indexKeyMap.get(lastIndex));
        indexKeyMap.remove(lastIndex);
    }

    public K getRandom() {
        if (size == 0) {
            return null;
        }
        int index = (int) (Math.random() * size);
        return indexKeyMap.get(index);
    }

}
