class Solution {
    // static class mini implements Comparable<mini>{
    //     int x;
    //     int y;
    //     public mini(int x, int y){
    //         this.x= x;
    //         this.y =y;
    //     }
    //     @Override
    //     public int compareTo(mini p2){
    //         return this.x - p2.x;
    //     }
    // }
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        int operations = 0;
        for (int num : nums) {
            pq.offer((long)num);
        }
        while (pq.size() > 1 && pq.peek() < k) {
            long x = pq.poll(); 
            if(x>=k) break;
            long y = pq.poll();  
            long newElement = x * 2 + y; 
            pq.offer(newElement);
            operations++;
        }
        return operations;
    }
}
