class Solution {
    public int maxArea(int[] height) {
        int start=0;
        int end=height.length-1;
        int maxArea=0;
        while(start<end){
            int h=Math.min(height[start],height[end]);
            int w=end-start;
            int area=h*w;
            maxArea=Math.max(maxArea,area);
            if(height[start]< height[end]){
               start++;
            }else{
                end--;
            }
           
        }
        return maxArea;
    }
}