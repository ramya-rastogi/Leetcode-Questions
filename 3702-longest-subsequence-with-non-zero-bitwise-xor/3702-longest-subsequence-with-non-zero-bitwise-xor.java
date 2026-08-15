class Solution {
    public int longestSubsequence(int[] nums) {
        int xor = 0, cnt0 = 0;
        int n = nums.length;
        for (int x : nums) {
            xor ^= x;
            if (x == 0) cnt0++;
        }
        if (xor != 0) return n;
        return cnt0 == n ? 0 : n - 1;
    }
}
