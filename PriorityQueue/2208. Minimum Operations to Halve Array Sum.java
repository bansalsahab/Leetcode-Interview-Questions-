class Solution {
    public int halveArray(int[] nums) {
        double totalSum = 0;
        PriorityQueue<Double> pq = new PriorityQueue<>((a, b) -> Double.compare(b, a)); // Max-heap
        for (int num : nums) {
            totalSum += num;
            pq.offer((double) num);
        }

        double target = totalSum / 2;
        double reducedSum = 0;
        int operations = 0;

        while (reducedSum < target) {
            double maxElement = pq.poll(); 
            double halfElement = maxElement / 2;
            reducedSum += halfElement; 
            pq.offer(halfElement); 
            operations++;
        }

        return operations;
    }
}
