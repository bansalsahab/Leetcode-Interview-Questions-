class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result =new ArrayList();
        findAll("(",1,0,result,n);
        return result;
    }
    void findAll(String current, int o,int c,List<String> result,int n){
        //base
        if(current.length()==n*2){
            result.add(current);
            return;
        }
        if(o<n){
            findAll(current+"(",o+1,c,result,n);
        }
        if(c<o){
            findAll(current+")",o,c+1,result,n);
        }
    }
}
