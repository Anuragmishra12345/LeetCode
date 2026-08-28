class Solution {
    public int longestBalanced(String s) {
        char[] arr = s.toCharArray();

        int n = arr.length, bal = n + 1, ans = 0; 
        int[] nextIndex = new int[n], balIndex = new int[2 * n + 3];
        Arrays.fill(balIndex, n + 1);

        for(int i = n - 1; i >= 0; i--) {
            bal += (('0' ^ arr[i]) << 1) - 1;
            nextIndex[i] = balIndex[bal];
            balIndex[bal] = i;
        }
        if(bal == n + 1) return n;

        int zeros = (2 * n + 1 - bal) / 2, maxLength = 2 * Math.min(zeros, n - zeros);
        for(int i = 1; i <= n && ans < maxLength; i++) {
            bal += (('1' ^ arr[i - 1]) << 1) - 1;

            if(i - balIndex[bal] > ans) ans = i - balIndex[bal];

            if(balIndex[bal - 2] < i - maxLength) balIndex[bal - 2] = nextIndex[balIndex[bal - 2]];
            if(i - balIndex[bal - 2] > ans) ans = i - balIndex[bal - 2];

            if(balIndex[bal + 2] < i - maxLength) balIndex[bal + 2] = nextIndex[balIndex[bal + 2]];
            if(i - balIndex[bal + 2] > ans) ans = i - balIndex[bal + 2];
        }
        return ans;
    }
}