public class MinRemoveValidParentheses {

    public static String minRemoveToMakeValid(String s) {

        char[] arr = s.toCharArray();
        int openParenthesesCount = 0;

        // First pass: remove extra ')'
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == '(') {
                openParenthesesCount++;
            }
            else if (arr[i] == ')') {

                if (openParenthesesCount == 0) {
                    arr[i] = '*';  // mark invalid ')'
                } else {
                    openParenthesesCount--;
                }
            }
        }

        // Second pass: remove extra '(' from end
        for (int i = arr.length - 1; i >= 0 && openParenthesesCount > 0; i--) {

            if (arr[i] == '(') {
                arr[i] = '*';  // mark invalid '('
                openParenthesesCount--;
            }
        }

        // Build result
        StringBuilder sb = new StringBuilder();

        for (char c : arr) {
            if (c != '*') {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        String s1 = "lee(t(c)o)de)";
        String s2 = "a)b(c)d";
        String s3 = "))((";

        System.out.println(s1 + " → " + minRemoveToMakeValid(s1));
        System.out.println(s2 + " → " + minRemoveToMakeValid(s2));
        System.out.println(s3 + " → " + minRemoveToMakeValid(s3));
    }
}
