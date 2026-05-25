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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
    
        List<TreeNode> nodes = new ArrayList();
        findElements(root, subRoot.val, nodes);
        if(nodes.size() == 0){
            return false;
        }

        for(TreeNode node:nodes){
            if(isSameTree(node, subRoot)){
                return true;
            }
        }
        return false;
        
    }

public void findElements(TreeNode root, int k, List<TreeNode> nodes){
    if(root == null){
        return;
    }

    if(root.val == k){
        nodes.add(root);
    }

    findElements(root.left, k, nodes);
    findElements(root.right, k, nodes);

}

     public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q == null){
            return p==q;
        }
        if(p.val != q.val){
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
