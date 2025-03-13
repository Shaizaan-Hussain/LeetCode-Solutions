/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode fun(int[] nums, int low, int high){
        if(low>high) return null;
        int mid = low+ (high-low)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = fun(nums, low, mid-1);
        root.right = fun(nums, mid+1, high);
        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode node = fun(nums,0,nums.length-1);
        return node;
    }
}