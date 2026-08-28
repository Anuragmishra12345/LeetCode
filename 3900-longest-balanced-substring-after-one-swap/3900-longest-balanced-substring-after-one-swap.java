class Solution {
    public int longestBalanced(String s) {
        int n = s.length();

        // prefix[i] = (# of 1s) - (# of 0s) in s[0 ... i-1]
        int[] prefix = new int[n + 1];

        // Number of 0s / 1s in prefix
        int[] zeros = new int[n + 1];
        int[] ones = new int[n + 1];

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                prefix[i + 1] = prefix[i] + 1;
                ones[i + 1] = ones[i] + 1;
                zeros[i + 1] = zeros[i];
            } else {
                prefix[i + 1] = prefix[i] - 1;
                zeros[i + 1] = zeros[i] + 1;
                ones[i + 1] = ones[i];
            }
        }

        /*
         * first[b] = earliest position where prefix balance b occurs.
         *
         * firstZero[b] = earliest position where balance b occurs
         *                 AND there is already a 0 before that position.
         *
         * firstOne[b] = earliest position where balance b occurs
         *                AND there is already a 1 before that position.
         */
        Map<Integer, Integer> first = new HashMap<>();
        Map<Integer, Integer> firstZero = new HashMap<>();
        Map<Integer, Integer> firstOne = new HashMap<>();

        first.put(0, 0);

        int answer = 0;

        for (int r = 1; r <= n; r++) {

            int balance = prefix[r];

            // ------------------------------------------------
            // Case 1:
            // Substring is already balanced.
            // balance[r] - balance[l] = 0
            // ------------------------------------------------
            if (first.containsKey(balance)) {
                int l = first.get(balance);
                answer = Math.max(answer, r - l);
            }

            // ------------------------------------------------
            // Case 2:
            // Substring has two MORE 1s than 0s.
            //
            // Difference = +2
            //
            // Need to swap:
            //     inside 1 <-> outside 0
            //
            // Therefore we need a 0 outside the substring.
            // ------------------------------------------------

            int required = balance - 2;

            if (first.containsKey(required)) {

                int l = first.get(required);

                // Is there a 0 after the substring?
                boolean zeroAfter = zeros[n] - zeros[r] > 0;

                if (zeroAfter) {
                    answer = Math.max(answer, r - l);
                }
                else if (firstZero.containsKey(required)) {
                    // No zero after it, so we need a zero before l.
                    l = firstZero.get(required);
                    answer = Math.max(answer, r - l);
                }
            }

            // ------------------------------------------------
            // Case 3:
            // Substring has two MORE 0s than 1s.
            //
            // Difference = -2
            //
            // Need to swap:
            //     inside 0 <-> outside 1
            //
            // Therefore we need a 1 outside the substring.
            // ------------------------------------------------

            required = balance + 2;

            if (first.containsKey(required)) {

                int l = first.get(required);

                // Is there a 1 after the substring?
                boolean oneAfter = ones[n] - ones[r] > 0;

                if (oneAfter) {
                    answer = Math.max(answer, r - l);
                }
                else if (firstOne.containsKey(required)) {
                    // No 1 after it, so we need a 1 before l.
                    l = firstOne.get(required);
                    answer = Math.max(answer, r - l);
                }
            }

            // ------------------------------------------------
            // Store this balance.
            // ------------------------------------------------

            if (!first.containsKey(balance)) {
                first.put(balance, r);
            }

            // At position r there is a 0 before/at this prefix
            if (zeros[r] > 0 && !firstZero.containsKey(balance)) {
                firstZero.put(balance, r);
            }

            // At position r there is a 1 before/at this prefix
            if (ones[r] > 0 && !firstOne.containsKey(balance)) {
                firstOne.put(balance, r);
            }
        }

        return answer;
    }
}