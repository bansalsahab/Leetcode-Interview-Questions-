class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // Arrays to track rows and columns with zeros
        boolean[] rowHasZero = new boolean[m];
        boolean[] colHasZero = new boolean[n];

        // Iterate through the matrix to mark rows and columns with zeros
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rowHasZero[i] = true;
                    colHasZero[j] = true;
                }
            }
        }

        // Set rows to zero
        for (int i = 0; i < m; i++) {
            if (rowHasZero[i]) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Set columns to zero
        for (int j = 0; j < n; j++) {
            if (colHasZero[j]) {
                for (int i = 0; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
