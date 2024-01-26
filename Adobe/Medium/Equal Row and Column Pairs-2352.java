class Solution {
    public int equalPairs(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int result[][] = new int[cols][rows];
        for(int i=0; i<cols ;i++){
            for(int j=0; j<rows;j++){
                result[i][j]=grid[j][i];
            }
        }
        int count =0;
        for(int i=0;i<rows;i++){
            for(int j=0 ; j<cols;j++){
                if(Arrays.equals(grid[i],result[j])){
                    count++;
                }
            }
        }
        return count;
    }
}
