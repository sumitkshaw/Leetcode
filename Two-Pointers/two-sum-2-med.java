public class Solution {

    public int[] twoSum(int[] numbers, int target) {
        int a_pointer = 0;
        int b_pointer = numbers.length - 1;
        int num_a, num_b;

        while (a_pointer < b_pointer) {
            num_a = numbers[a_pointer];
            num_b = numbers[b_pointer];

            if (num_a + num_b == target) break;

            if (num_a + num_b < target) {
                a_pointer++;
                continue;
            }

            b_pointer--;
        }

        return new int[] { a_pointer + 1, b_pointer + 1 };
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[] numbers1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = solution.twoSum(numbers1, target1);
        System.out.println("Example 1: Indices of the two numbers that add up to " + target1 + ": [" + result1[0] + ", " + result1[1] + "]");

        // Example 2
        int[] numbers2 = {-1, 0, 3, 5, 9, 12};
        int target2 = 8;
        int[] result2 = solution.twoSum(numbers2, target2);
        System.out.println("Example 2: Indices of the two numbers that add up to " + target2 + ": [" + result2[0] + ", " + result2[1] + "]");
    }
}
