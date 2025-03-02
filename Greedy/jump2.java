class Solution {
    public int jump(int[] nums) {
        int minjumps =0 ;
        int maxindex =0 ;
        int end= 0;
        int n = nums.length;
        for(int i = 0 ;i < n-1 ; i++){
            maxindex = Math.max(i+nums[i] ,maxindex);
            if(i == end){
                minjumps = minjumps+1;
                end= maxindex;
            }
            if(end >= n-1){
                break;
            }
            
        }
        return minjumps;
    }
}
