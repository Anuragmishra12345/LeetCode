class Solution {
    // public int kthSmallest(int[][] matrix, int k) {
    //     PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->Integer.compare(b,a));

    //     for(int[] row:matrix){
    //         for(int n:row){
    //             pq.offer(n);
    //             if(pq.size()>k){
    //                 pq.poll();
    //             }
    //         }
    //     }
    //     return pq.poll();
    // }

    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length;
        int low=matrix[0][0];
        int high=matrix[n-1][n-1];

        while(low<high){
            int mid=low+(high-low)/2;
            if(countLeft(matrix,mid)>=k){
                high=mid;
            }
            else low=mid+1;
        }
        return low;
    }
    private int countLeft(int[][] matrix, int target){
        int n=matrix.length;
        int count=0;
        int r=0;
        int c=n-1;

        while(r<n && c>=0){
            if(matrix[r][c]<=target){
                count+=c+1;
                r++;
            }
            else c--;
        }
        return count;
    }
}