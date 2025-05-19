import java.util.Arrays;

class Solution {
    public String triangleType(int[] nums) {
        Arrays.sort(nums);
        
        // Check for valid triangle
        if (nums[0] + nums[1] <= nums[2]) {
            return "none";
        }
        
        // All sides equal
        if (nums[0] == nums[1] && nums[1] == nums[2]) {
            return "equilateral";
        }
        
        // Two sides equal
        if (nums[0] == nums[1] || nums[1] == nums[2] || nums[0] == nums[2]) {
            return "isosceles";
        }

        // All sides different
        return "scalene";
    }
}
