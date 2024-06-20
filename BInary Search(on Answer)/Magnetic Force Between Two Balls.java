class Solution {
    public boolean isPossible(int[] position ,int minDist ,int m){
        int BallPlaced = 1 ;
        int lastPos =position[0] ;
        for(int i =1; i<position.length;i++){
            if(position[i] - lastPos >= minDist ) {
                BallPlaced++;
                lastPos=position[i];
            }
            if(BallPlaced >= m) {
                return true;

            }
        }
        return false;
        
    }
    public int maxDistance(int[] position, int m) {
        

        int n =position.length;
        if(m>n) return -1;
        Arrays.sort(position);
        int start = 1;
        int end = position[n-1] - position[0];
        int ans= 0;
        while(start<=end){
            int mid = start + (end - start) / 2;
            if(isPossible(position, mid ,m)){
                ans =mid;
                start =mid+1;
            }
            else end=mid-1;
        }
        return ans;
    }
}
