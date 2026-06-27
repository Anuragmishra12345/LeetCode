class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new TreeSet<>((a,b)->Integer.compare(a,b));
        int max=0;
        for(int num:nums){
            set.add(num);
        }
        int currLen=0;
        Integer prev=null;
        for(int curr:set){
            if(prev==null || prev==curr-1){
                prev=curr;
                currLen++;
            }
            else {
                currLen=1;
                prev=curr;
            }
            max=Math.max(max,currLen);
        }
        return max;
    }
}