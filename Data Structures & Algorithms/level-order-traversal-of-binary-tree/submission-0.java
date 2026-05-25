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
     public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();

        if (root == null) {
            return ans;
        }
        que.offer(root);
        while (!que.isEmpty()) {
            List<Integer> levelAns = new ArrayList<>();
            int currentLevel = que.size();
            while (currentLevel > 0) {
                TreeNode temp = que.poll();
                levelAns.add(temp.val);

                if (temp.left != null) {
                    que.offer(temp.left);
                }
                if (temp.right != null) {
                    que.offer(temp.right);
                }
                currentLevel--;
            }
            ans.add(levelAns);

        }

        return ans;

    }
}
