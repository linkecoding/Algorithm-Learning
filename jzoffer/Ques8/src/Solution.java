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
public class Solution {
    public int JumpFloor(int target) {
        if (target <= 0) {
            return 0;
        }
        int one = 0;
        int two = 1;
        int fn = one + two;
        while (target-- > 0){
            fn = one + two;
            one = two;
            two = fn;
        }
        return fn;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().JumpFloor(2));
    }
}