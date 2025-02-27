class Solution {
    public int activitySelection(List<Integer> start, List<Integer> end) {
        // code here.
        ArrayList<Integer> indexArr =new ArrayList<>();
        for(int i =0;i<end.size() ;i++){
            indexArr.add(i);
        }
        Collections.sort(indexArr, (a,b) -> (end.get(a) - end.get(b)));
        int maxActivity =1 ;
        int LastEnd =end.get(indexArr.get(0));
        for(int i =0 ;i <indexArr.size() ;i++){
            int index =indexArr.get(i);
            if(start.get(index) > LastEnd){
                maxActivity++;
                LastEnd = end.get(index);
            }
        }
        return maxActivity;
        
    }
}


