class Solution {
    public int maxx(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
        }
        return max;
    }

    public int CanMake(int[] bloomDay, int mid, int k) {
        int bouquetCount = 0;
        int consecutiveCount = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= mid) {
                consecutiveCount++;
            } else {
                consecutiveCount = 0;
            }
            if (consecutiveCount == k) {
                bouquetCount++;
                consecutiveCount = 0;
            }
        }
        return bouquetCount;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        // Check if it's even possible to make m bouquets
        if (bloomDay.length < m * k) {
            return -1; // Not enough flowers to make the required bouquets
        }

        int left = 0;
        int right = maxx(bloomDay);
        int minDay = -1; // Initialize minDay with -1 to handle the case where it's impossible

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (CanMake(bloomDay, mid, k) >= m) {
                minDay = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return minDay;
    }
}
