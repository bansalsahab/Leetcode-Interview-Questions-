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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> averages = new ArrayList<>();
        if(root == null){
            return averages;
        }
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        

        while(!q.isEmpty()){
            int levelSize = q.size();
            double sum  =0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode = q.poll();
                sum+= currNode.val;

                if (currNode.left != null) {
                    q.add(currNode.left);
                }

                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
            averages.add(sum/levelSize);
        }
        return averages;
    }
}
