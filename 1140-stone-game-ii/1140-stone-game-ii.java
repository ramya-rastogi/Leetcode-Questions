class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] suffix = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }
        Integer[][] memo = new Integer[n][n + 1];
        return dfs(0, 1, piles, suffix, memo);
    }

    private int dfs(int i, int M, int[] piles, int[] suffix, Integer[][] memo) {
        int n = piles.length;
        if (i >= n) return 0;
        if (memo[i][M] != null) return memo[i][M];
        if (2 * M >= n - i) return suffix[i];
        int best = 0;
        for (int X = 1; X <= 2 * M; X++) {
            best = Math.max(best, suffix[i] - dfs(i + X, Math.max(M, X), piles, suffix, memo));
        }
        return memo[i][M] = best;
    }
}
