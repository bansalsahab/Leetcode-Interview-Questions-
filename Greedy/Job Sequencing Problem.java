class Solution {

    public ArrayList<Integer> JobSequencing(int[] id, int[] deadline, int[] profit) {
        // code here..
        int n =0;
        for(int d : deadline){
            n = Math.max(n,d);
        }
        int assignedjob[] = new int[n+1];
        Arrays.fill(assignedjob , -1);
      
        int len = profit.length;
        Integer index[] = new Integer[len];
        for(int i =0 ; i< len ;i++){
            index[i] = i;
        }
        //profit k decreasing order k hiasb se sort
        
        Arrays.sort(index ,(a,b) -> profit[b]- profit[a]);
        int count =0 ;
        int maxProfit =0 ;
        
        for(int i =0; i< profit.length;i++){
            int ind = index[i];
            int d = deadline[ind];
            while(assignedjob[d] != -1) d--;
            if(d == 0) continue;
            count++;
            assignedjob[d]= id[ind];
            maxProfit += profit[ind];
        }
        ArrayList<Integer> result=  new ArrayList<>();
        result.add(count);
        result.add(maxProfit);
        return result;
    }
    
}
