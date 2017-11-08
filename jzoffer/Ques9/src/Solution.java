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
public class Solution {
    public int JumpFloorII(int target) {
        if (target <= 0){
            return 0;
        }
        int sum = 1;
        return sum << (target - 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().JumpFloorII(2));
    }
}

