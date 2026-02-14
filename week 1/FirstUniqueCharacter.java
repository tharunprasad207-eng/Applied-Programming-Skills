import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacter {

    public static int firstUniqChar(String s) {

        Map<Character, Integer> freq = new HashMap<>();

        // Count frequency
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // Find first unique character
        for (int i = 0; i < s.length(); i++) {`
            if (freq.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        String s = "leetcode";

        int result = firstUniqChar(s);

        if (result != -1)
            System.out.println("First unique character index: " + result);
        else
            System.out.println("No unique character found");
    }
}
