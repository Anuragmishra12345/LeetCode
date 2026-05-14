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
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }

        for(int i=0;i<nums.length;i++){
            int needed=target-nums[i];
            if(map.containsKey(needed) && map.get(needed)!=i){
                return new int[] {i,map.get(needed)};
            }
        }

        return new int[] {-1,-1};
    }
    
}