class Solution {
    class DisjointSet{
        int[] parent;
        int[] size;

        DisjointSet(int n){
            parent=new int[n+1];
            size=new int[n+1];

            for(int i=0;i<=n;i++){
                parent[i]=i;
                size[i]=1;
            }
        }

        int findUPar(int node){
            if(parent[node]==node) return node;

            int par=findUPar(parent[node]);
            parent[node]=par;
            return par;
        }

        void unionBySize(int u, int v){
            int up=findUPar(u);
            int vp=findUPar(v);

            if(up==vp) return;

            if(size[up]<size[vp]){
                parent[up]=vp;
                size[vp]+=size[up];
            }
            else {
                parent[vp]=up;
                size[up]+=size[vp];
            }
        }
    }
    public int removeStones(int[][] stones) {
        int maxRow=0;
        int maxCol=0;

        for(int[] s:stones){
            maxRow=Math.max(maxRow,s[0]);
            maxCol=Math.max(maxCol,s[1]);
        }

        DisjointSet ds=new DisjointSet(maxRow+maxCol+1);
        Map<Integer,Integer> map=new HashMap<>();

        for(int[] s:stones){
            int row=s[0];
            int col=maxRow+1+s[1];

            ds.unionBySize(row,col);

            map.put(row,1);
            map.put(col,1);
        }

        int count=0;

        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(ds.findUPar(entry.getKey())==entry.getKey()) count++;
        }

        return stones.length-count;
    }
}