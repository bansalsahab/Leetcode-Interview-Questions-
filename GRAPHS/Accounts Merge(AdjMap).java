class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String ,List<String>> adjmap = new HashMap<>();
        for(List<String> account:accounts){
            String firstEmail = account.get(1);
            for(int i =2 ;i < account.size() ;i++){
                String email = account.get(i);
                if(!adjmap.containsKey(firstEmail)){
                    adjmap.put(firstEmail,new ArrayList<>());
                }
                adjmap.get(firstEmail).add(email);
                if(!adjmap.containsKey(email)){
                    adjmap.put(email,new ArrayList<>());
                }
                adjmap.get(email).add(firstEmail);
            }
        }
        List<List<String>> res =new ArrayList<>();
        HashSet<String> visited =new HashSet<>();
        for(List<String> account:accounts){
            String firstEmail =account.get(1);
            if(!visited.contains(firstEmail)){
                List<String> sublist = new ArrayList<>();
                dfs(firstEmail,visited,adjmap,sublist);
                Collections.sort(sublist);
                //add name
                sublist.add(0,account.get(0));
                res.add(sublist);
            } 
        }

        return res;
    }
    public void dfs(String srcEmail,HashSet<String> visited, HashMap<String ,List<String>> adjmap,List<String>sublist){
        visited.add(srcEmail);
        sublist.add(srcEmail);
        if(!adjmap.containsKey(srcEmail)){
            return;
        }
        for(String neighbour : adjmap.get(srcEmail)){
            if(!visited.contains(neighbour)){
                dfs(neighbour,visited,adjmap,sublist);
            }
        }
    }
}
