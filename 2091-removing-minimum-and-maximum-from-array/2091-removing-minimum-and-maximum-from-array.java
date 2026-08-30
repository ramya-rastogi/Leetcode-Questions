class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int minIndex = 0, maxIndex = 0;
        
        for (int i = 0; i < n; i++) {
            if (nums[i] < nums[minIndex]) minIndex = i;
            if (nums[i] > nums[maxIndex]) maxIndex = i;
        }
        
        int left = Math.max(minIndex, maxIndex) + 1;
        int right = n - Math.min(minIndex, maxIndex);
        int both = (minIndex + 1) + (n - maxIndex);
        int bothAlt = (maxIndex + 1) + (n - minIndex);
        
        return Math.min(left, Math.min(right, Math.min(both, bothAlt)));
    }
}
