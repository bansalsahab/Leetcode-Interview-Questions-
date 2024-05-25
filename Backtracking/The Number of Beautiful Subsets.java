class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        return findBsets(nums,k,0,new HashMap<>());
    }
    public int findBsets(int[] nums ,int k ,int index, HashMap<Integer,Integer>freqMap){
        if(index == nums.length){
            if(freqMap.size() ==0) return 0;
            return 1;
        }
        int pick =0;
        int element1 =nums[index]+k;
        int element2 =nums[index]-k;
        if(freqMap.size()==0|| !freqMap.containsKey(element1)&&!freqMap.containsKey(element2)){
            //include
            freqMap.put(nums[index],freqMap.getOrDefault(nums[index],0)+1);
            //elplore
            pick =findBsets(nums,k,index+1,freqMap);
            //bacltrack
            freqMap.put(nums[index], freqMap.get(nums[index])-1);
            if(freqMap.get(nums[index])==0){
                freqMap.remove(nums[index]);
            }
        }
        int noPick = findBsets(nums,k,index+1,freqMap);
        return pick+noPick;
    }
}
