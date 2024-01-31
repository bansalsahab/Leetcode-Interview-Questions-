class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>>res = new ArrayList();
        generateSubsets(0,nums,new ArrayList(),res);
        return res;
    }
    void generateSubsets(int index,int[] nums,List<Integer> current,List<List<Integer>>res){
        
        res.add(new ArrayList(current));
        for(int i=index ;i<nums.length; i++){
            if(i>index && nums[i-1]== nums[i])continue;
            current.add(nums[i]);
            generateSubsets(i+1,nums,current,res);
            current.remove(current.size()-1);
        }
    }
    
}
