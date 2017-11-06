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
public class Solution {

    //方法一
    public int Fibonacci(int n) {
        if (n < 1){
            return 0;
        }
        int count = 1;
        int fib1 = 0;
        int fib2 = 1;
        int fib = fib1 + fib2;
        while (count < n){
            fib = fib1 + fib2;
            fib1 = fib2;
            fib2 = fib;
            count++;
        }
        return fib;
    }

    //方法二
    public int Fibonacci2(int n) {
        if (n <= 1){
            return n;
        }else{
            return Fibonacci2(n - 1) + Fibonacci2(n - 2);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().Fibonacci(40));
        System.out.println(new Solution().Fibonacci2(40));
    }
}