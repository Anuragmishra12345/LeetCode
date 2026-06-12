class Solution {
    public int maxArea(int[] height) {
        int maxWater=0;
        int left=0;
        int right=height.length-1;
        while(left<right){
            int base=right-left;
            int h=Math.min(height[left],height[right]);
            maxWater=Math.max(maxWater,base*h);

            if(height[left]>height[right]) right--;
            else left++;
        }
        return maxWater;
    }
}