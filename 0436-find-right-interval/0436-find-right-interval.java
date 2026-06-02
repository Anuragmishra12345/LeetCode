class Solution {
    // O(n2)
    // public int[] findRightInterval(int[][] intervals) {
    //     int n=intervals.length;
    //     int[] result=new int[n];
    //     for(int i=0;i<n;i++){
    //         result[i]=-1;
    //         int start=Integer.MAX_VALUE;
    //         for(int j=0;j<n;j++){
    //             if(start>intervals[j][0] && intervals[j][0]>=intervals[i][1]){
    //                 result[i]=j;
    //                 start=intervals[j][0];
    //             }
    //         }
    //     }
    //     return result;
    // }


    public int[] findRightInterval(int[][] intervals) {
        int n=intervals.length;
        int[] result=new int[n];

        int[][] start=new int[n][2];
        for(int i=0;i<n;i++){
            start[i][0]=intervals[i][0];
            start[i][1]=i;
        }

        Arrays.sort(start,(a,b)->Integer.compare(a[0],b[0]));

        for(int i=0;i<n;i++){
            int target=intervals[i][1];

            int index=lowerBound(start,target);

            result[i]=(index==n)?-1:start[index][1];
        }
        return result;
    }

    public int lowerBound(int[][] start,int target){
        int left=0;
        int right =start.length;

        while(left<right){
            int mid=left+(right-left)/2;

            if(target>start[mid][0]) left=mid+1;
            else right=mid;
        }
        return left;
    }
}