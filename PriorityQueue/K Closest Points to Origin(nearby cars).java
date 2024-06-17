class Solution {
    static class Point implements Comparable<Point>{
        int x;
        int y;
        int dist;
        
        public Point (int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Point p2){
            return this.dist - p2.dist;
        }
    }

    public int[][] kClosest(int[][] pts, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        
        for(int i = 0; i < pts.length; i++){
            int dist = pts[i][0] * pts[i][0] + pts[i][1] * pts[i][1];
            pq.add(new Point(pts[i][0], pts[i][1], dist));
        }
        
        int[][] result = new int[k][2];
        
        for(int i = 0; i < k; i++){
            Point p = pq.poll();
            result[i][0] = p.x;
            result[i][1] = p.y;
        }
        
        return result;
    }
}
