class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int satisfied = 0;

        // Calculate the initial satisfied customers (when the owner is not grumpy)
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                satisfied += customers[i];
            }
        }

        // Calculate the additional satisfied customers we can get in the first `minutes` window
        int additionalSatisfied = 0;
        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) {
                additionalSatisfied += customers[i];
            }
        }

        int maxAdditionalSatisfied = additionalSatisfied;

        // Slide the window across the array
        for (int i = minutes; i < n; i++) {
            if (grumpy[i] == 1) {
                additionalSatisfied += customers[i];
            }
            //remove the previous customer for maintain the window size 3 
            if (grumpy[i - minutes] == 1) {
                additionalSatisfied -= customers[i - minutes];
            }
            maxAdditionalSatisfied = Math.max(maxAdditionalSatisfied, additionalSatisfied);
        }

        return satisfied + maxAdditionalSatisfied;
    }
}
