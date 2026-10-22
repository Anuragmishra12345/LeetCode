class Solution {
    boolean[][] used;
    public boolean exist(char[][] board, String word) {
        int m=board.length;int n=board[0].length;
        used=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(dfs(board,word,0,i,j)) return true;
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, String word,int index, int row, int col){
        if(index==word.length())return true;

        if(row<0|| col<0 || row>=board.length ||
         col >= board[0].length ||used[row][col] || 
         board[row][col] != word.charAt(index)) return false;

        used[row][col]=true;

        boolean found=dfs(board,word,index+1,row+1,col)||
                      dfs(board,word,index+1,row-1,col)||
                      dfs(board,word,index+1,row,col+1)||
                      dfs(board,word,index+1,row,col-1);

        used[row][col]=false;

        return found;              

    }
}