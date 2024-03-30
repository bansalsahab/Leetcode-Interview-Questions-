class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostKDistinct(nums, k) - atMostKDistinct(nums, k - 1);
    }
    
    private int atMostKDistinct(int[] nums, int k) {
        int n = nums.length;
        int windowStart = 0;
        int count = 0;
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        
        for (int windowEnd = 0; windowEnd < n; windowEnd++) {
            int num = nums[windowEnd];
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            
            while (freqMap.size() > k) {
                int leftNum = nums[windowStart];
                freqMap.put(leftNum, freqMap.get(leftNum) - 1);
                if (freqMap.get(leftNum) == 0) {
                    freqMap.remove(leftNum);
                }
                windowStart++;
            }
            
            count += windowEnd - windowStart + 1;
        }
        
        return count;
    }
}
