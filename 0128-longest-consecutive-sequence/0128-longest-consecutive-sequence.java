class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int len=0;
        for(int num:set){
            if(!set.contains(num-1)){
                int currLen=0;
                int currNum=num;
                while(set.contains(currNum)){
                    currLen++;
                    currNum++;
                }
                len=Math.max(len,currLen);
            }
        }
        return len;
    }
}