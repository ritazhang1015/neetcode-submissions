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
        if(preorder.length == 1) return new TreeNode(preorder[0]);

        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++){
            inMap.put(inorder[i], i);
        }

        return buildTreeHelper(0, preorder.length-1, 0, inorder.length-1, inMap, preorder);
    }

    public TreeNode buildTreeHelper(int preStart, int preEnd, int inStart, int inEnd, Map<Integer, Integer> inMap, int[] preorder){
        if (preStart > preEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIn = inMap.get(root.val);
        int k = rootIn - inStart;

        root.left = buildTreeHelper(preStart + 1, preStart + k, inStart, inStart + k, inMap, preorder);
        root.right = buildTreeHelper(preStart + k + 1, preEnd, inStart + k + 1, inEnd, inMap, preorder);

        return root;
    }
}
