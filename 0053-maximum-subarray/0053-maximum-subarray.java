import java.util.*;
class Solution {
    public int maxSubArray(int[] arr) {

        //Brute Force
        // int max = Integer.MIN_VALUE;
        // int sum = 0 ;
        // for(int i =0;i<nums.length;i++){
        //     for(int j = i;j<nums.length;j++){
        //         sum = 0;
        //         for(int k =i;k<=j;k++){
        //             sum += nums[k];
        //         }
        //         if(max < sum){
        //             max = sum;
        //         }
        //     }
        // }
        // return max;



        // (prefix array) O(n2)
        // int max  = Integer.MIN_VALUE;
        // int sum = 0;
        // int prefix[] = new int[arr.length];

        // prefix[0] = arr[0];
        // for(int i = 1;i<arr.length;i++){
        //     prefix[i] = prefix[i-1] + arr[i];
        // }

        // for(int i =0;i<arr.length;i++){
        //     for(int j = i;j<arr.length;j++){
        //         sum = (i==0)? prefix[j] : prefix[j] - prefix[i-1];
        //         if (max < sum) {
        //             max = sum;
        //         }
        //     }
        // }
        // return max;
        

        //(Kadane's Algo) O(n)
        int ms = Integer.MIN_VALUE;
        int cs = 0;
        for(int i = 0 ;i<arr.length;i++){
            cs += arr[i];
            ms = Math.max(ms, cs);
            if(cs < 0){
                cs = 0;
            }
        
        }
        return ms;
    }
}