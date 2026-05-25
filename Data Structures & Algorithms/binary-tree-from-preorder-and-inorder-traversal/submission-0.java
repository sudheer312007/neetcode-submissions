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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeHelper(map, preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(Map<Integer, Integer> inOrderHash, int[] preorder, int startPre, int endPre, int[] inorder, int startIn, int endIn) {
        if(startPre > endPre || startIn > endIn ){
            return null;
        }

        TreeNode root = new TreeNode(preorder[startPre]);
        int inIdx = inOrderHash.get(root.val);
        int numsLeft = inIdx - startIn;
        root.left = buildTreeHelper(inOrderHash, preorder, startPre + 1, startPre + numsLeft, inorder, startIn, inIdx - 1);
        root.right = buildTreeHelper(inOrderHash, preorder, startPre + numsLeft + 1, endPre, inorder, inIdx + 1, endIn);
        return root;
    }
}
