import java.util.HashMap;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        String s = "a";
        String t = "b";
        boolean anagram = isAnagram(s, t);
        System.out.println(anagram);
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.replace(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            if (map.containsKey(t.charAt(i))) {
                map.replace(t.charAt(i), map.get(t.charAt(i)) - 1);
            } else {
                return false;
            }
        }
        Set<Character> entries = map.keySet();
        for (Character entry : entries) {
            if (map.get(entry) != 0) {
                return false;
            }
        }
        return true;
    }
}
