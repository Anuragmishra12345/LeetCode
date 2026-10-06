class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        List<List<Integer>> adjList=new ArrayList<>();
        int maxNode=colors.length()-1;
        

        for(int i=0;i<=maxNode;i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] e:edges){
            adjList.get(e[0]).add(e[1]);
        }

        boolean[] visited=new boolean[maxNode+1];
        boolean[] path=new boolean[maxNode+1];

        for(int i=0;i<=maxNode;i++){
            if(!visited[i]){
                if(isCycle(adjList,i,visited,path)) return -1;
            }
        }
        int answer = 0;

        int[][] dp=new int[maxNode+1][26];
        for(int[] d:dp) Arrays.fill(d,-1);

        for(int i=0;i<=maxNode;i++){
            for(int color=0;color<26;color++){
                answer=Math.max(answer,dfs(adjList,i,colors,color,dp));
            }
        }
        return answer;
    }

    boolean isCycle(List<List<Integer>> adjList, int node, boolean[] visited, boolean[] path){
        visited[node]=true;
        path[node]=true;

        for(int n:adjList.get(node)){
            if(!visited[n]){
                if(isCycle(adjList,n,visited,path)) return true;
            }
            else if(path[n]) return true;
        }

        path[node]=false;
        return false;
    }

    int dfs(List<List<Integer>> adjList, int node,String colors,int color,int[][] dp) {
        if(dp[node][color]!=-1) return dp[node][color];

        int count=0;
        if(colors.charAt(node)-'a'==color) count=1;

        int max=0;

        for(int n:adjList.get(node)){
            int curr=dfs(adjList,n,colors,color,dp);
            max=Math.max(max,curr);
        }
        return dp[node][color]=max+count;
    }
}