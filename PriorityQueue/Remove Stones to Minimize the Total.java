class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        int totalSum = 0;
        for (int pile : piles) {
            maxHeap.offer(pile);
            totalSum += pile;
        }
        while (k > 0) {
            int largest = maxHeap.poll(); 
            int removed = largest / 2;  
            totalSum -= removed;
            maxHeap.offer(largest - removed);
            k--;
        }

        return totalSum;
    }
}
