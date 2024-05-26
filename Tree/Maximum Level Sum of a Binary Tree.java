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
    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        int maxSum = Integer.MIN_VALUE;
        int maxLevel = 0;
        int currentLevel = 0;

        while (!q.isEmpty()) {
            int levelSize = q.size();
            int currentSum = 0;
            currentLevel++;

            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode = q.poll();
                currentSum += currNode.val;

                if (currNode.left != null) {
                    q.add(currNode.left);
                }

                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
                maxLevel = currentLevel;
            }
        }

        return maxLevel;
    }
}
