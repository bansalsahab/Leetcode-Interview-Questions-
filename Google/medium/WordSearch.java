class Solution {
    public boolean exist(char[][] board, String word) {
        int m =board.length;
        int n =board[0].length;
        for(int r=0; r<m;r++){
            for(int c=0; c<n;c++){
                if(word.charAt(0) == board[r][c]){
                    boolean found =dfs( board,  r, c, word, 0);
                    if(found)  return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, int r,int c,String word,int wordIndex){
        //base case
        //valid casee
        if(wordIndex == word.length()){
            return true;
        }
        //out of bound cases
        int rows =board.length;
        int cols =board[0].length;

        if(r<0 || r>=rows|| c<0 || c>=cols){
            return false;
        }
        //invalid cases
        if(board[r][c] == ' ' || board[r][c]!=word.charAt(wordIndex)){
            return false;
        }
        //mark as visited
        char ch =board[r][c];
        board[r][c] = ' ';
        //dfs calls
        if( dfs(board ,r-1,c, word,wordIndex+1)||
            dfs(board ,r,c+1, word,wordIndex+1) || 
            dfs(board ,r+1,c, word,wordIndex+1)||
            dfs(board ,r ,c-1, word,wordIndex+1)){
            return true;
        }
        //backtracking
        board[r][c] = ch;
        return false;
    }
}
