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
 *      当n为偶数时,a^n = a^(n/2) * a^(n/2)
 *      当n为奇数时,a^n = a^((n-1)/2) * a^((n-1)/2) * a
 *      例如:81 = 9^2 = ((3^2))^2,所以可以通过递归实现求幂次方
 */
public class Solution {
    //方法一
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

    //方法二
    public double Power2(double base, int exponent) {
        if (equal(base, 0.0) && exponent < 0) {
            return 0.0;
        }
        double result = 1;
        if (exponent == 0) {
            return 1.0;
        } else if (exponent > 0) {
            result = powerWithExponent(base, exponent);
        } else {
            result = powerWithExponent(base, -exponent);
            result = 1 * 1.0 / result;
        }
        return result;
    }

    //使用递归求幂次方
    private double powerWithExponent(double base, int exponent){
        if (exponent == 0){
            //一个数的0幂次方为1
            return 1;
        }else if (exponent == 1){
            return base;
        }
        //使用移位来代替除以2
        double result =  powerWithExponent(base, exponent >> 1);
        result *= result;

        //判断exponent是奇数还是偶数
        if ((exponent & 0x1) == 1){
            //奇数
            result *= base;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().Power(1.0, 0));
        System.out.println(new Solution().Power(3.0, -2));
        System.out.println(new Solution().Power(-5, 2));
        System.out.println(new Solution().Power(-5, -2));
        System.out.println(new Solution().Power(0, -2));

        System.out.println("3^4 = " + new Solution().powerWithExponent(3, 4));

        System.out.println(new Solution().Power2(5, -2));

    }
}