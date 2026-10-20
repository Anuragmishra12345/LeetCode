class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int answer = 0;

        for (int k = 1; k <= n; k++) {
            if (n % k != 0) {
                continue;
            }

            boolean valid = true;
            int previousMax = Integer.MIN_VALUE;

            for (int start = 0; start < n; start += k) {
                int end = start + k - 1;

                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;
                int drops = 0;

                // Check the block's internal order and find its range.
                for (int i = start; i <= end; i++) {
                    min = Math.min(min, nums[i]);
                    max = Math.max(max, nums[i]);

                    // Count ordinary adjacent descents inside this block.
                    if (i > start && nums[i - 1] > nums[i]) {
                        drops++;
                    }
                }

                // Include the circular comparison: last element -> first.
                if (nums[end] > nums[start]) {
                    drops++;
                }

                // This block cannot be rotated into sorted order.
                if (drops > 1) {
                    valid = false;
                    break;
                }

                // The sorted blocks must also be globally ordered.
                if (previousMax > min) {
                    valid = false;
                    break;
                }

                previousMax = max;
            }

            if (valid) {
                answer += k;
            }
        }

        return answer;
    }
}