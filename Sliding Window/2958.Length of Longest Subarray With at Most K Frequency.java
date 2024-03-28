class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int windowStart = 0;
        int n = nums.length;
        int windowEnd = 0;
        int maxLen = 0;
        HashMap<Integer,Integer> map = new HashMap<>();

        while(windowEnd<n){
            map.put(nums[windowEnd],map.getOrDefault(nums[windowEnd],0)+1);
            //if window is invalid shrink it
            while(map.get(nums[windowEnd])>k){
                map.put(nums[windowStart],map.get(nums[windowStart])-1);
                windowStart++;
            }
             maxLen =Math.max(maxLen,windowEnd-windowStart +1);
             windowEnd++;
        }
        return maxLen;
    }
}
