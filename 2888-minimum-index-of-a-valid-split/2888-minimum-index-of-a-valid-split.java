import java.util.*;

class Solution {
    public int minimumIndex(List<Integer> numsList) {
        int n = numsList.size();
        int[] nums = numsList.stream().mapToInt(i -> i).toArray(); // Convert List to int[]

        Map<Integer, Integer> freq = new HashMap<>();

        // Count frequencies of each element
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Identify the dominant element
        int dom = -1, count = 0;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() * 2 > n) {
                dom = entry.getKey();
                count = entry.getValue();
                break;
            }
        }

        if (dom == -1) return -1; // No dominant element

        // Check for valid split
        int leftCount = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == dom) leftCount++;
            int leftSize = i + 1;
            int rightCount = count - leftCount;
            int rightSize = n - leftSize;

            if (leftCount * 2 > leftSize && rightCount * 2 > rightSize) {
                return i;
            }
        }

        return -1;
    }
}
