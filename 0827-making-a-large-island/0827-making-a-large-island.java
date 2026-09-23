class Solution {
    class DisjointSet{
        List<Integer> parent=new ArrayList<>();
        List<Integer> size=new ArrayList<>();

        DisjointSet(int n){
            for(int i=0;i<n;i++){
                parent.add(i);
                size.add(1);
            }
        }
        int findUPar(int node){
            if(parent.get(node)==node) return node;

            int par=findUPar(parent.get(node));

            parent.set(node,par);

            return par;
        }
        void unionBySize(int u , int v){
            int up=findUPar(u);
            int vp=findUPar(v);

            if(up==vp) return;

            if(size.get(up)<size.get(vp)){
                parent.set(up,vp);
                size.set(vp,size.get(up)+size.get(vp));
            }
            else{
                parent.set(vp,up);
                size.set(up,size.get(up)+size.get(vp));
            }
        }
    }
    int n;
    int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};
    public int largestIsland(int[][] grid) {
        n=grid.length;
        DisjointSet ds=new DisjointSet(n*n);

        for(int r=0;r<n;r++){
            for(int c=0;c<n;c++){
                if(grid[r][c]==0) continue;

                int node=r*n+c;

                if(r+1<n && grid[r+1][c]==1){
                    ds.unionBySize(node,(r+1)*n+c);
                }
                if(c+1<n && grid[r][c+1]==1){
                    ds.unionBySize(node,r*n+c+1);
                }
            }
        }

        int ans=1;
        if(grid[0][0]==1){
            int up=ds.findUPar(0);
            ans=Math.max(ans,ds.size.get(up));
        }

        for(int r = 0; r < n; r++) {
            for(int c = 0; c < n; c++) {

                if(grid[r][c] == 1) continue;

                int currIslandSize=1;
                Set<Integer> set=new HashSet<>();

                for(int[] d:dir){
                    int nr=r+d[0];
                    int nc=c+d[1];

                    if(nr<n && nr>=0 && nc<n && nc>=0 && grid[nr][nc]==1){
                        int parent=ds.findUPar(nr*n+nc);
                        if(!set.contains(parent)){
                            set.add(parent);
                            currIslandSize+=ds.size.get(parent);
                        }
                    }
                }
                ans=Math.max(ans,currIslandSize);
            }
        }
        return ans;
    }
}