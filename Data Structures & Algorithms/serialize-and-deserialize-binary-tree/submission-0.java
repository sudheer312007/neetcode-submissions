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

public class Codec {

    public String serialize(TreeNode root) {
        String ans = "";
        Queue<TreeNode> que = new LinkedList<>();

        if (root == null) {
            return ans;
        }
        que.offer(root);
        TreeNode dummy = new TreeNode(Integer.MIN_VALUE);
        while (!que.isEmpty()) {
            int currentLevel = que.size();

            while (currentLevel > 0) {
                TreeNode temp = que.poll();

                if (temp != dummy) {
                    ans += temp.val;
                    ans += ",";
                } else {
                    ans += "#,";
                }


                if (temp.left != null) {
                    que.offer(temp.left);
                } else if (temp != dummy) {
                    que.offer(dummy);
                }
                if (temp.right != null) {
                    que.offer(temp.right);
                } else if (temp != dummy) {
                    que.offer(dummy);
                }
                currentLevel--;
            }

        }

        return ans;

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "") {
            return null;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(data, ",");
        System.out.println(stringTokenizer.countTokens());
        Queue<TreeNode> que = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(stringTokenizer.nextToken()));
        que.offer(root);
        while (!que.isEmpty()) {
            TreeNode temp = que.poll();
            String leftToken = stringTokenizer.nextToken();
            TreeNode left = leftToken.equals( "#") ? null : new TreeNode(Integer.parseInt(leftToken));
            temp.left = left;
            if (left != null) {
                que.offer(left);
            }
            String rightToken = stringTokenizer.nextToken();
            TreeNode right = rightToken.equals( "#") ? null : new TreeNode(Integer.parseInt(rightToken));
            temp.right = right;
            if (right != null) {
                que.offer(right);
            }
        }
        return root;
    }
}
