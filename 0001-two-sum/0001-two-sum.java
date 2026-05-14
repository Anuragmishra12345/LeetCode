class Solution {
    public int[] twoSum(int[] nums, int target) {

        // brute force

        // for(int i=0;i<nums.length;i++){
        //     int j=i+1;
        //     while(j<nums.length){
        //         if(nums[i]+nums[j]==target){
        //             return new int[] {i,j};
        //         }
        //         j++;
        //     }
        // }
        // return new int[] {-1,-1};

        Map<Integer,Integer> map=new HashMap<>();
        int len=nums.length;
        for(int i=0;i<len;i++){
            int needed=target-nums[i];
            if(map.containsKey(needed) && map.get(needed)!=i){
                return new int[] {i,map.get(needed)};
            }
            map.put(nums[i],i);
        }
        return new int[] {-1,-1};
    }
    
}