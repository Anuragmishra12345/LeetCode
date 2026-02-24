class Solution {
    public int[][] generateMatrix(int n) {
        int num=1;
        int[][] result=new int[n][n];
        int left=0;
        int right=n-1;
        int top=0;
        int bottom=n-1;
        while(left<=right && top<=bottom){
            for(int i=left;i<=right;i++){
                result[top][i]=num;
                num++;
            }
            top++;
            for(int i=top;i<=bottom;i++){
                result[i][right]=num;
                num++;
            }
            right--;
            for(int i=right;i>=left;i--){
                result[bottom][i]=num;
                num++;
            }
            bottom--;
            for(int i=bottom;i>=top;i--){
                result[i][left]=num;
                num++;
            }
            left++;
        }
        return result;
    }
}