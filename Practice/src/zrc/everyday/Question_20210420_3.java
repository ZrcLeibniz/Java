package zrc.everyday;

import java.util.*;

public class Question_20210420_3 {
    public static int[] solution(int[] arr) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2 - o1;
                    }
                }
        );
        for (int i = 0; i < arr.length - 1; i++) {
            if (queue.size() < arr[arr.length - 1]) {
                queue.add(arr[i]);
            } else {
                if (arr[i] < queue.peek()) {
                    queue.remove(queue.peek());
                    queue.add(arr[i]);
                }
            }
        }
        int[] result = new int[arr[arr.length - 1]];
        int index = 0;
        for (Integer integer : queue) {
            result[index++] = integer;
        }
        Arrays.sort(result);
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        while (scanner.hasNext()) {
            int i1 = scanner.nextInt();
            list.add(i1);
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        int[] result = solution(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
