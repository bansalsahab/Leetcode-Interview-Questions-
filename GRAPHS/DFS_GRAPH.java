package GRAPHS;

import java.util.ArrayList;
import java.util.*;

public class DFS {
    public ArrayList<Integer> dfsofgraph(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[v];
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < vis.length; i++) {
            if (!vis[i]) {
                dfs(i, vis, adj, res);
            }
        }
    }

    public void dfs(int node, boolean vis[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> res) {
        vis[node] = true;
        res.add(node);
        for (int neighbour : adj.get(node)) {
            if (!vis[neighbour]) {
                dfs(neighbour, vis, adj, res);
            }
        }
    }
}
