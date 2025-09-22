class Solution {
    public int maxFrequencyElements(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] > max){
                max = nums[i];
            }
        }
        int arr[] = new int[max+1];
        for(int i = 0;i<nums.length;i++){
            arr[nums[i]] += 1;
        }
       Arrays.sort(arr);
        int maxFreq = arr[arr.length - 1]; // highest frequency
        int frequency = 0;

        // count total occurrences of elements having maxFreq
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == maxFreq) {
                frequency += arr[i];
            } else {
                break; // because array is sorted
            }
        }
        return frequency;
        
    }
}