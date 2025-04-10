class Solution {
    public static int minStoneSum(int[] piles, int k) {
        int[] arr = new int[10001];
        int max = -1;
        for(int i : piles){
            arr[i]++;
            max = Math.max(max , i);
        }
        for(int i=max; i>0 && k>0; i--){
            while(arr[i]>0 && k>0){
                arr[i]--;
                arr[(i+1)/2]++;
                k--;
            }
        }
        int answer = 0;
        for(int i=max; i>0; i--){
            answer += arr[i]*i;
        }
        return answer;
    }
}