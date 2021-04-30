package zrc.everyday;


import java.util.HashMap;
import java.util.Scanner;

public class Question_20210630_2 {
    static HashMap<String, Integer> map = new HashMap<>();

    static {
        map.put("3", 1);
        map.put("4", 2);
        map.put("5", 3);
        map.put("6", 4);
        map.put("7", 5);
        map.put("8", 9);
        map.put("9", 10);
        map.put("10", 11);
        map.put("J", 12);
        map.put("Q", 13);
        map.put("K", 14);
        map.put("A", 15);
        map.put("2", 16);
    }

    private static Card type(String card) {
        String[] string = card.split(" ");
        int length = string.length;
        if (length == 2) {
            return string[0].equals("joker") || string[0].equals("JOKER") ? Card.JOKER : Card.COUPLET;
        } else if (length == 3) {
            return Card.TRIPLE;
        } else if (length == 4) {
            return Card.BOMB;
        } else if (length == 5) {
            return Card.STRAIGHT;
        }
        return null;
    }

    private static int win(String cardA, String cardB) {
        Card typeA = type(cardA);
        Card typeB = type(cardB);
        String[] A = cardA.split(" ");
        String[] B = cardB.split(" ");
        int result = 0;
        if (typeA != typeB) {
            if (typeA == Card.JOKER) {
                result = 1;
            } else if (typeB == Card.JOKER) {
                result = -1;
            } else if (typeA == Card.BOMB) {
                result = 1;
            } else if (typeB == Card.BOMB) {
                result = -1;
            }
        } else {
            result = map.get(A[0]) > map.get(B[0]) ? 1 : -1;
        }
        return result;
    }

    public static void printCard(String string) {
        int index = 0;
        while (string.charAt(index) != '-') {
            index++;
        }
        String cardA = string.substring(0, index);
        String cardB = string.substring(index + 1, string.length());
        int win = win(cardA, cardB);
        if (win == 1) {
            System.out.println(cardA);
        } else if (win == -1) {
            System.out.println(cardB);
        } else {
            System.out.println("ERROR");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String card = scanner.nextLine();
            printCard(card);
        }
    }
}

enum Card {
    ALONE,
    COUPLET,
    TRIPLE,
    STRAIGHT,
    BOMB,
    JOKER;
}