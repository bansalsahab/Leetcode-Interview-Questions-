
class Solution {
  public int eraseOverlapIntervals(int[][] intervals) {
    if (intervals.length == 0) {
      return 0;
    }

    // Sort intervals based on their ending times
    Arrays.sort(intervals, (val1, val2) -> val1[1] - val2[1]);

    int count = 1;
    int lastEndTime = intervals[0][1];
    int n = intervals.length;

    for (int i = 1; i < n; i++) {
      // Check if the current interval overlaps with the previous one
      if (intervals[i][0] >= lastEndTime) {
        // No overlap, update the end time
        count++;
        lastEndTime = intervals[i][1];
      }
    }

    return n - count;
  }
}
