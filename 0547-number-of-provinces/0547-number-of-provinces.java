class Solution {
    boolean[] visited;
    int n;
    public int findCircleNum(int[][] isConnected) {
        n=isConnected.length;
        visited=new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                count++;
                dfs(i,isConnected);
            }
        }
        return count;
    }
    void dfs(int city,int[][] num){
        visited[city]=true;
        for(int i=0;i<n;i++){
            if(city==i) continue;
            if(!visited[i] && num[city][i]==1) dfs(i,num);
        }
    }
}