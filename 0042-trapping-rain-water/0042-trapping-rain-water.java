class Solution {
    public int trap(int[] height) {

        // int n = height.length;
        // int prefix[] = new int[n];
        // int suffix[] = new int[n];
        // prefix[0] = height[0];
        // for (int i = 1; i < n; i++) {
        //     prefix[i] = Math.max(prefix[i - 1], height[i]);
        // }
        // suffix[n - 1] = height[n - 1];
        // for (int i = n - 2; i >= 0; i--) {
        //     suffix[i] = Math.max(suffix[i + 1], height[i]);
        // }
        // int waterTrapped = 0;
        // for (int i = 0; i < n; i++) {
        //     waterTrapped += Math.min(prefix[i], suffix[i]) - height[i];
        // }
        // return waterTrapped;

        int n = height.length;
        int left = 0;
        int right = n-1;
        int lmax=height[0];
        int rmax=height[n-1];

        int result =0;

        while(left<=right){

            if(height[left]<=height[right]){
                if(height[left]>=lmax){
                    lmax=height[left];
                }else{
                    result += (lmax-height[left]);
                }
                left++;
            }else{
                if(height[right]>=rmax){
                    rmax=height[right];
                }else{
                    result += (rmax-height[right]);
                }
                right--;
            }
        }

        return result;
        
    }
}