class Solution {
    public int[] arrayRankTransform(int[] arr) {
        if(arr.length==0 || arr==null) return arr;  
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        for(int i=0;i<arr.length;i++){
            pq.offer(new int[]{arr[i],i});
        }
        int rank=1;
        int last=pq.peek()[0];
        while(!pq.isEmpty()){
            int element=pq.peek()[0];
            int index=pq.poll()[1];
            if(last==element){
                arr[index]=rank;
            }
            else {
                rank++;
                last=element;
                arr[index]=rank;
            }
        }
        return arr;
    }
}