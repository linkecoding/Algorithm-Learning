/**
 * 题目描述
 * 给定一个double类型的浮点数base和int类型的整数exponent。
 * 求base的exponent次方。
 * <p>
 * 解题思路:
 * 方法一：对于base和exponent要分情况考虑
 * 对于base == 0时, 0^0没有意义,当base == 0且exponent < 0时会出现除数为0的情况
 * 对于exponent分为大于0,等于0和小于0,然后使用循环计算他们的乘方
 */
public class Solution {
    public double Power(double base, int exponent) {
        if (equal(base, 0.0) && exponent < 0) {
            return 0.0;
        }
        double result = 1;
        if (exponent == 0) {
            return 1.0;
        } else if (exponent > 0) {
            for (int i = 0; i < exponent; i++) {
                result *= base;
            }
        } else {
            for (int i = 0; i < -exponent; i++) {
                result *= base;
            }
            result = 1 * 1.0 / result;
        }
        return result;
    }

    /**
     * 判断两个double数是否相等
     * @param num1
     * @param num2
     * @return
     */
    private boolean equal(double num1, double num2){
        if (num1 - num2 > -0.0000001 && num1 - num2 < 0.0000001){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().Power(1.0, 0));
        System.out.println(new Solution().Power(3.0, -2));
        System.out.println(new Solution().Power(-5, 2));
        System.out.println(new Solution().Power(-5, -2));
        System.out.println(new Solution().Power(0, -2));
    }
}