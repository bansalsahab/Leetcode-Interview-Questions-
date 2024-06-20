class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int next = (mid + 1) % arr.length;
            int prev = (mid - 1 + arr.length) % arr.length;

            // Check for peak condition: mid element is greater than both neighbors
            if (arr[mid] > arr[prev] && arr[mid] > arr[next]) {
                return mid;
            }
            // If mid is part of an ascending sequence, move right
            else if (arr[mid] < arr[next]) {
                start = mid + 1;
            }
            // If mid is part of a descending sequence, move left
            else {
                end = mid - 1;
            }
        }

        return -1; // No peak found (should not happen for a valid mountain array)
    }
}
