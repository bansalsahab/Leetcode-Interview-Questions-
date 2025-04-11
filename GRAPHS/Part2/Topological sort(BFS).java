class Solution {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
        }
        int indegree[] = new int[V];
        for(int u =0 ; u< adj.size();u++){
            for(int v : adj.get(u)){
                indegree[v]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i= 0; i<V;i++){
            if(indegree[i] ==0){
                queue.offer(i);
            }
        }
        ArrayList<Integer> res  = new ArrayList<>();
        while(!queue.isEmpty()){
            int node = queue.poll();
            res.add(node);
            for(int neighbour : adj.get(node)){
                indegree[neighbour]--;
                if(indegree[neighbour] == 0){
                    queue.offer(neighbour);
                }
            }
        }
        int ans[] = new int[V];
        for(int i= 0 ;i<V ;i++){
            ans[i] = res.get(i);
        }
        return res;    
    }
}
