/**
 * public class TreeNode {
 *     int val = 0;
 *     TreeNode left = null;
 *     TreeNode right = null;
 *     public TreeNode(int val) {
 *         this.val = val;
 *     }
 * }
 *
 * 题目描述
 * 输入两棵二叉树A，B，判断B是不是A的子结构。
 * （ps：我们约定空树不是任意一个树的子结构）
 *            8
 *           / \
 *          8  7                       8
 *  A树:    / \                 B树:   / \
 *         9  2                       9  2
 *           / \
 *           4 7
 *
 * 解题思路
 * 首先我们需要在A树中找到和B树的根节点值相同的节点R
 * 然后我们比较以R为根节点的子树和B树是不是结构相同(比较两个树的左右子树)
 * 如果两棵子树节点值不相同,则需要继续在A树中找下一个和B树根节点相同的节点Rn
 * 然后继续上面的比较
 * 整个过程需要分为两步:
 * 一、遍历A树找到和B树根节点相同的节点(递归遍历比较)
 * 二、比较找到的两颗子树是不是相同的(递归遍历比较)
 */
public class Solution {
    //TODO 部分测试用例存在问题,待调试
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        if (root1 != null && root2 != null) {
            //A树中的一个节点==B树的根节点
            if (root1.val == root2.val) {
                //比较两棵子树
                result = doesTree1HaveTree2(root1, root2);
            }
            if (!result) {
                //在左子树上继续寻找和B树根节点相同的节点
                result = HasSubtree(root1.left, root2);
            }
            if (!result) {
                //在右子树上继续寻找和B树根节点相同的节点
                result = HasSubtree(root1.right, root2);
            }
        }
        return result;
    }

    //判断A树中以R为根节点的子树是不是和B树结构相同
    private boolean doesTree1HaveTree2(TreeNode root1, TreeNode root2) {
        //如果树B已经遍历结束,那就是A树中存在子树与B一一对应
        if (root2 == null) {
            return true;
        }
        //B树还没有遍历完,A树已经遍历完了,说明A树中不存在B树的子结构
        if (root1 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            //节点值不同则肯定两棵树不相同
            return false;
        }
        //递归比较两棵树的左右子树
        return doesTree1HaveTree2(root1.left, root2.left) && doesTree1HaveTree2(root1.right, root2.right);
    }
}