class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
        }
        boolean[] visited = new boolean[V];
        boolean[] pathvisited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, visited, adj,pathvisited)) {
                    return true;
                }
            }
        }
        return false;

    }
    public boolean dfs(int src, boolean[] visited, List<List<Integer>> adj,boolean[] pathvisited) {
        visited[src]=true;
        pathvisited[src]=true;
        for(int neighbour:adj.get(src)){
            if(pathvisited[neighbour]) return true;
            else if(visited[neighbour]) continue;
            else{
                if(dfs(neighbour, visited,adj,pathvisited)){
                    return true;
                }
            }
        }
        pathvisited[src]=false;
        return false;
    }
        

}
