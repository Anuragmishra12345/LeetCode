class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(b[0],a[0]));
        int[][] result=new int[k][2];

        for(int[] pt: points){
            int p=pt[0];
            int q=pt[1];

            int dist=p*p+q*q;

            pq.offer(new int[]{dist,p,q});

            if(pq.size()>k) pq.poll();
        }
        
        for(int i=0;i<k;i++){
            int[] curr=pq.poll();

            int p=curr[1];
            int q=curr[2];

            result[i][0]=p;
            result[i][1]=q;
            
        }
        return result;
    }
}