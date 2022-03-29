/*
Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.

A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.

Example:
Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: [[5,4,11,2],[5,8,4,5]]
Explanation: There are two paths whose sum equals targetSum:
5 + 4 + 11 + 2 = 22
5 + 8 + 4 + 5 = 22


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



import java.util.*;

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        List<List<Integer>> paths = new ArrayList<>();
        
        if (root == null)
        {
            return paths;
        }
        
        if (root.left == null && root.right==null)
        {
            if (targetSum == root.val)
            {
                List leaf = new ArrayList<>();
                leaf.add(root.val);
                paths.add(leaf);
            }
            return paths;
        }
        
        List<List<Integer>> left = new ArrayList<>();
        if (root.left!=null)
        {
            left = pathSum(root.left, targetSum-root.val);
            for (int i = 0; i<left.size(); i++)
            {
                left.get(i).add(0,root.val);
            }
        }
        
        List<List<Integer>> right = new ArrayList<>();
        if (root.right!=null)
        {
            right = pathSum(root.right, targetSum-root.val);
            for (int i = 0; i<right.size(); i++)
            {
                right.get(i).add(0,root.val);
            }
        }
        
        left.addAll(right);
        
        return left;
    }
}
