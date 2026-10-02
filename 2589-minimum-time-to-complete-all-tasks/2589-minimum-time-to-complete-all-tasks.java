class Solution {
    public int findMinimumTime(int[][] tasks) {
        Arrays.sort(tasks,(a,b)->Integer.compare(a[1],b[1]));

        boolean[] used=new boolean[2001];

        for(int[] t:tasks){
            int required=t[2];
            int start=t[0];
            int end=t[1];
            for(int s=start;s<=end;s++){
                if(used[s]) required--;
                if(required==0) break;
            }

            while(required>0){
                if(!used[end]) {
                    used[end]=true;;
                    required--;
                }
                end--;
            }
        }
        int count=0;
        for(boolean u:used){
            if(u) count++;
        }
        return count;
    }
}