class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int[] answer=new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for(int i=1;i<n;i++){
            while(!stack.isEmpty() && temperatures[stack.peek()]<temperatures[i]){
                answer[stack.peek()]=i-stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return answer;
    }
}