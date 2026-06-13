class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int[] result=new int[n];
        Arrays.fill(result,-1);
        Deque<Integer> stack=new ArrayDeque<>();

        for(int i =0;i<2*n;i++){
            int index=i%n;
            while(!stack.isEmpty() && nums[index]>nums[stack.peek()]){
                result[stack.pop()]=nums[index];
            }
            if(i<n) stack.push(index);
        }
        return result;
    }
}