class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
    // public int majorityElement(int[] nums) {
    //     Map<Integer,Integer> map=new HashMap<>();

    //     for(int n:nums){
    //         map.put(n,map.getOrDefault(n,0)+1);
    //     }
    //     int result=0;
    //     int max=0;
    //     for(Map.Entry<Integer,Integer> entry:map.entrySet()){
    //         if(entry.getValue()>=max){
    //             max=entry.getValue();
    //             result=entry.getKey();
    //         }
    //     }
    //     return result;
    // }
}