class Solution {
    public String triangleType(int[] nums) {
        int a = nums[0], b = nums[1], c = nums[2];

        // Check triangle validity using triangle inequality
        if (a + b <= c || a + c <= b || b + c <= a) return "none";

        // All sides equal
        if (a == b && b == c) return "equilateral";

        // Two sides equal
        if (a == b || b == c || a == c) return "isosceles";

        // All sides different
        return "scalene";
    }
}
