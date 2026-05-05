class Solution {
    class Tuple{
        int diff;
        int row;
        int col;

        Tuple(int diff, int row, int col){
            this.diff=diff;
            this.row=row;
            this.col=col;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;
        PriorityQueue<Tuple> pq=new PriorityQueue<>((x,y)->x.diff-y.diff);
        int[][] diff=new int[m][n];
        for(int[] row:diff) Arrays.fill(row,Integer.MAX_VALUE);
        diff[0][0] = 0;

        pq.add(new Tuple(0,0,0));
        int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
        while(!pq.isEmpty()){
            Tuple t=pq.poll();
            int d=t.diff;
            int r=t.row;
            int c=t.col;

            if(d>diff[r][c]) continue;

            for(int i=0;i<4;i++){
                int nr=r+dir[i][0];
                int nc=c+dir[i][1];

                if (r == m - 1 && c == n - 1) return d;

                if(nr>=0 && nr<m && nc>=0 && nc<n){
                    int effort=Math.max(Math.abs(heights[r][c]-heights[nr][nc]),d);
                    if(effort<diff[nr][nc]){
                        diff[nr][nc]=effort;
                        pq.add(new Tuple(effort,nr,nc));
                    }
                }
            }
        }
        return diff[m-1][n-1];
    }
}