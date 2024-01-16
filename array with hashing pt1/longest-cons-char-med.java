import java.util.HashSet;

public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        HashSet<Integer> hs = new HashSet<>();
        for (int num : nums) hs.add(num);
        int longest = 1;
        for (int num : nums) {
            // check if the num is the start of a sequence by checking if left exists
            if (!hs.contains(num - 1)) { // start of a sequence
                int count = 1;
                while (hs.contains(num + 1)) { // check if hs contains the next number
                    num++;
                    count++;
                }
                longest = Math.max(longest, count);
            }
            if (longest > nums.length / 2) break;
        }
        return longest;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        int result1 = solution.longestConsecutive(nums1);
        System.out.println("Longest consecutive subsequence length for nums1: " + result1);

        // Example 2
        int[] nums2 = {1, 2, 0, 1};
        int result2 = solution.longestConsecutive(nums2);
        System.out.println("Longest consecutive subsequence length for nums2: " + result2);
    }
}
