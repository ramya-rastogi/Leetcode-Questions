class Solution {
    public long findKthSmallest(int[] coins, int k) {
        List<Long>[] lcms = getLcms(coins);
        long l = 1, r = (long) k * Arrays.stream(coins).min().getAsInt();
        while (l < r) {
            long mid = (l + r) / 2;
            if (count(lcms, mid) >= k) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    private long count(List<Long>[] lcms, long x) {
        long res = 0;
        for (int sz = 1; sz < lcms.length; sz++) {
            for (long lcm : lcms[sz]) {
                res += (x / lcm) * ((sz % 2 == 1) ? 1 : -1);
            }
        }
        return res;
    }

    private List<Long>[] getLcms(int[] coins) {
        int n = coins.length;
        List<Long>[] lcms = new List[n + 1];
        for (int i = 1; i <= n; i++) lcms[i] = new ArrayList<>();
        int maxMask = 1 << n;
        for (int mask = 1; mask < maxMask; mask++) {
            long lcm = 1;
            for (int i = 0; i < n; i++) {
                if ((mask >> i & 1) == 1) {
                    lcm = lcm(lcm, coins[i]);
                }
            }
            lcms[Integer.bitCount(mask)].add(lcm);
        }
        return lcms;
    }

    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
