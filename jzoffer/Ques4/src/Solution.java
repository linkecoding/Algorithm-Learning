
/**
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *
 *     TreeNode(int x) {
 *         val = x;
 *     }
 * }
 *
 * 题目描述
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
 * 则重建二叉树并返回。
 *
 * 解题思路
 * 遍历中序遍历的序列,通过前序遍历第一个节点找到中序遍历的左右子树的遍历数组,
 * 递归处理
 */
public class Solution {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length == 0 || in.length == 0){
            return null;
        }
        return reConBTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private TreeNode reConBTree(int[] pre, int preleft, int preright, int[] in, int inleft, int inright) {
        if (preleft > preright || inleft > inright){
            return null;
        }
        //新建一个TreeNode
        TreeNode root = new TreeNode(pre[preleft]);
        //对中序数组进行输入边界的遍历
        for (int i = inleft; i <= inright; i++) {
            if (pre[preleft] == in[i]) {
                //重构左子树，注意边界条件
                root.left = reConBTree(pre, preleft + 1, preleft + i - inleft, in, inleft, i - 1);
                //重构右子树，注意边界条件
                root.right = reConBTree(pre, preleft + i + 1 - inleft, preright, in, i + 1, inright);
            }
        }
        return root;
    }
}