## 剑指offer题目(Java语言实现)

#### [Ques1](https://github.com/codekongs/Algorithm-Learning/blob/master/jzoffer/Ques1/src/Solution.java)

```
/**
 * 题目描述
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 解题思路
 * 最后一行的数据是这一列最大的
 * 比该列最后一个数据还大，那就在下一列找
 * 比该列最后一个数据小，就在该列从下往上扫描
 * 即从左下角开始扫描
 */
```

#### [Ques2](https://github.com/codekongs/Algorithm-Learning/blob/master/jzoffer/Ques2/src/Solution.java)

```
/**
 * 题目描述
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * 解题思路
 * 遍历字符串找到ASCII码为32(空格的ASCII码)时使用replace方法替换
 */
```

#### [Ques3](https://github.com/codekongs/Algorithm-Learning/blob/master/jzoffer/Ques3/src/Solution.java)

```
/**
* public class ListNode {
*     int val;
*     ListNode next = null;
*     ListNode(int val) {
*         this.val = val;
*     }
* }
*
* 题目描述
* 输入一个链表，从尾到头打印链表每个节点的值。
*
* 解题思路
* 方法一: 存储在List里面,再逆置list
* 方法二: 使用栈存储链表节点数据
* 方法二: 直接递归输出链表
*/
```

#### [Ques4](https://github.com/codekongs/Algorithm-Learning/blob/master/jzoffer/Ques4/src/Solution.java)

```
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
```

#### [Ques5](https://github.com/codekongs/Algorithm-Learning/blob/master/jzoffer/Ques5/src/Solution.java)

```
/**
 * 题目描述
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 *
 * 解题思路
 * 两个栈,第一个用来保存添加的元素,模拟入队。
 * 当需要出队时,将第一个栈中的元素压入第二个栈中,顺序就是正序,再弹出就是出队
 * 注意:第一个栈必须一次性将数据压入第二个栈中,当第二个栈不为空时,不能向第二个栈中压入数据
 */
```

#### [Ques6](https://github.com/codekongs/Algorithm-Learning/blob/master/jzoffer/Ques6/src/Solution.java)

```
/**
 * 题目描述
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 * 解题思路
 * 方法一:遍历数组,找到数组中的最小值,此时复杂度为n
 * 方法二:旋转后的数组在整体看来是两个有序数组,
 *       最小的值位于array[i] > array[i+1]时(例如:3 4 5 1 2   当出现5 > 1时找到的就是最小值)
 * 方法三:由于旋转后的数组可以看做两个有序数组,所以可以使用二分查找到思想解决
 *       (1)分别使用三个下标index1,index2,midIndex分别指向前半部分的有序数组的低位,后半部分有序数组的高位和整个数组的中间
 *       (2)当array[midIndex] >= array[index1]说明当前midIndex位于前半部分数组中
 *          当array[midIndex] <= array[index2]说明当前midIndex位于后半部分数组中
 *          当index2 - index1 == 1时,index2所指的即为最小值(即就是最小值是两个数组的分割点)
 *       (3)为了处理[1 0 1 1 1]这种array[index1] = array[index2] = array[midIndex]的情况,需要进行遍历扫描
 */
```
