/**
 * 题目描述
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 输入描述:
 * 二叉树的镜像定义：
 *    8                                     8
 *   /  \                                  /  \
 *   6   10       -----镜像二叉树---->      10  6
 *  / \  / \                              / \ / \
 *  5  7 9 11                            11 9 7 5
 * public class TreeNode {
 *     int val = 0;
 *     TreeNode left = null;
 *     TreeNode right = null;
 *     public TreeNode(int val) {
 *         this.val = val;
 *     }
 * }
 *
 * 解题思路
 * 通过上面图示的分析,我们会发现,我们只需要从上到下遍历二叉树,并且交换它的非叶子节点的左右子树即可
 * 由于我们对每个非叶子节点也是做镜像,所以可以使用递归来处理,同时需要处理异常情况
 */
public class Solution {
    public void Mirror(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)){
            return;
        }

        TreeNode lchild = root.left;
        root.left = root.right;
        root.right = lchild;

        if (root.left != null){
            Mirror(root.left);
        }

        if (root.right != null){
            Mirror(root.right);
        }
    }

    private void swapLeftAndRight(TreeNode root) {
        TreeNode lchild = root.left;
        root.left = root.right;
        root.right = lchild;
    }
}