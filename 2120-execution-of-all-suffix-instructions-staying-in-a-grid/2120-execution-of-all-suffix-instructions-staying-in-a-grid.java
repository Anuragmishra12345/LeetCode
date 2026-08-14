class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {

        int m = s.length();
        int[] ans = new int[m];

        for (int start = 0; start < m; start++) {

            int r = startPos[0];
            int c = startPos[1];

            int count = 0;

            for (int i = start; i < m; i++) {

                char ch = s.charAt(i);

                if (ch == 'R') c++;
                else if (ch == 'L') c--;
                else if (ch == 'U') r--;
                else r++;

                if (r < 0 || r >= n || c < 0 || c >= n)
                    break;

                count++;
            }

            ans[start] = count;
        }

        return ans;
    }
}