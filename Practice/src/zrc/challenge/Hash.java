package zrc.challenge;

import java.util.HashMap;

/*
1.什么是Hash?
    Hash是一种特殊的算法，将无穷大范围的输入，映射到一个固定的范围内，其特点如下：
        1.相同的输入必将获得相同的输出
        2.不同的输入可能会得到相同的输出
        3.hash在其映射返回内饰均匀的

2.Hash表这种结构的时间复杂度
    增删改查的书剑复杂度都可以视为O(1)

 */
public class Hash {
    private Node[] table;
    private int size;

    public Hash(int size) {
        table = new Node[size];
    }

    public void add(String key, String value) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new Node(key, value);
        } else {
            Node cur = table[index];
            while (cur != null) {
                if (cur.getKey().equals(key)) {
                    cur.setValue(value);
                    return;
                }
                cur = cur.next;
            }
            Node node = new Node(key, value);
            node.next = table[index];
            table[index] = node;
        }
    }

    public String getValue(String key) {
        int index = key.hashCode() % size;
        if (table[index] == null) {
            return "";
        } else {
            Node cur = table[index];
            while (cur != null && !cur.getKey().equals(key)) {
                cur = cur.next;
            }
            if (cur == null) {
                return "";
            } else {
                return cur.getValue();
            }
        }
    }

    private int hash(String key) {
        return key.hashCode() % size;
    }
}

class Node {
    private String key;
    private String value;
    Node next;

    public Node(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
