class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->Integer.compare(b,a));

        for(int[] row:matrix){
            for(int n:row){
                pq.offer(n);
                if(pq.size()>k){
                    pq.poll();
                }
            }
        }
        return pq.poll();
    }
}