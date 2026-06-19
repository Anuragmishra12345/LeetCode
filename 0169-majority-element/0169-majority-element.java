class Solution {
    // public int majorityElement(int[] nums) {
    //     Arrays.sort(nums);
    //     int count=1;
    //     int maxCount=1;
    //     int result=nums[0];
    //     for(int i=1;i<nums.length;i++){
    //         if(nums[i]==nums[i-1]) count++;
    //         else count=1;
    //         if(count>maxCount){
    //             maxCount=count;
    //             result=nums[i];
    //         }
    //     }
    //     return result;
    // }
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();

        for(int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        int result=0;
        int max=0;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()>=max){
                max=entry.getValue();
                result=entry.getKey();
            }
        }
        return result;
    }
}