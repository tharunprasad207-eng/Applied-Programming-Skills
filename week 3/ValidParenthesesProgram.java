import java.util.Stack;

public class ValidParenthesesProgram {

    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            // Push opening brackets
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }
            else {

                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                if (ch == ')' && top != '(') return false;
                if (ch == ']' && top != '[') return false;
                if (ch == '}' && top != '{') return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {

        String s1 = "()[]{}";
        String s2 = "(]";
        String s3 = "([{}])";

        System.out.println(s1 + " → " + isValid(s1));
        System.out.println(s2 + " → " + isValid(s2));
        System.out.println(s3 + " → " + isValid(s3));
    }
}
