package GRAPHS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public ArrayList<Integer> bfsgraph(int V ,ArrayList<ArrayList<Integer>> adj){
        boolean visited[] = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer>res = new ArrayList<>();
        for(int i= 0 ;i <V ;i++){
            if(!visited[i]){
                bfs(i,queue,visited,res,adj);
            }
        }
        
        return res;
    }



    public void bfs(int source, Queue<Integer> queue,boolean visited[], ArrayList<Integer>res, ArrayList<ArrayList<Integer>> adj){
        visited[source] = true;
        queue.offer(source);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            res.add(node);
            for(int neighbour : adj.get(node)){
                if(!visited[neighbour]){
                    visited[neighbour] = true;
                    queue.offer(neighbour);
                }
            }
        }
    }
}
