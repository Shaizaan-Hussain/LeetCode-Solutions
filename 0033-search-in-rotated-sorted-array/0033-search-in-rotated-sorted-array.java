class Solution {
    private int search(int arr[], int tar, int si, int ei){
       if (si > ei) {
            return -1;
        }
        // kaam
        int mid = si + (ei - si) / 2;
        // check on mid
        if (arr[mid] == tar) {
            return mid;
        }
        // check on line L1
        if (arr[si] <= arr[mid]) {
            // left side
            if (arr[si] <= tar && tar <= arr[mid]) {
                return search(arr, tar, si, mid - 1);
            }
            // right side
            else {
                return search(arr, tar, mid + 1, ei);
            }
        }
        // lies on L2
        else {
            // right side
            if (arr[mid] <= tar && tar <= arr[ei]) {
                return search(arr, tar, mid + 1, ei);
            }
            // left side
            else {
                return search(arr, tar, si, mid - 1);
            }
        }
    }
    public int search(int[] arr, int target) {
       return search(arr, target,0,arr.length-1);
    }
}