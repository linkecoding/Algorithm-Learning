/**
 * 题目描述
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * 解题思路
 * 使用一个新的数组,在前面正向存储奇数,从尾部开始逆向存储偶数,然后再开始拷贝回原数组
 */
public class Solution {
    public void reOrderArray(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        //正向存奇数,逆向存偶数
        int[] arr = new int[array.length];
        //奇数下标
        int oddIndex = 0;
        //偶数下标
        int enevIndex = array.length - 1;

        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 0x01) == 1){
                //奇数
                arr[oddIndex++] = array[i];
            }else{
                //偶数
                arr[enevIndex--] = array[i];
            }
        }

        //向原数组中放入奇数
        for (int i = 0; i < oddIndex; i++) {
            array[i] = arr[i];
        }

        //向原数组中放入偶数,但是注意在存储时是逆向存储的,所以应该从尾部开始读取
        enevIndex = array.length - 1;
        for (int i = oddIndex; i < array.length; i++) {
            array[i] = arr[enevIndex--];
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        new Solution().reOrderArray(array);
        for(int i : array){
            System.out.println(i);
        }
    }
}