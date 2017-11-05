/**
 * 题目描述
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * <p>
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
public class Solution {
    //方法一
    public int minNumberInRotateArray(int[] array) {
        //数组长度为0
        if (array == null || array.length == 0) {
            return 0;
        }
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    //方法二
    public int minNumberInRotateArray2(int[] array) {
        //数组长度为0
        if (array == null || array.length == 0) {
            return 0;
        }
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return array[i + 1];
            }
        }
        return array[0];
    }

    //方法三
    public int minNumberInRotateArray3(int[] array) {
        //数组长度为0
        if (array == null || array.length == 0) {
            return 0;
        }
        int index1 = 0;
        int index2 = array.length - 1;
        //这样赋值可以保证原数组是一个特殊的旋转数组的情况
        int midIndex = index1;
        while (array[index1] >= array[index2]) {
            if (index2 - index1 == 1) {
                //当两个下标相差为1时,后一个下标即为要找的最小值
                midIndex = index2;
                break;
            }
            //此处是为了处理[1 0 1 1 1]这种array[index1] = array[index2] = array[midIndex]的情况
            if (array[index1] == array[index2]
                    && array[index1] == array[midIndex]){
                return minInOrder(array, index1, index2);
            }

            //midIndex = (index1 + index2) / 2 (这样写可以防止相加之和超出int范围)
            midIndex = index1 + (index2 - index1) / 2;
            if (array[midIndex] >= array[index1]) {
                //此时中间值在前面的递增数组中
                index1 = midIndex;
            } else if (array[midIndex] <= array[index2]){
                //此时中间值在后面的递增数组中
                index2 = midIndex;
            }
        }
        return array[midIndex];
    }

    //遍历查找指定范围内最小的
    private int minInOrder(int[] array, int index1, int index2) {
        int result = array[index1];
        for (int i = index1 + 1; i <= index2; i++) {
            if (array[i] < result){
                result = array[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minNumberInRotateArray2(new int[]{3, 4, 5, 1, 2}));
        System.out.println(new Solution().minNumberInRotateArray3(new int[]{3, 4, 5, 1, 2}));
        System.out.println(new Solution().minNumberInRotateArray3(new int[]{1, 2, 3, 4, 5}));
        System.out.println(new Solution().minNumberInRotateArray3(new int[]{1, 0, 1, 1, 1}));
    }
}