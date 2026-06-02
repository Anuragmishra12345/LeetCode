class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n=intervals.length;
        int[] result=new int[n];
        for(int i=0;i<n;i++){
            result[i]=-1;
            int start=Integer.MAX_VALUE;
            for(int j=0;j<n;j++){
                if(start>intervals[j][0] && intervals[j][0]>=intervals[i][1]){
                    result[i]=j;
                    start=intervals[j][0];
                }
            }
        }
        return result;
    }
}