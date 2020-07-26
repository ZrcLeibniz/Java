package zrc.offer;

import java.util.LinkedList;
import java.util.Queue;

/*
请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class JZ2 {
    public static String replaceSpace(String str) {
        Queue<Character> queue = new LinkedList<Character>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            queue.offer(str.charAt(i));
            Character poll = queue.poll();
            if (!poll.equals(' ')) {
                stringBuilder.append(poll);
            } else {
                stringBuilder.append("%20");
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String s = replaceSpace("We Are Happy");
        System.out.println(s);
    }
}
