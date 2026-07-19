class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> result=new ArrayList<>();
        int index=-1;
        Arrays.sort(intervals,(a,b)->(a[0]-b[0]));
        for(int[] i:intervals){
            if(result.isEmpty()) {
                result.add(new int[]{i[0],i[1]});
                index++;
            }
            else{
                if(result.get(index)[1]>=i[0]) result.get(index)[1]=Math.max(i[1],result.get(index)[1]);
                else {
                    result.add(new int[]{i[0],i[1]});
                    index++;
                }
            }
        }
        int[][] ans=new int[index+1][2];
        index=0;
        for(int[] i:result){
            ans[index][0]=i[0];
            ans[index++][1]=i[1];
        }
        return ans;
    }
}