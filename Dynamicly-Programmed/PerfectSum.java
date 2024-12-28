class Solution {
    // Function to calculate the number of subsets with a given sum
    public int perfectSum(int[] nums, int target) {
        // code here
        int n = nums.length; 
        int dp [][]=new int [n][target+1];
               
        for(int i =0 ;i<n;i++){
            for(int j =0; j<target+1;j++){
                dp[i][j] =-1;
            }
        }
        return recur(nums, target ,n-1 ,dp);
    }
    int recur(int nums[] , int target , int index ,int dp[][]){
        //basse case
        if(index == 0){
            if(target ==0 && nums[index] == 0) {
                dp[index][target] =2;
                return 2;
            }
            else if(target == 0) {
                dp[index][target]= 1;
                return 1;
            }
            else if(target == nums[index]){
                dp[index][target]= 1;
                return 1;
            }
            else{
                dp[index][target]= 0;
                return 0;
            } 
        }
        if( dp[index][target] != -1){
            return  dp[index][target];
        }
    
        int pick =0;
        if(nums[index] <= target){
            pick = recur(nums ,target - nums[index] ,index -1,dp);
        }
        int noPick = recur(nums, target, index-1,dp);
        dp[index][target]=pick + noPick ;
        return  dp[index][target];
    }
}

//tabulation

    public int perfectSum(int[] nums, int target) {
        // code here
        int n = nums.length; 
        int dp [][]=new int [n][target+1];
        
        // if(index == 0){
        for(int t=0 ;t<target+1;t++){
            if(t ==0 && nums[0] == 0) {
                dp[0][t] =2;
            }
            else if(t == 0) {
                dp[0][t]= 1;
            }
            else if(t == nums[0]){
                dp[0][t]= 1;
            }
            else{
                dp[0][t]= 0;
            } 
        }
        
        for(int i =1 ;i<n;i++){
            for(int j =0; j<target+1;j++){
                int pick =0;
                if(nums[i] <= j){
                    pick =dp[i-1][j -nums[i]];// recur(nums ,target - nums[index] ,index -1,dp);
                }
                int noPick = dp[i-1][j];//recur(nums, target, index-1,dp);
                dp[i][j]=pick + noPick ;
            }
        }
        return dp[n-1][target];//recur(nums, target ,n-1 ,dp);
    }
