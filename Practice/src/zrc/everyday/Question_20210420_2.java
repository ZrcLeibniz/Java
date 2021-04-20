package zrc.everyday;

import java.util.ArrayList;
import java.util.Scanner;

public class Question_20210420_2 {
    public static int solution(ArrayList<Integer> people) {
        int index = 0;
        while (people.size() != 1) {
            index = (index + 2) % people.size();
            people.remove(index);
        }
        return people.get(0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            if (n > 1000) {
                n = 999;
            }
            ArrayList<Integer> people = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                people.add(i);
            }
            int solution = solution(people);
            System.out.println(solution);
        }
    }
}
