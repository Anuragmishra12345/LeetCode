class Solution {
    public void solveSudoku(char[][] board) {
        solver(board);
    }
    public boolean solver(char[][]board){
        int n=board.length;
        int row=-1; int col=-1;

        boolean isEmpty=false;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='.') {
                    row=i;col=j;
                    isEmpty=true;
                    break;
                }
            }
            if(isEmpty) break;
        }
        if(isEmpty==false) {
            // sudoku solved
            return true; 
        }
        for(char num='1';num<='9';num++){
            if(isSafe(board,row,col,num)){
                board[row][col]=num;
                if(solver(board)) return true;
                else board[row][col]='.';    
            }
        }
        return false;
    }

    public boolean isSafe(char[][] board, int row, int col , char num){
        // check column
        for(int i=0;i<board.length;i++){
            if(board[row][i]==num) return false;
        }
        // check row
        for(int i=0;i<board.length;i++){
            if(board[i][col]==num) return false;
        }    
        // check box
        int sqrt=(int)(Math.sqrt(board.length));
        int rowStart=row-row%sqrt;
        int colStart=col-col%sqrt;
        for(int i=rowStart;i<rowStart+sqrt;i++){
            for(int j=colStart;j<colStart+sqrt;j++){
                if(board[i][j]==num) return false;
            }
        }
        return true;
    }
}