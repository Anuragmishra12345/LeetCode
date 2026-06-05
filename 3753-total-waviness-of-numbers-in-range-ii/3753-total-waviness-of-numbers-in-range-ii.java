class Solution {
    class Pair{
        long count;
        long wave;

        Pair(long count, long wave){
            this.count=count;
            this.wave=wave;
        }
    }
    private String num;
    private Pair[][][][][] dp;
    public long totalWaviness(long num1, long num2) {
        return solve(num2)-solve(num1-1);
    }

    private long solve(long x){
        if(x<0) return 0;
        num=String.valueOf(x);
        dp=new Pair[num.length()][11][11][2][2];

        return dfs(0,10,10,0,1).wave;
    }

    private Pair dfs(int index, int p1, int p2, int started, int tight) {

        if (index == num.length()) {
            return new Pair(1, 0);
        }

        if (tight == 0 && dp[index][p1][p2][started][0] != null) {
            return dp[index][p1][p2][started][0];
        }

        int limit = (tight == 1) ? num.charAt(index) - '0' : 9;

        long totalCount = 0;
        long totalWave = 0;

        for (int digit = 0; digit <= limit; digit++) {

            int newTight = (tight == 1 && digit == limit) ? 1 : 0;

            if (started == 0 && digit == 0) {

                Pair next = dfs(
                        index + 1,
                        10,
                        10,
                        0,
                        newTight
                );

                totalCount += next.count;
                totalWave += next.wave;
            }
            else {

                long add = 0;

                if (p1 != 10 && p2 != 10) {

                    boolean peak =
                            (p1 < p2 && p2 > digit);

                    boolean valley =
                            (p1 > p2 && p2 < digit);

                    add = (peak || valley) ? 1 : 0;
                }

                Pair next;

                if (p2 == 10) {

                    next = dfs(
                            index + 1,
                            10,
                            digit,
                            1,
                            newTight
                    );
                }
                else {

                    next = dfs(
                            index + 1,
                            p2,
                            digit,
                            1,
                            newTight
                    );
                }

                totalCount += next.count;

                totalWave += next.wave + add * next.count;
            }
        }

        Pair ans = new Pair(totalCount, totalWave);

        if (tight == 0) {
            dp[index][p1][p2][started][0] = ans;
        }

        return ans;
    }
}