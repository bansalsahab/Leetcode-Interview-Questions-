class Solution {
    private static void dfs(int src, List<List<Integer>> adj, boolean[] visited, Stack<Integer> st) {
        visited[src] = true;
        for (int neighbour : adj.get(src)) {
            if (!visited[neighbour]) {
                dfs(neighbour, adj, visited, st);
            }
        }
        st.push(src);
    }

    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
        }

        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited, st);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        while (!st.isEmpty()) {
            result.add(st.pop());
        }

        return result;
    }
}
