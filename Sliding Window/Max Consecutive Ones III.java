class Solution {
    public int longestOnes(int[] nums, int k) {
        int windowStart = 0;
        int n = nums.length;
        int windowEnd = 0;
        int zeros = 0;
        int maxCount = 0;

        while (windowEnd < n) {
            if (nums[windowEnd] == 0) {
                zeros++;
            }

              while (zeros > k) {
                if (nums[windowStart] == 0) {
                    zeros--;
                }
                windowStart++;
            }

            maxCount = Math.max(maxCount, windowEnd - windowStart + 1);
            windowEnd++;
        }

        return maxCount;
    }
}
