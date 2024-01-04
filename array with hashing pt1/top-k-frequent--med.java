import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        List<List<Integer>> freq = new ArrayList<>(nums.length + 1);

        for (int i = 0; i <= nums.length; i++) {
            freq.add(new ArrayList<>());
        }

        for (int n : nums) {
            count.put(n, 1 + count.getOrDefault(n, 0));
        }

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int n = entry.getKey();
            int c = entry.getValue();
            freq.get(c).add(n);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = freq.size() - 1; i > 0; i--) {
            for (int n : freq.get(i)) {
                result.add(n);
                if (result.size() == k) {
                    return result;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        List<Integer> result = solution.topKFrequent(nums, k);

        System.out.println("Top " + k + " frequent elements: " + result);
    }
}
