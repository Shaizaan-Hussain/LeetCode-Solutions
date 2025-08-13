class Solution {
    public int trap(int[] height) {
        int n = height.length;

        // Left maximum bar auxillary array
        int[] left = new int[n];
        left[0] = height[0];
        for(int i = 1; i< n;i++){
            left[i] = Math.max(height[i], left[i-1]);
        }


         //Right maximum bar auxillary array
         int[] right = new int[n];
         right[n-1] = height[n-1];
         for(int i = n-2; i>=0;i--){
            right[i] = Math.max(height[i], right[i+1]);
         }

         //claculating trapped water
         int trappedWater = 0;
         for(int i =0;i<n;i++){
            int waterLevel = Math.min(left[i], right[i]);
            trappedWater += waterLevel - height[i];
         }

        return trappedWater;
    }
}