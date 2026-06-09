class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<double[]> pq=new PriorityQueue<>((a,b)->Double.compare(a[0],b[0]));
        int[][] result=new int[k][2];

        for(int[] pt: points){
            int p=pt[0];
            int q=pt[1];

            double dist=p*p+q*q;

            pq.offer(new double[]{dist,p,q});
        }
        int i=0;
        while(k>0){
            double[] curr=pq.poll();

            int p=(int) curr[1];
            int q=(int) curr[2];

            result[i][0]=p;
            result[i][1]=q;
            i++;
            k--;
        }
        return result;
    }
}