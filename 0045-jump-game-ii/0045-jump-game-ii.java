class Solution {
    public int jump(int[] nums) {
        if ( nums.length == 1) return 0;
        int j = 0, f = 0, c = 0;
        for (int i = 0; i <  nums.length - 1; i++) {
            f = Math.max(f, i + nums[i]);
            if (i == c) {
                j++;
                c = f;
                if (c >=  nums.length - 1) break;
            }
        }
        return j;
    }
}