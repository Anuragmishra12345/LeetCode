class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        pq.offer(new int[]{0,0,0});

        int m=heights.length;
        int n=heights[0].length;
        int[][] diff=new int[m][n];

        for(int[] row:diff) Arrays.fill(row,Integer.MAX_VALUE);
        diff[0][0]=0;

        int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};

        while(!pq.isEmpty()){
            int[] cell=pq.poll();

            int di=cell[0];
            int r=cell[1];
            int c=cell[2];

            if(di>diff[r][c]) continue;

            for(int[] d:dir){
                int nr=r+d[0];
                int nc=c+d[1];

                if(nr<m && nr>=0 && nc>=0 && nc<n){
                    int effort=Math.max(di,Math.abs(heights[r][c]-heights[nr][nc]));
                    if(effort<diff[nr][nc]){
                        diff[nr][nc]=effort;
                        pq.offer(new int[]{effort,nr,nc});
                    }
                }
            }
        }
        return diff[m-1][n-1];
    }
}