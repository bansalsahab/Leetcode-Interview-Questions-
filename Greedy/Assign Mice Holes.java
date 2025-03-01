class Solution {
    static int assignMiceHoles(int N , int[] M , int[] H) {
        // code here
        Arrays.sort(M);
        Arrays.sort(H);
        int Maxtime =0;
        for(int i =0 ;i<N;i++){
            Maxtime = Math.max(Maxtime ,Math.abs(M[i] - H[i]));
        }
        return Maxtime;
    }
};
