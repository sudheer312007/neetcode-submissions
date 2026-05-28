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
    public int kthSmallest(TreeNode root, int k) {
        int[] ans = {k, -1};
        kthSmallestHelper(root, ans);
        return ans[1];
    }

    private void kthSmallestHelper(TreeNode root, int[] ans) {
        if(root == null){
            return;
        }

        kthSmallestHelper(root.left, ans);
        ans[0]--;
        if(ans[0] == 0){
            ans[1] = root.val;
            return;
        }
        kthSmallestHelper(root.right, ans);
    }
}
