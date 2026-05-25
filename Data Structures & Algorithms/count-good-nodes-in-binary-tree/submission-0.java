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
    public int goodNodes(TreeNode root) {
        int[] ans = new int[1];

        goodNodesHelper(root, ans, Integer.MIN_VALUE);
        return ans[0];
    }

    private void goodNodesHelper(TreeNode root, int[] ans, int maxValue) {
        if(root == null){
            return ;
        }

        if(root.val >= maxValue){
            ans[0]++;
        }

        int currMax = Math.max(maxValue, root.val);
        
        goodNodesHelper(root.left, ans, currMax);
        goodNodesHelper(root.right, ans, currMax);
        
    }
}
