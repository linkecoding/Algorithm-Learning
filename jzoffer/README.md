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

#### [Ques7](https://github.com/codekongs/Algorithm-Learning/blob/master/jzoffer/Ques7/src/Solution.java)

```
/**
 * 题目描述
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 * n <= 39
 *
 * 解题思路
 * 斐波那契数列的规律:1 1 2 3 5 8 13 ....
 * 第三个数 = 前两个数之和
 *
 * 方法一:按照递推公式进行循环,直到循环到第n个数,退出循环并返回
 * 方法二:使用递归,但是存在堆栈溢出的问题
 */
```

#### [Ques8](https://github.com/codekongs/Algorithm-Learning/blob/master/jzoffer/Ques8/src/Solution.java)

```
/**
 * 题目描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 * 解题思路
 * 当n = 1时,只有一种跳法
 * 当n = 2时,有两种跳法(一次跳一级跳两次或者一次跳两级跳一次)
 * 当n > 2时,我们把所有的跳法规定为f(n),对于我们第一次跳时,我们有两种跳法
 * 跳法一:跳一个台阶,那么剩下的台阶有n-1阶,我们就有f(n-1)种跳法
 * 跳法二:跳两个台阶,那么剩下的台阶有n-2阶,我们就有f(n-2)种跳法
 * 综上我们的f(n) = f(n-1) + f(n-2)
 * 所以这是一个斐波那契数列的应用
 */
```

#### [Ques9](https://github.com/codekongs/Algorithm-Learning/blob/master/jzoffer/Ques9/src/Solution.java)

```
/**
 * 题目描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 * 解题思路
 * 假设所有的跳法表示为f(n)
 * 第一次跳有n种选择,一次跳1,2,3,...,n级
 * 第一次跳1级,剩下n-1级有f(n-1)种跳法
 * 第一次跳2级,剩下n-2级有f(n-2)种跳法
 * ......
 * 第1次跳n级,剩下0级有f(0) = 0种跳法
 * 综上f(n) = f(n-1) + f(n-2) + f(n-3) + ... + f(1)
 * 则:f(n-1) = f(n-2) + f(n-3) + ... + f(1)
 * 合并 f(n) = 2f(n-1) = 2(2f(n-2)) = 2^2 * f(n-2) = 2^(n-1) * f(n-(n-1)) = 2^(n-1) * f(1)
 * f(1) = 1,则f(n) = 2^(n-1)
 * 上面可以使用移位操作提高效率
 */
```

#### [Ques10](https://github.com/codekongs/Algorithm-Learning/blob/master/jzoffer/Ques10/src/Solution.java)

```
/**
 * 题目描述
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，
 * 总共有多少种方法？
 *
 * 解题思路
 * -------------------------
 * |1 |3 |  |  |  |  |  |  |
 * -------------------------
 * |2 |4 |  |  |  |  |  |  |
 * -------------------------
 *
 * 如上图,是一个n = 8时的情形,这个大矩形是2*8 = 16的面积
 * 我们设定f(8)表示n = 8时的覆盖方法
 * 假设我们从最左边开始覆盖,我们有两种选择:
 * 选择一:用一个2*1的小矩形覆盖最左边一列(即图中1和2的位置),此时我们剩余2*7的大矩形,我们还有f(7)种覆盖方法
 * 选择二:用一个2*1的小矩形覆盖左上角的位置(即1和3的位置),此时我们必须使用另一个2*1的小矩形覆盖左下角的位置(即2和4的位置)
 *       只有这样才能继续使用2*1的小矩形完整覆盖大矩形,此时剩余2*6的大矩形,我们有f(6)种覆盖方法
 * 综上:f(8) = f(7) + f(6),该题是斐波那契数列的应用
 */
```

#### [Ques11](https://github.com/codekongs/Algorithm-Learning/blob/master/jzoffer/Ques11/src/Solution.java)

```
/**
 * 题目描述
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 *
 * 解题思路
 * 如果一个数不为0,那么它的二进制表示中至少有一个1
 * 对于一个数n如果它的第m位为1,m位之后都为0,则n-1则是m位前面的位值数值不变,m位变为0,m位之后的位全变为1
 * 然后我们将n&(n-1)则会获得m位之前的所有位不变,m位及m位之后的位变为0,与原来的数n相比较它们的二进制表示正好少了一个1
 * 例如:n = 1100  n - 1 = 1011
 * n&(n-1) = 1000   1000与1100相比较正好是最右边的1消失了,所以可以使用n&(n-1)来通过位运算统计一个数的二进制表示中1的个数
 */
```

#### [Ques12](https://github.com/codekongs/Algorithm-Learning/blob/master/jzoffer/Ques12/src/Solution.java)

```
/**
 * 题目描述
 * 给定一个double类型的浮点数base和int类型的整数exponent。
 * 求base的exponent次方。
 *
 * 解题思路:
 * 方法一:对于base和exponent要分情况考虑
 *       对于base == 0时, 0^0没有意义,当base == 0且exponent < 0时会出现除数为0的情况
 *       对于exponent分为大于0,等于0和小于0,然后使用循环计算他们的乘方
 * 方法二:除了方法一的分情况讨论之外,我们可以对一个数求乘方进行优化
 *       当n为偶数时,a^n = a^(n/2) * a^(n/2)
 *       当n为奇数时,a^n = a^((n-1)/2) * a^((n-1)/2) * a
 *       例如:81 = 9^2 = ((3^2))^2,所以可以通过递归实现求幂次方
 */
```

#### [Ques13](https://github.com/codekongs/Algorithm-Learning/blob/master/jzoffer/Ques13/src/Solution.java)

```
/**
 * 题目描述
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * 解题思路
 * 使用一个新的数组,在前面正向存储奇数,从尾部开始逆向存储偶数,然后再开始拷贝回原数组
 */
```

#### [Ques14](https://github.com/codekongs/Algorithm-Learning/blob/master/jzoffer/Ques14/src/Solution.java)

```
/**
 *
 * public class ListNode {
 *    int val;
 *    ListNode next = null;
 *    ListNode(int val) {
 *        this.val = val;
 *    }
 * }
 *
 * 题目描述
 * 输入一个链表，输出该链表中倒数第k个结点。
 *
 * 解题思路
 * 这道题使用快慢指针来解决
 * 我们设置两个指针fast指针和slow指针刚开始都指向链表头结点
 * 然后我们先让fast指针先走k-1步
 * 最后我们让fast指针和slow指针同时走,当fast指针指向的节点指向最后一个节点时,
 * slow指针指向的正好是链表的倒数第k个节点
 *
 * 证明思路
 * 如果我们要找到倒数第k个节点,也就是正向的第n-k+1个节点
 * n-(n-k+1) = k-1就是说我们的最后一个节点和倒数第k个节点之相隔的节点是k-1个
 * 所以我们刚开始让fast指针先走k-1步,便于我们构造出这样一个间隔
 */
```

#### [Ques15](https://github.com/codekongs/Algorithm-Learning/blob/master/jzoffer/Ques15/src/Solution.java)

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
 * 输入两个单调递增的链表，输出两个链表合成后的链表，
 * 当然我们需要合成后的链表满足单调不减规则。
 *
 * 解题思路
 * 方法一:该题目首先注意对空链表异常情况的处理
 *       然后用head节点作为最终链表的头节点(该节点不要变化,最终返回)
 *       使用phead作为移动节点,使用head1和head2分别指向需要合并的两个链表当前需要处理的节点,
 *       依次比较两个链表节点的值,直到有一个指针的next为空,此时需要判断是否是有一个链表处理完成还有一个链表的节点没有处理完成
 *       然后将没有处理完成的链表剩余节点接在最终链表的最后面即可
 *
 * 方法二:我们可以使用递归
 *       当我们链表一的头节点的值小于链表二的头节点的值,那么合并之后的链表头节点就是链表一的头节点,反之亦然
 *       当这一步完成后,头节点的下一个节点就会成为新的头节点,我们可以继续递归处理,将每次比较产生的较小的头节点接在合并链表之后即可
 *       当其中一个较短的链表已经比较完成时,我们就可将较长链表的剩余部分接在合并链表的最后面即可
 */
```
