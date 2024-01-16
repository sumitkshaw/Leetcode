public class Solution {

    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            char start = s.charAt(i);
            char end = s.charAt(j);

            if (!Character.isLetterOrDigit(start)) {
                i++;
                continue;
            }

            if (!Character.isLetterOrDigit(end)) {
                j--;
                continue;
            }

            if (Character.toLowerCase(start) != Character.toLowerCase(end)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        // Example Usage
        Solution solution = new Solution();
        String palindromeString = "A man, a plan, a canal: Panama";
        boolean isPalindrome = solution.isPalindrome(palindromeString);
        System.out.println("Is \"" + palindromeString + "\" a palindrome? " + isPalindrome);
    }
}
