class Solution {
    public long repairCars(int[] ranks, int cars) {
        Arrays.sort(ranks); 
        
        long startTime = 0;
        long endTime = (long)ranks[0] * (long) cars * (long)cars;
        
        long ans = 0;
        
        while (startTime <= endTime) {
            long mid = startTime + (endTime - startTime) / 2;
            
            if (isCarRepaired(mid, ranks, cars)) {
                ans = mid; 
                endTime = mid - 1; 
            } else {
                startTime = mid + 1;
            }
        }
        return ans;
    }
    public boolean isCarRepaired(long repairedTime, int[] ranks, int remainingCars) {
        long carsRepaired = 0;
        
        for (int rank : ranks) {
            carsRepaired += (long) Math.sqrt(repairedTime / rank); 
            if (carsRepaired >= remainingCars) return true;
        }
        
        return false;
    }
}

