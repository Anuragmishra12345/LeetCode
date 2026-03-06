class Solution {
    public int findCircleNum(int[][] isConnected) {
        int v=isConnected.length;
        ArrayList<ArrayList<Integer>> adjList=new ArrayList<>();
        for(int i=0;i<v;i++){
            adjList.add(new ArrayList<Integer>());
        }
        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++){
                if(isConnected[i][j]==1 && i!=j){
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        int[] visited=new int[v];
        int count=0;
        for(int i=0;i<v;i++){
            if(visited[i]==0){
                count++;
                dfs(i,adjList,visited);
            }
        }
        return count;
    }


    private void dfs(int node,ArrayList<ArrayList<Integer>> adjList, int[] visited){
        visited[node]=1;
        for(int it:adjList.get(node)){
            if(visited[it]==0){
                dfs(it,adjList,visited);
            }
        }
    }
}