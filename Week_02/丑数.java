class Solution {
    public int nthUglyNumber(int n) {
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int p2 = 2 * dp[a];
            int p3 = 3 * dp[b];
            int p5 = 5 * dp[c];
            dp[i] = Math.min(Math.min(p2, p3), p5);
            if (dp[i] == p2) {
                a++;
            }
            if (dp[i] == p3) {
                b++;
            }
            if (dp[i] == p5) {
                c++;
            }
        }

        return dp[n - 1];
    }
}