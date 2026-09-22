class Solution {
    public int trap(int[] height) {
        Deque<Integer> stack=new ArrayDeque<>();

        int trap=0;

        for(int i=0;i<height.length;i++){
            while(!stack.isEmpty() && height[stack.peek()]<height[i]){
                int mid=stack.pop();
                if(!stack.isEmpty()){
                    int left=stack.peek();

                    int h=Math.min(height[left],height[i])-height[mid];
                    int w=i-left-1;

                    trap+=h*w;
                }
            }

            stack.push(i);
        }
        return trap;
    }
}