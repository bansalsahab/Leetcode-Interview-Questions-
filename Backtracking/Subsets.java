class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subs=new ArrayList<>();
        subs.add(new ArrayList<>());
        for(int num : nums){
            int n = subs.size();
            for(int i=0 ; i<n; i++){
                List<Integer> subset = new ArrayList<>(subs.get(i));
                subset.add(num);
                subs.add(subset);
            }
        }
        return subs;
    }
}
