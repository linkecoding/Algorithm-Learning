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
public class Solution {
    public int NumberOf1(int n) {
        int sum = 0;
        while (n != 0){
            n = n & (n-1);
            sum++;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().NumberOf1(-1));
    }
}