class Solution {
    public int findPeakElement(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        
        // Handling the edge case when the array has only one element
        if (arr.length == 1) {
            return 0;
        }
        
        while (start < end) {
            int mid = start + (end - start) / 2;
            
            if (arr[mid] < arr[mid + 1]) {
                // Ascending part of the array, move right
                start = mid + 1;
            } else {
                // Descending part of the array, move left
                end = mid;
            }
        }
        
        // start and end will converge to the peak index
        return start;
    }
}
