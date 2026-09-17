class Solution {
    boolean[] visited;
    boolean[] path;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        visited=new boolean[n];
        path=new boolean[n];

        List<List<Integer>> adjList=new ArrayList<>();

        for(int i=0;i<n;i++) adjList.add(new ArrayList<>());

        for(int i=0;i<n;i++){
            for(int j=0;j<graph[i].length;j++){
                adjList.get(i).add(graph[i][j]);
            }
        }
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!dfs(adjList,i)) result.add(i);
        }
        return result;
    }
    boolean dfs(List<List<Integer>> adjList, int node){
        visited[node]=true;
        path[node]=true;

        for(int adjNode:adjList.get(node)){
            if(!visited[adjNode]) {
                if(dfs(adjList,adjNode)) return true;
            }
            else if(path[adjNode]) return true;
        }

        path[node]=false;
        return false;
    }
}