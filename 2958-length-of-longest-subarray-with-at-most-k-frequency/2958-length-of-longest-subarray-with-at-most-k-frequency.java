class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        int ans = 0;
        for (int i = 0, j = 0; i < nums.length; i++) {
            count.merge(nums[i], 1, Integer::sum);
            while (count.get(nums[i]) > k) {
                count.merge(nums[j++], -1, Integer::sum);
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }
}
