/**
 * 题目描述
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 * 解题思路
 * 最后一行的数据是这一列最大的
 * 比该列最后一个数据还大，那就在下一列找
 * 比该列最后一个数据小，就在该列从下往上扫描
 * 即从左下角开始扫描
 */
public class Solution {
    public boolean Find(int target, int[][] array) {
        //行数
        int line = array.length - 1;
        //列数
        int row = 0;
        //注意：列数是array[0].length
        while (line >= 0 && row < array[0].length) {
            if (array[line][row] == target) {
                //找到
                return true;
            } else if (array[line][row] < target) {
                //在下一列找
                row++;
            } else {
                //在该列向上找
                line--;
            }
        }
        //未找到
        return false;
    }
}