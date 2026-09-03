class Solution {
    int max=0;
    public int maximalRectangle(char[][] matrix) {
        int n=matrix[0].length;
        int[] heights=new int[n];
        for(int i=0;i<matrix.length;i++){
            if(i==0){
                for(int j=0;j<n;j++){
                    if(matrix[i][j]=='1') heights[j]=1;
                }
            }
            else{
                for(int j=0;j<n;j++){
                    if(matrix[i][j]=='1') heights[j]+=1;
                    else heights[j]=0;
                }
            }
            solve(heights);
        }
        return max;
    }

    private void solve(int[] heights){
        Deque<Integer> stack=new ArrayDeque<>();

        for(int i=0;i<=heights.length;i++){
            int currHeight=i==heights.length?0:heights[i];

            while(!stack.isEmpty() && currHeight<heights[stack.peek()]){
                int height=heights[stack.pop()];
                int left=stack.isEmpty()?-1:stack.peek();
                int width=i-left-1;

                max=Math.max(max,height*width);
            }
            stack.push(i);
        }
    }
}