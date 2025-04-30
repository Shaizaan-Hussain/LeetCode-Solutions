class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;  // To count numbers with even number of digits
        
        // Loop through each number in the array
        for (int i = 0; i < nums.length; i++) {
            // Convert the current number to a string and check its length
            String str = Integer.toString(nums[i]);
            if (str.length() % 2 == 0) {  // Check if the length is even
                count++;  // Increment count if the number has an even number of digits
            }
        }
        
        return count;  // Return the count of numbers with even digits
    }
}
