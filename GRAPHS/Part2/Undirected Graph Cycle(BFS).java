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
                if (bfs(i, visited, adj)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean bfs(int src, boolean[] visited, List<List<Integer>> adj) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {src, -1});
        visited[src] = true;

        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            int node = pair[0];
            int parent = pair[1];

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(new int[] {neighbor, node});
                } else if (neighbor != parent) {
                    // If visited and not parent, then cycle exists
                    return true;
                }
            }
        }

        return false;
    }
}
