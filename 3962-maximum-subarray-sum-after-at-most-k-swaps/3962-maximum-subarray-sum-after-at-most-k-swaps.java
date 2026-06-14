import java.util.*;

class Solution {

    long INF = -(long)1e15;

    public long maxSum(int[] nums, int k) {

        int n = nums.length;
        long ans = INF;

        int negs = 0;

        for (int x : nums) {
            if (x < 0) negs++;
        }

        if (negs <= k && negs < n) {
            ans = 0;

            for (int x : nums) {
                if (x >= 0) ans += x;
            }

            return ans;
        }

        if (negs == n) {
            int mx = Integer.MIN_VALUE;

            for (int x : nums) {
                mx = Math.max(mx, x);
            }

            return mx;
        }

        if (k == 0) {

            long sum = 0;

            for (int x : nums) {
                sum += x;
                ans = Math.max(ans, sum);
                sum = Math.max(sum, 0);
            }

            return ans;
        }

        int[][] subarraySum = new int[n][n];
        int[][] arr1 = new int[n][n];
        int[][] arr2 = new int[n][n];

        // subarray sums
        for (int i = 0; i < n; i++) {

            int sum = 0;

            for (int j = i; j < n; j++) {
                sum += nums[j];
                subarraySum[i][j] = sum;
            }
        }

        // arr1
        for (int i = 0; i < n; i++) {

            PriorityQueue<Integer> pq =
                    new PriorityQueue<>(Collections.reverseOrder());

            int sum = 0;

            for (int j = i; j < n; j++) {

                if (nums[j] < 0) {

                    if (pq.size() < k) {
                        pq.offer(nums[j]);
                        sum += nums[j];
                    } else {

                        if (!pq.isEmpty() && pq.peek() > nums[j]) {

                            sum -= pq.poll();

                            sum += nums[j];
                            pq.offer(nums[j]);
                        }
                    }
                }

                arr1[i][j] = sum;
            }
        }

        // arr2
        for (int i = 0; i < n; i++) {

            PriorityQueue<Integer> pq = new PriorityQueue<>();

            int sum = 0;

            for (int j = 0; j < i; j++) {

                if (nums[j] > 0) {

                    if (pq.size() < k) {
                        pq.offer(nums[j]);
                        sum += nums[j];
                    } else {

                        if (!pq.isEmpty() && pq.peek() < nums[j]) {

                            sum -= pq.poll();

                            pq.offer(nums[j]);
                            sum += nums[j];
                        }
                    }
                }
            }

            arr2[i][n - 1] = sum;

            for (int j = n - 1; j >= i; j--) {

                if (nums[j] > 0) {

                    if (pq.size() < k) {

                        pq.offer(nums[j]);
                        sum += nums[j];

                    } else {

                        if (!pq.isEmpty() && pq.peek() < nums[j]) {

                            sum -= pq.poll();

                            pq.offer(nums[j]);
                            sum += nums[j];
                        }
                    }
                }

                if (j - 1 >= i) {
                    arr2[i][j - 1] = sum;
                }
            }
        }

        for (int i = 0; i < n; i++) {

            for (int j = i; j < n; j++) {

                long curr =
                        (long) subarraySum[i][j]
                                - arr1[i][j]
                                + arr2[i][j];

                ans = Math.max(ans, curr);
            }
        }

        return ans;
    }
}