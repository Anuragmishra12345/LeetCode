class Solution {
    boolean[] visited;
    boolean[] path;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        visited=new boolean[graph.length];
        path=new boolean[graph.length];

        List<Integer> result=new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            if(!dfs(graph,i)) result.add(i);
        }
        Collections.sort(result);
        return result;
    }
    boolean dfs(int[][] graph, int node){
        visited[node]=true;
        path[node]=true;

        for(int g:graph[node]){
            if(!visited[g]) {
                if(dfs(graph,g)) return true;
            }
            else if(path[g]) return true;
        }
        path[node]=false;
        return false;
    }
}