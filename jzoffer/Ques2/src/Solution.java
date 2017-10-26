/**
 * 题目描述
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * 解题思路
 * 遍历字符串找到ASCII码为32(空格的ASCII码)时使用replace方法替换
 */

public class Solution {
    public String replaceSpace(StringBuffer str) {
        if (str == null){
            return null;
        }
        if (str.length() == 0){
            return str.toString();
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 32){
                str.replace(i, i+1, "%20");
            }
        }
        return str.toString();
    }
//
//    public static void main(String[] args) {
//        System.out.println(new Solution().replaceSpace(new StringBuffer("We Are Happy")));
//    }
}