package zrc.course;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Algorithm20 {
}

/*
有n个打包机从左到右依次排开，会随机选择一批物品放到每个打包机上
放到每个机器上的物品数量有多有少，由于物品数量不同，需要将物品移动至相同数量才可以打包
每次只能搬运一次物品，物品只能在相邻机器上移动
请计算搬运最小的次数
 */
class CarryNum {
    public int minOps(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int size = arr.length;
        int sum = 0;
        for (int value : arr) {
            sum += value;
        }
        if (sum % size != 0) {
            return -1;
        }
        int avg = sum / size;
        int leftSum = 0;
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            int leftRest = leftSum - i * avg;
            int rightRest = (sum - leftSum - arr[i]) - (size - i - 1) * avg;
            if (leftRest < 0 && rightRest < 0) {
                ans = Math.max(ans, Math.abs(leftRest) + Math.abs(rightRest));
            } else {
                ans = Math.max(ans, Math.max(Math.abs(leftRest), Math.abs(rightRest)));
            }
            leftSum += arr[i];
        }
        return ans;
    }
}

/*
假设s和m初始化，s='a'; m=s;
再定义两种操作，第一种操作
m=s
s=s+s
第二种操作
s=s+m
求最小的操作步骤，可以将s拼接到长度等于n
 */
class MinOption {
    public int[] divsSumAndCount(int n) {
        int sum = 0;
        int count = 0;
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                sum += i;
                count++;
                n /= i;
            }
        }
        return new int[]{sum, count};
    }

    public int solution(int n) {
        if (n < 2) {
            return 0;
        }
        if (isPrim(n)) {
            return n - 1;
        }
        int[] div = divsSumAndCount(n);
        return div[0] - div[1];
    }

    private boolean isPrim(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}

/*
给定一个字符串数组，求出现频率的前k个
 */
class TopWordK {
    public String[] solution(String[] words, int k) {
        String[] result = new String[k];
        HashMap<String, Integer> map = new HashMap<>();
        for (String string : words) {
            if (!map.containsKey(string)) {
                map.put(string, 1);
            } else {
                map.put(string, map.get(string) + 1);
            }
        }
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();
        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(stringIntegerEntry.getKey());
            } else {
                if (stringIntegerEntry.getValue() > map.get(priorityQueue.peek())) {
                    priorityQueue.poll();
                    priorityQueue.add(stringIntegerEntry.getKey());
                }
            }
        }
        int index = k - 1;
        while (!priorityQueue.isEmpty()) {
            result[index--] = priorityQueue.poll();
        }
        return result;
    }
}

/*
现在要实现一种结构，来统计词频的前k个
并且可以动态的添加和动态的返回结果
 */
class TopKTimes {
    private static class Node {
        String word;
        int times;

        public Node(String word, int times) {
            this.word = word;
            this.times = times;
        }
    }

    private static class Heap {
        HashMap<String, Node> stringTimesMap;
        HashMap<Node, Integer> indexMap;
        Node[] heap;
        int index;

        public Heap(int size) {
            stringTimesMap = new HashMap<>();
            indexMap = new HashMap<>();
            heap = new Node[size];
            index = 0;
        }

        public void addNode (String string) {
            Node currNode = null;
            int preIndex = -1;
            if (!stringTimesMap.containsKey(string)) {
                currNode = new Node(string, 1);
                stringTimesMap.put(string, currNode);
                indexMap.put(currNode, -1);
            } else {
                currNode = stringTimesMap.get(string);
                currNode.times++;
                preIndex = indexMap.get(currNode);
            }
            if (preIndex == -1) {
                if (index == heap.length) {
                    if (heap[0].times < currNode.times) {
                        indexMap.put(heap[0], -1);
                        indexMap.put(currNode, 0);
                        heap[0] = currNode;
                        heapify(0, index);
                    }
                } else {
                    indexMap.put(currNode, index);
                    heap[index] = currNode;
                    heapInsert(index++);
                }
            } else {
                heapify(preIndex, index);
            }
        }

        private void heapInsert(int index) {
            while (index != 0) {
                int parent = (index - 1) / 2;
                if (heap[index].times < heap[parent].times) {
                    swap(parent, index);
                    index = parent;
                } else {
                    break;
                }
            }
        }

        public void printTopK () {
            for (int i = heap.length - 1; i >= 0; i--) {
                System.out.println(heap[i].word);
                System.out.println(heap[i].times);
            }
        }

        private void heapify(int index, int heapSize) {
            int left = index * 2 + 1;
            while (left < heapSize) {
                int smallest = left + 1 < heapSize && heap[left + 1].times < heap[left].times ? left + 1 : left;
                smallest = heap[smallest].times < heap[index].times ? smallest : index;
                if (smallest == index) {
                    break;
                }
                swap(index, left);
                index = left;
                left = index * 2 + 1;
            }
        }

        private void swap(int i, int j) {
            indexMap.put(heap[i], j);
            indexMap.put(heap[j], i);
            Node temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }
    }
}
