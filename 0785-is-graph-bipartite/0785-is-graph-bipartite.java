class Solution {
    // BFS
    // public boolean isBipartite(int[][] graph) {
    //     int n=graph.length;
    //     int[] color=new int[n];
    //     for(int i=0;i<n;i++){
    //         if(color[i]!=0) continue;
            
    //         Queue<Integer> q=new LinkedList<>();
    //         q.add(i);
    //         color[i]=1;
    //         while(!q.isEmpty()){
    //             int node=q.poll();
    //             for(int neigh: graph[node]){
    //                 if(color[neigh]==0){
    //                     color[neigh]=-color[node];
    //                     q.add(neigh);
    //                 }else if(color[neigh]==color[node]) return false;
    //             }
    //         }
    //     }
    //     return true;
    // }

    // DFS
    public boolean isBipartite(int[][] graph){
        int[] color=new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(color[i]==0 && !dfs(graph,color,i,1)){
                return false;
            }
        }
        return true;
    }
    boolean dfs(int[][] graph, int[] color, int node, int c){
        color[node]=c;
        for(int neigh:graph[node]){
            if(color[neigh]==0){
                if(!dfs(graph,color,neigh,-c)) return false;
            }
            else if(color[neigh]==color[node]) return false;
        }
        return true;
    }
}