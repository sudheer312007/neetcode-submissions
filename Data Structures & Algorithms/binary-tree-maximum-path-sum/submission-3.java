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
       public int maxPathSum(TreeNode root) {
        int[] ans = new int[1];
        ans[0] = Integer.MIN_VALUE;
        maxPathSumHelper(root, ans);
        return ans[0];
    }

    private int maxPathSumHelper(TreeNode root, int[] ans) {
        if (root == null) {
            return 0;
        }

        int lh = maxPathSumHelper(root.left, ans);
        int rh = maxPathSumHelper(root.right, ans);

        ans[0] = Math.max(ans[0], Math.max(root.val, Math.max(root.val + lh + rh, Math.max(root.val + lh, root.val + rh))));


        int returningMax = Math.max(root.val, Math.max(root.val + lh, root.val + rh));

        return Math.max(0, returningMax);

    }
}
