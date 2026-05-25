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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path1 = new ArrayList<>();
        rootToNodePath(root, p, path1);
        List<TreeNode> path2 = new ArrayList<>();
        rootToNodePath(root, q, path2);

        TreeNode ans = null;
        for (int i = 0; i < path1.size() && i < path2.size(); i++) {
            if(path1.get(i) == path2.get(i)){
                ans = path1.get(i);
            }
        }

        return ans;
    }

    public boolean rootToNodePath(TreeNode root, TreeNode p, List<TreeNode> path) {
        if (root == null) {
            return false;
        }

        path.add(root);
        if (root.val == p.val) {
            return true;
        }

        boolean foundLeft = rootToNodePath(root.left, p, path);
        boolean foundRIght = rootToNodePath(root.right, p, path);

        if (!foundLeft && !foundRIght) {
            path.remove(root);
            return false;
        }
        return true;
    }
}
