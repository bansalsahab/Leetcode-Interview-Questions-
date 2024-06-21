/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        
        // Find the peak element index
        int peak = findPeak(mountainArr, 0, n - 1);
        
        // Try to find the target in the ascending part
        int index = ascendingBinarySearch(mountainArr, target, 0, peak);
        if (index != -1) {
            return index;
        }
        
        // Try to find the target in the descending part
        return descendingBinarySearch(mountainArr, target, peak + 1, n - 1);
    }
    
    private int findPeak(MountainArray mountainArr, int start, int end) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                // Ascending part, move right
                start = mid + 1;
            } else {
                // Descending part, move left
                end = mid;
            }
        }
        // start and end will converge to the peak index
        return start;
    }
    
    private int ascendingBinarySearch(MountainArray mountainArr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midVal = mountainArr.get(mid);
            
            if (midVal == target) {
                return mid;
            }
            
            if (midVal < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;  // Target not found
    }
    
    private int descendingBinarySearch(MountainArray mountainArr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midVal = mountainArr.get(mid);
            
            if (midVal == target) {
                return mid;
            }
            
            if (midVal > target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;  // Target not found
    }
}
