class Solution {
    public long countSubarrays(int[] nums, int k) {
        int windowStart = 0;
        int n = nums.length;
        int windowEnd = 0;
        int maxElement = Integer.MIN_VALUE;
        for(int i=0 ; i<n ;i++){
            maxElement = Math.max(maxElement,nums[i]);
        }
        int count  =0;
        long len =0 ;
        while(windowEnd<n){
            if(nums[windowEnd] == maxElement){
                count++;
            }   
            while(count == k){
                len =len + (n -windowEnd);
                if(nums[windowStart]==maxElement){
                    count--;
                }
                windowStart++;
            }
            windowEnd++;
        }
        return len;
    }
}
