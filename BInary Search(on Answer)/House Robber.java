class Solution {
    public int minCapability(int[] nums, int k) {
        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        for(int num : nums){
            if(num < start){
                start = num;
            }
            if(num > end){
                end= num;
            }
        }
        int ans =0 ;
        while(start <= end){
            int mid = start + (end -start)/2;
            if(isRobberPossible(mid, nums,k)){
                ans = mid ;
                end = mid-1;
            }
            else{
                start= mid+1;
            }
        }
        return ans;

    }
    public boolean isRobberPossible(int capability ,int nums[] , int minHouse){
        int houseRobbed =0 ;
        for(int  i=0 ; i < nums.length ; i++){
            if(nums[i] <= capability){
                houseRobbed++;
                i++;
            }
            if(houseRobbed >= minHouse) return true;
        }
        return false;
    }
}
