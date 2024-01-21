class Solution {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        while (left < right) {
            int containerLength = right - left;
            int area = containerLength * Math.min(height[left], height[right]);
            res = Math.max(res, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example usage with an array of heights
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int maxContainerArea = solution.maxArea(heights);

        System.out.println("Maximum Container Area: " + maxContainerArea);
    }
}
