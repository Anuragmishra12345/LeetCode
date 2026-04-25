class Solution {
    boolean[] visited;
    boolean[] path;
    public int[] findOrder(int numCourses, int[][] pr) {
        visited=new boolean[numCourses];
        path = new boolean[numCourses];
        Stack<Integer> stack=new Stack<>();

        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] it:pr){
            adj.get(it[1]).add(it[0]);
        }

        for(int i=0;i<numCourses;i++){
            if(!visited[i]) {
                if(dfs(i, adj, stack)) return new int[0]; 
            }
        }

        int[] result=new int[numCourses];
        int i=0;
        while(!stack.isEmpty()){
            result[i++]=stack.pop();
        }
        return result;
    }
    public boolean dfs(int node,List<List<Integer>> adj,Stack<Integer> stack){
        visited[node]=true;
        path[node]=true;
        for(int n:adj.get(node)){
            if(!visited[n]){
                if(dfs(n, adj, stack)) return true;
            }
            else if(path[n]){
                return true; 
            }
        }
        stack.push(node);
        path[node]=false;
        return false;
    }
}    