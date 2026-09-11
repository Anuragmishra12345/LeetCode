class Solution {
    public int totalNumbers(int[] digits) {
        boolean[] visited = new boolean[digits.length];
        return func(digits, visited, 0);
    }

    int func(int[] nums, boolean[] visited, int count) {

        if (count == 3)
            return 1;

        int ans = 0;
        boolean[] used = new boolean[10];

        for (int i = 0; i < nums.length; i++) {

            if (visited[i])
                continue;

            if (used[nums[i]])
                continue;

            if (count == 0 && nums[i] == 0)
                continue;

            if (count == 2 && nums[i] % 2 != 0)
                continue;

            used[nums[i]] = true;
            visited[i] = true;

            ans += func(nums, visited, count + 1);

            visited[i] = false;
        }

        return ans;
    }
}