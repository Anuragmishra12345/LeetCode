class Solution {
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        long result = 0;
        int left = 0;
        long pair = 0;

        for(int right=0;right<nums.length;right++){
            int key=nums[right];

            pair+=map.getOrDefault(key,0);
            map.put(key,map.getOrDefault(key,0)+1);

            while(pair>=k){
                result+=nums.length-right;

                int leftKey=nums[left];
                map.put(leftKey,map.get(leftKey)-1);
                pair-=map.get(leftKey);
                left++;
            }
        }

        return result;
    }
}