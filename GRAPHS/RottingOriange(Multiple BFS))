class Solution {
    public int orangesRotting(int[][] grid) {
        int freshCount= 0;
        int n =grid.length;
        int m =grid[0].length;

        Queue<int[]> queue =new LinkedList<>();
        for(int i =0 ; i < grid.length;i++){
            for(int j =0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    freshCount++;
                }
                else if(grid[i][j] ==2){
                    queue.offer(new int[]{i,j});
                }
            }
        }
        if(freshCount == 0) return 0;

        int time= 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            //level by level
            for(int i =0;i<size ;i++){
                int rottelLoc[] =queue.poll();
                int r = rottelLoc[0];
                int c = rottelLoc[1];
                int neighbours[][] = {
                    {r-1,c},{r+1,c},{r,c-1},{r,c+1}
                };
                for(int neighbour[] : neighbours){
                    int nr = neighbour[0];
                    int nc = neighbour[1];
                    //out of bound ya rotten -visited
                    if(nr<0 || nr>=n ||nc>=m ||nc<0|| grid[nr][nc] == 2||grid[nr][nc] == 0){
                        continue;
                    }
                    queue.offer(new int[]{nr,nc});
                    grid[nr][nc]=2;//visited
                    freshCount--;
                    if(freshCount == 0){
                        return time+1;
                    }

                }
            }
            time++;
            // freshCount -= queue.size();
            // if(freshCount == 0) break;
        }
        // return (freshCount == 0)?time:-1;
        return -1;
    }
}
