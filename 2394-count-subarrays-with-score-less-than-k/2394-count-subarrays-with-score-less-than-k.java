class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        long result = 0;
        long sum = 0;

        int i = 0; // Left pointer

        for (int j = 0; j < n; j++) {
            sum += nums[j]; // Expand window to include nums[j]

            // Shrink window if condition is violated
            while (i <= j && sum * (j - i + 1) >= k) {
                sum -= nums[i];
                i++;
            }

            // Add the count of valid subarrays ending at j
            result += (j - i + 1);
        }

        return result;
    }
}
