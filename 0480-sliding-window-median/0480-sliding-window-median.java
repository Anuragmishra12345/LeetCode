class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        double[] result=new double[n-k+1];
        PriorityQueue<Integer> left=new PriorityQueue<>((a,b)->Integer.compare(b,a));
        PriorityQueue<Integer> right=new PriorityQueue<>();

        Map<Integer, Integer> delayed = new HashMap<>();

        int leftSize=0;
        int rightSize=0;
        int index=0;
        for(int i=0;i<n;i++){
            // insert
            if(left.isEmpty() || nums[i]<=left.peek()){
                left.offer(nums[i]);
                leftSize++;
            }
            else{
                right.offer(nums[i]);
                rightSize++;
            }
            // balance 
            if(leftSize>rightSize+1){
                right.offer(left.poll());
                rightSize++;
                leftSize--;
            }
            else if(rightSize>leftSize){
                left.offer(right.poll());
                leftSize++;
                rightSize--;
            }
            // remove from window
            if(i>=k){
                int out=nums[i-k];
                delayed.put(out,delayed.getOrDefault(out,0)+1);

                if(out <= left.peek()) leftSize--;
                else rightSize--;

                prune(left, delayed);
                prune(right, delayed);
            }

            // REBALANCE AGAIN
            if (leftSize > rightSize + 1) {
                right.offer(left.poll());
                leftSize--;
                rightSize++;
            } else if (leftSize < rightSize) {
                left.offer(right.poll());
                leftSize++;
                rightSize--;
            }

            // median
            if(i>=k-1){
                prune(left, delayed);
                prune(right, delayed);
                if(k%2==0) result[index++]=((long)left.peek() + right.peek()) / 2.0;
                else result[index++]=left.peek();
            }

        }
        return result;
    }

    void prune(PriorityQueue<Integer> heap,Map<Integer,Integer> map){
        while(!heap.isEmpty()){
            int num=heap.peek();
            if(map.containsKey(num)){
                map.put(num, map.get(num) - 1);
                if(map.get(num)==0) map.remove(num);
                heap.poll();
            }
            else break;
        }
    }
}

// class Solution {
//     public double[] medianSlidingWindow(int[] nums, int k) {
//         int n = nums.length;
//         double[] result = new double[n - k + 1];

//         // maxHeap (left), minHeap (right)
//         PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
//         PriorityQueue<Integer> right = new PriorityQueue<>();

//         Map<Integer, Integer> delayed = new HashMap<>();

//         int leftSize = 0, rightSize = 0;
//         int index = 0;

//         for (int i = 0; i < n; i++) {

//             // 1. Insert
//             if (left.isEmpty() || nums[i] <= left.peek()) {
//                 left.offer(nums[i]);
//                 leftSize++;
//             } else {
//                 right.offer(nums[i]);
//                 rightSize++;
//             }

//             // 2. Balance
//             if (leftSize > rightSize + 1) {
//                 right.offer(left.poll());
//                 leftSize--;
//                 rightSize++;
//             } else if (leftSize < rightSize) {
//                 left.offer(right.poll());
//                 leftSize++;
//                 rightSize--;
//             }

//             // 3. Remove outgoing element
//             if (i >= k) {
//                 int out = nums[i - k];
//                 delayed.put(out, delayed.getOrDefault(out, 0) + 1);

//                 // decide which heap it belongs to BEFORE pruning
//                 if (!left.isEmpty() && out <= left.peek()) {
//                     leftSize--;
//                 } else {
//                     rightSize--;
//                 }

//                 // prune invalid elements
//                 prune(left, delayed);
//                 prune(right, delayed);
//             }

//             // 4. Rebalance again (important after removal)
//             if (leftSize > rightSize + 1) {
//                 right.offer(left.poll());
//                 leftSize--;
//                 rightSize++;
//             } else if (leftSize < rightSize) {
//                 left.offer(right.poll());
//                 leftSize++;
//                 rightSize--;
//             }

//             // 5. Get median
//             if (i >= k - 1) {
//                 prune(left, delayed);
//                 prune(right, delayed);

//                 if (k % 2 == 0) {
//                     result[index++] = ((long) left.peek() + right.peek()) / 2.0;
//                 } else {
//                     result[index++] = left.peek();
//                 }
//             }
//         }

//         return result;
//     }

//     private void prune(PriorityQueue<Integer> heap, Map<Integer, Integer> delayed) {
//         while (!heap.isEmpty()) {
//             int num = heap.peek();
//             if (delayed.containsKey(num)) {
//                 delayed.put(num, delayed.get(num) - 1);
//                 if (delayed.get(num) == 0) {
//                     delayed.remove(num);
//                 }
//                 heap.poll();
//             } else {
//                 break;
//             }
//         }
//     }
// }