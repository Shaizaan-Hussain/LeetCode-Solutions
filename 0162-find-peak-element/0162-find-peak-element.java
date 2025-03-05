class Solution {
    public int findPeakElement(int[] nums) {
        int start = 1;
		int end = nums.length - 2;
        if(nums.length==1 || nums[0] > nums[1]) {
			return 0;
		} else if (nums[end] < nums[end + 1]) {
			return end + 1;
		}
		while (start <= end) {
			int mid = (start + end) / 2;
			if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
				return mid;
			} else if (nums[mid - 1] > nums[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return 0;
    }
}