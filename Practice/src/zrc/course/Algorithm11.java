package zrc.course;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Algorithm11 {

}

class CountIsland {
    public int solution(int[][] matrix) {
        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0) {
                    infect(matrix, i, j);
                    result += 1;
                }
            }
        }
        return result;
    }

    private void infect(int[][] matrix, int i, int j) {
        if (matrix[i][j] == 0) {
            return;
        }
        matrix[i][j] = 0;
        if (i - 1 > 0) {
            infect(matrix, i - 1, j);
        }
        if (i + 1 < matrix.length) {
            infect(matrix, i + 1, j);
        }
        if (j - 1 > 0) {
            infect(matrix, i, j - 1);
        }
        if (j + 1 < matrix[i].length) {
            infect(matrix, i, j + 1);
        }
    }

    // 如何设计一种并行方案来解决此问题
    /*
    对于一种大的图而言，我们可以将其分为多个部分进行计算，假设分为两部分
    在分别得到结果之后，将两部分的结果合并起来就是最终结果
    例如，matrix为
    1 1 1 1 | 1 1 1 1
    1 0 0 0 | 0 0 0 1
    1 0 1 1 | 1 1 1 1
    1 0 1 0 | 0 0 0 0
    1 0 1 1 | 1 1 1 1
    1 0 0 0 | 0 0 0 1
    1 1 1 1 | 1 1 1 1
    我们将其分为左右两部分，计算之后的结果是，左半部分有2块岛屿，右半部分有2块岛屿，共4块岛屿
    但是实际上只有一块岛屿， 因为我们在对其划分的时候破坏了图的连通性，为了解决这个问题我们可以
    使用并查集
    首先在计算左半部分的时候，我们需要额外记录左半部分右边界的感染源
    例如: matrix[0][3]、matrix[6][3]的感染源就是matrix[0][0]，记作A
         matrix[2][3]、matrix[4][3]的感染源是matrix[2][2]，记作B
    在计算右半部份的时候，我们需要额外记录右半部份左边界的感染源
    例如: matrix[0][4]、matrix[2][4]的感染源是matrix[0][4]，记作C
        matrix[4][4]、matrix[6][4]的感染源是matrix[4][4]，记作D
    在分别计算完两边的结果后，我们在合并过程中，申请一个并查集，将A B C D加入并查集
    之后检查合并过程中的边界
    如果待合并的两边都是岛屿，那么将这两个岛屿的感染源加入到一个集合，并将之前的结果减一
    否则，继续遍历，直到遍历完带合并的边界
     */
}

class UnionFind<V> {
    private static class Element<V> {
        V value;

        public Element(V value) {
            this.value = value;
        }
    }

    private HashMap<V, Element<V>> elementMap;
    private HashMap<Element<V>, Element<V>> fatherMap;
    private HashMap<Element<V>, Integer> sizeMap;

    public UnionFind(List<V> lists) {
        elementMap = new HashMap<>();
        fatherMap = new HashMap<>();
        sizeMap = new HashMap<>();
        for (V value : lists) {
            Element<V> element = new Element<>(value);
            elementMap.put(value, element);
            fatherMap.put(element, element);
            sizeMap.put(element, 1);
        }
    }

    private Element<V> findHead(Element<V> element) {
        Stack<Element<V>> stack = new Stack<>();
        while (element != fatherMap.get(element)) {
            stack.push(element);
            element = fatherMap.get(element);
        }
        while (!stack.isEmpty()) {
            fatherMap.put(stack.pop(), element);
        }
        return element;
    }

    public boolean isSameUnion(V a, V b) {
        if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
            return findHead(elementMap.get(a)) == findHead(elementMap.get(b));
        }
        return false;
    }

    public void union(V a, V b) {
        if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
            Element<V> aF = findHead(elementMap.get(a));
            Element<V> bF = findHead(elementMap.get(b));
            if (aF != bF) {
                Element<V> big = sizeMap.get(aF) > sizeMap.get(bF) ? aF : bF;
                Element<V> small = big == aF ? bF : aF;
                fatherMap.put(small, big);
                sizeMap.put(big, sizeMap.get(aF) + sizeMap.get(bF));
                sizeMap.remove(small);
            }
        }
    }
}

// KMP
/*
字符串str1和str2，str1是否包含str2，如果包含返回str2在str1中开始的位置，时间复杂度为O(N)
明确一个概念，最长前后子后缀匹配长度
例如: "abbabbK" 对于K而言
    前缀 : a ab abb abba abbab 不包含整体
    后缀 : b ab abb babb bbabb 不包含整体
    所以K这个字符所要记录的信息就是3
对于str2这个字符串中的每一个字符我们都需要这个信息，我们需要一个数组来保存这个信息
例如: str2为"aabaabs"
    此时int[] nexts = {-1, 0, 1, 0, 2, 3};
在得到nexts数组之后，我们就可以加速计算过程
str1 : ......i.......................X
str2 :       0.......................Y
从str1的i位置与str2开始匹配，在str1到达X位置，str2到达Y位置之前，一直匹配成功
在经典过程中，当X位置与Y位置匹配失败，str1将会跳到i+1位置，str2将会跳到0位置
在KMP过程中，str1的比对位置停留在X不变，str2的比对位置，从Y位置回跳到Y这个字符的最大匹配长度的位置处
例如:
    str1 : ......abbstkscabbstks
    str2 :       abbstkscabbstkz
    其中str1中的第一个a的位置是i，str2中的第一个a的位置是0，此时我们尝试从i位置开始，能否匹配成功
    当str1来到i+14位置，str2来到14位置之前str1和str2的匹配过程没有出现不符的情况
    当来到str1来到i+14位置，str2来到14位置时，我们发现匹配失败
    经典过程，对于str1而言我们需要从i+14位置回跳到i+1位置，对于str2而言我们需要回跳到0位置
    KMP过程，对于str1而言比对位置不变，而由于str2的14位置上的字符其nexts数组中的值是6，所以str2的匹配位置回跳到6位置
   【1】这个时候我们描述两件事：
    (1)检查str1的i+8位置开始与str2的0位置开始能否比匹配成功
                          ||
    (2)检查str1的i+14位置开始与str2的6位置开始，能否匹配成功
    因为前缀与后缀的缘故，所以(1)等价于(2)
   【2】我们可以证明str1在i到i+8中间的任何一个位置开头都是无法与str2匹配成功的
    如何证明时间复杂度是O(N)
                          i1(Max -> N)    i1 - i2(Max -> N)
    循环中的第一个分支             +              =
    循环中的第二个分支             +              +
    循环中的第三个分支             =              +
    在整个循环中这两个量的总值最大可以达到2N，循环过程中3个分支只会走一个，这三个分支都在将这个量增加
    故时间复杂度为O(N)
 */
class KMP {
    public int getIndexOf(String s, String m) {
        if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
            return -1;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = s.toCharArray();
        int i1 = 0;
        int i2 = 0;
        int[] nexts = getNextArray(str2);
        while (i1 < str1.length && i2 < str2.length) {
            if (str1[i1] == str2[i2]) {
                i1++;
                i2++;
            } else if (nexts[i2] == -1) {
                i1++;
            } else {
                i2 = nexts[i2];
            }
        }
        return i2 == str2.length ? i1 - i2 : -1;
    }

    private int[] getNextArray(char[] str) {
        if (str.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[str.length];
        next[0] = -1;
        next[1] = 0;
        int cn = 0;
        int i = 2;
        while (i < next.length) {
            if (str[i - 1] == str[cn]) {
                next[i++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }
}