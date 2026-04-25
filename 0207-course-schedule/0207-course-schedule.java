class Solution {
    boolean[] visited;
    boolean[] path;
    public boolean canFinish(int numCourses, int[][] pr) {
        int n=pr.length;
        visited=new boolean[numCourses];
        path=new boolean[numCourses];

        List<List<Integer>> adj=new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] e : pr){
            int a = e[0];
            int b = e[1];
            adj.get(b).add(a);
        }
        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                if(dfs(i,adj)) return false;
            }
        }
        return true;
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