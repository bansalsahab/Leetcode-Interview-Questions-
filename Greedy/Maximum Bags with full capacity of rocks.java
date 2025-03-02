class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        int diff[] = new int[n];
        for(int i =0 ; i<n; i++){
            diff[i]  = capacity[i] - rocks[i];
        }
        Arrays.sort(diff);
        int count =0 ;
        for(int i =0 ;i<diff.length; i++){
            // if(diff[i] == 0) count++;
            if(diff[i]<=additionalRocks){
                count++;
                additionalRocks =additionalRocks- diff[i];
            }
        }
        return count;
    }
}
