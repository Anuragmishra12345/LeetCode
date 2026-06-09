class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<double[]> pq=new PriorityQueue<>((a,b)->Double.compare(b[0],a[0]));
        int[][] result=new int[k][2];

        for(int[] pt: points){
            int p=pt[0];
            int q=pt[1];

            double dist=p*p+q*q;

            pq.offer(new double[]{dist,p,q});

            if(pq.size()>k) pq.poll();
        }
        
        for(int i=0;i<k;i++){
            double[] curr=pq.poll();

            int p=(int) curr[1];
            int q=(int) curr[2];

            result[i][0]=p;
            result[i][1]=q;
            
        }
        return result;
    }
}