class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int res[] = new int[nums.length - k + 1];// n-k+1

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        // 1st window
        for (int i = 0; i < k; i++) {
            pq.add(new Pair(nums[i], i));
        }
        res[0] = pq.peek().val;
        for (int i = k; i < nums.length; i++) {
            while (pq.size() > 0 && pq.peek().idx <= (i - k)) {
                pq.remove();
            }
            pq.add(new Pair(nums[i], i));
            res[i - k + 1] = pq.peek().val;
        }
        // print result
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();

        return res;
    }
    static class Pair implements Comparable<Pair> {
        int val;
        int idx;

        public Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair p2) {
            // ascrnding
            // return this.val-this.idx
            // descending
            return p2.val - this.val;
        }
    }
}
