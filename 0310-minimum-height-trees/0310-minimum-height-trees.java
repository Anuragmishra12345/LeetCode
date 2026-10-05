class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result=new ArrayList<>();
        if(n==1) {
            result.add(0);
            return result;
        }
        List<List<Integer>> adjList=new ArrayList<>();

        for(int i=0;i<n;i++) adjList.add(new ArrayList<>());
        int[] degree=new int[n];

        for(int[] e:edges){
            adjList.get(e[0]).add(e[1]);
            adjList.get(e[1]).add(e[0]);
            degree[e[0]]++;
            degree[e[1]]++;
        }

        Queue<Integer> q=new LinkedList<>();

        for(int i = 0; i < n; i++) {
            if(degree[i] == 1) {
                q.offer(i);
            }
        }


        int remaining=n;
        while(remaining>2){
            int size=q.size();
            remaining-=size;

            for(int i=0;i<size;i++){
                int leaf=q.poll();

                for(int nei:adjList.get(leaf)){
                    degree[nei]--;

                    if(degree[nei]==1) q.offer(nei);
                }
            }
        }
        while(!q.isEmpty()){
            result.add(q.poll());
        }
        return result;
    }
}