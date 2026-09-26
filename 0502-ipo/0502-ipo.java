class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n=profits.length;

        int[][] merge=new int[n][2];

        for(int i=0;i<n;i++){
            merge[i][0]=capital[i];
            merge[i][1]=profits[i];
        }
        Arrays.sort(merge,(a,b)->Integer.compare(a[0],b[0]));

        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->Integer.compare(b,a));

        int i=0;

        while(k>0){
            while(i<n && w>=merge[i][0]){
                pq.offer(merge[i][1]);
                i++;
            }

            if(pq.isEmpty()) break;

            w+=pq.poll();
            k--;
        }
        return w;
    }
}