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
    public boolean isValidBST(TreeNode root) {
        if (root == null) return false;

        List<Integer> inOrder = new ArrayList<>();
        inOrderTraversal(root, inOrder);

        if(inOrder.size() == 0) return true;
        
        int[] result = new int[inOrder.size()];
        for (int i = 0; i < result.length; i++){
            result[i] = inOrder.get(i);
        }
        
        int i = 0; int j = 1;
        while(i < result.length && j < result.length){
            if(result[i] >= result[j]) return false;
            i++; j++;
        }
        return true;
    }

    public void inOrderTraversal(TreeNode root, List<Integer> inOrder){
        if(root == null) return;

        inOrderTraversal(root.left, inOrder);
        inOrder.add(root.val);
        inOrderTraversal(root.right, inOrder);
    }
}
