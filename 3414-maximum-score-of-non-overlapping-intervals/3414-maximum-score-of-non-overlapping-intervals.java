class Solution {

    static class State {
        long score;
        int[] indices;

        State(long score, int[] indices) {
            this.score = score;
            this.indices = indices;
        }
    }

    int n;
    int[] next;
    int[][] intervals;
    State[][] dp;

    public int[] maximumWeight(List<List<Integer>> input) {

        n = input.size();
        intervals = new int[n][4];

        // [start, end, weight, originalIndex]
        for (int i = 0; i < n; i++) {
            intervals[i][0] = input.get(i).get(0);
            intervals[i][1] = input.get(i).get(1);
            intervals[i][2] = input.get(i).get(2);
            intervals[i][3] = i;
        }

        // Sort by starting point
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0])
                return Integer.compare(a[0], b[0]);

            return Integer.compare(a[1], b[1]);
        });

        // Find next non-overlapping interval
        next = new int[n];

        for (int i = 0; i < n; i++) {
            next[i] = findNext(intervals[i][1]);
        }

        dp = new State[n + 1][5];

        State answer = solve(0, 4);

        return answer.indices;
    }

    State solve(int i, int k) {

        if (i == n || k == 0) {
            return new State(0, new int[0]);
        }

        if (dp[i][k] != null) {
            return dp[i][k];
        }

        // Don't take current interval
        State notTake = solve(i + 1, k);

        // Take current interval
        State nextState = solve(next[i], k - 1);

        int[] takeIndices =
                new int[nextState.indices.length + 1];

        takeIndices[0] = intervals[i][3];

        for (int j = 0; j < nextState.indices.length; j++) {
            takeIndices[j + 1] = nextState.indices[j];
        }

        Arrays.sort(takeIndices);

        State take = new State(
                (long) intervals[i][2] + nextState.score,
                takeIndices
        );

        dp[i][k] = better(take, notTake);

        return dp[i][k];
    }

    State better(State a, State b) {

        if (a.score > b.score)
            return a;

        if (b.score > a.score)
            return b;

        // Same score → lexicographically smaller indices
        if (lexicographicallySmaller(a.indices, b.indices))
            return a;

        return b;
    }

    boolean lexicographicallySmaller(int[] a, int[] b) {

        int len = Math.min(a.length, b.length);

        for (int i = 0; i < len; i++) {

            if (a[i] < b[i])
                return true;

            if (a[i] > b[i])
                return false;
        }

        // If one is a prefix of the other,
        // the shorter one is lexicographically smaller.
        return a.length < b.length;
    }

    int findNext(int end) {

        int low = 0;
        int high = n;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (intervals[mid][0] > end)
                high = mid;
            else
                low = mid + 1;
        }

        return low;
    }
}