import java.util.*;


public class Test {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            set.add(scanner.next());
        }
        System.out.println(set.size());
    }
}