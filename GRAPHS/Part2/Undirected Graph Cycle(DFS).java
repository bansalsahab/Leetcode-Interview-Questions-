class Solution {
    public boolean isCycle(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u); 
        }

        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, -1,visited, adj)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(int src,int parent, boolean[] visited, List<List<Integer>> adj) {
        
        visited[src]=true;
        for(int neighbour:adj.get(src)){
            if(neighbour == parent ) continue;
            if(visited[neighbour]){
                return true;
            }
            else{
                if(dfs(neighbour , src,visited,adj)){
                        return true;
                }
                
            }
        }
        return false;
    }
}
