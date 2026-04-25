class Solution {
    boolean[] visited;
    boolean[] path;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> result=new ArrayList<>();
        int n=graph.length;

        visited=new boolean[n];
        path=new boolean[n];

        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
            for(int nei : graph[i]){
                adj.get(i).add(nei);
            }
        }

        for(int i=0;i<n;i++){
            if(!dfs(i,adj)) result.add(i);
        }

        Collections.sort(result);
        return result;
    }

    boolean dfs(int node, List<List<Integer>> adj){
        visited[node]=true;
        path[node]=true;

        for(int n:adj.get(node)){
            if(!visited[n]) {
                if(dfs(n,adj)) return true;
            }
            else if(path[n]) return true;
        }

        path[node]=false;
        return false;
    }
}