class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>>subsets = new ArrayList();
        generateSubsets(0,candidates,new ArrayList(),subsets,target);
        return subsets;
    }
    void generateSubsets(int start,int[]nums,List<Integer> current,List<List<Integer>>subsets,int target){
        if(target==0){
            subsets.add(new ArrayList(current));
            return;
        }
        if(target<0)return;
        for(int i=start ;i<nums.length; i++){
            if(i>start&& nums[i]==nums[i-1])continue;
            current.add(nums[i]);
            generateSubsets(i+1,nums,current,subsets,target-nums[i]);
            current.remove(current.size()-1);
        }
    }
}
