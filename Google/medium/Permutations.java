
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> subsets=new ArrayList<>() ;
        generatPermute(nums,new ArrayList<>(),subsets);
        return subsets;
    }
    void generatPermute(int[] nums,List<Integer> current,List<List<Integer>>subsets){
    if(current.size()==nums.length){
        subsets.add(new ArrayList<>(current));
        return;
    }
    for(int i=0 ;i<nums.length; i++){
        if(current.contains(nums[i]))
        continue;
        current.add(nums[i]);
        generatPermute(nums,current,subsets);
        current.remove(current.size()-1);
    }}
}
