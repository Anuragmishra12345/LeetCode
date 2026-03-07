class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[] oneRow=new int[m];
        int[] oneCol=new int[n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    oneRow[i]++;
                    oneCol[j]++;
                }
                else{
                    oneRow[i]--;
                    oneCol[j]--;
                }
            }   
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                grid[i][j]=oneRow[i]+oneCol[j];
            }
        }
        return grid;
    }
}