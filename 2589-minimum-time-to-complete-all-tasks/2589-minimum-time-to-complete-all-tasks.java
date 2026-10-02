class Solution {
    public int findMinimumTime(int[][] tasks) {
        Arrays.sort(tasks,(a,b)->Integer.compare(a[1],b[1]));

        Set<Integer> set=new HashSet<>();

        for(int[] t:tasks){
            int required=t[2];
            int start=t[0];
            int end=t[1];
            for(int s=start;s<=end;s++){
                if(set.contains(s)) required--;
                if(required==0) break;
            }

            while(required>0){
                if(!set.contains(end)) {
                    set.add(end);
                    required--;
                }
                end--;
            }
        }
        return set.size();
    }
}