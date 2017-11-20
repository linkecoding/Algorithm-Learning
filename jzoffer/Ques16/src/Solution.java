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
                return HasSubtree(root1.left, root2);
            }
            if (!result) {
                //在右子树上继续寻找和B树根节点相同的节点
                return HasSubtree(root1.right, root2);
            }
        }
        return result;
    }

    //判断A树中以R为根节点的子树是不是和B树结构相同
    private boolean doesTree1HaveTree2(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
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

    private static TreeNode createTree(String[] array, int index) {
        TreeNode treeNode = null;
        if (index < array.length) {
            if (array[index].equals("#")) {
                treeNode = null;
                index++;
            } else {
                treeNode = new TreeNode(Integer.parseInt(array[index++]));
                treeNode.left = createTree(array, index);
                treeNode.right = createTree(array, index);
            }
        }
        return treeNode;
    }

    public static void main(String[] args) {
        String[] array1 = {"8", "8", "7", "9", "2", "#", "#", "#", "#", "4", "7"};
        String[] array2 = {"8", "9", "2"};
        TreeNode tree1 = createTree(array1, 0);
        TreeNode tree2 = createTree(array2, 0);
        System.out.println(new Solution().HasSubtree(tree1, tree2));

    }
}