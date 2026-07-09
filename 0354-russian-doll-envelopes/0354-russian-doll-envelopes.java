class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0])
                return Integer.compare(b[1], a[1]);
            return Integer.compare(a[0], b[0]);     
        });

        ArrayList<Integer> lis = new ArrayList<>();

        for (int[] env : envelopes) {

            int h = env[1];

            int idx = lowerBound(lis, h);

            if (idx == lis.size())
                lis.add(h);
            else
                lis.set(idx, h);
        }

        return lis.size();
    }

    int lowerBound(ArrayList<Integer> list, int target) {

        int low = 0;
        int high = list.size();

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (list.get(mid) >= target)
                high = mid;
            else
                low = mid + 1;
        }

        return low;
    }
}