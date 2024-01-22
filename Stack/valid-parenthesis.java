import java.util.Stack;

class Solution {

    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (
                stack.isEmpty() &&
                (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']')
            ) return false; else {
                    if (
                        s.charAt(i) == ')' && stack.peek() == '('
                    ) stack.pop(); else if (
                        s.charAt(i) == '}' && stack.peek() == '{'
                    ) stack.pop(); else if (
                        s.charAt(i) == ']' && stack.peek() == '['
                    ) stack.pop(); else stack.add(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1: Valid string
        String validString = "{[()]}";
        boolean isValid1 = solution.isValid(validString);
        System.out.println("Is \"" + validString + "\" valid? " + isValid1);

        // Example 2: Invalid string
        String invalidString = "[(])";
        boolean isValid2 = solution.isValid(invalidString);
        System.out.println("Is \"" + invalidString + "\" valid? " + isValid2);

        // Example 3: Valid string
        String anotherValidString = "()";
        boolean isValid3 = solution.isValid(anotherValidString);
        System.out.println("Is \"" + anotherValidString + "\" valid? " + isValid3);
    }
}
