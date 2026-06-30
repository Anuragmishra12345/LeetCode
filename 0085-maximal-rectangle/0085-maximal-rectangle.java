class Solution {
    public int maximalRectangle(char[][] matrix) {
        int ans=0;
        int n=matrix[0].length;
        int m=matrix.length;
        int[] heights=new int[n];
        for(int row=0;row<matrix.length;row++){
            if(row!=0){
                for(int col=0;col<matrix[0].length;col++){
                    if(matrix[row][col]=='1'){
                        heights[col]++;
                    }
                    else heights[col]=0;
                }
            }
            else {
                for(int col=0;col<n;col++){
                    if(matrix[row][col]=='1') heights[col]=1;
                }
            }
            ans=Math.max(ans,solver(heights));
        }
        return ans;
    }
    int solver(int[] heights){
        Deque<Integer> stack=new ArrayDeque<>();
        int max=0;
        for(int i=0;i<=heights.length;i++){
            int currHeight=(i==heights.length)?0:heights[i];

            while(!stack.isEmpty() && currHeight<heights[stack.peek()]){
                int height=heights[stack.pop()];
                int left=stack.isEmpty()?-1:stack.peek();
                int width=i-left-1;

                max=Math.max(max,height*width);
            }
            stack.push(i);
        }
        return max;
    }
}