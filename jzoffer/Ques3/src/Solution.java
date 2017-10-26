/**
* public class ListNode {
*     int val;
*     ListNode next = null;
*     ListNode(int val) {
*         this.val = val;
*     }
* }
* 题目描述
* 输入一个链表，从尾到头打印链表每个节点的值。
*
* 解题思路
* 方法一: 存储在List里面,再逆置list
* 方法二: 使用栈存储链表节点数据
* 方法二: 直接递归输出链表
*
*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Solution {
    //方法一: 逆置list
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        while (listNode != null){
            list.add(listNode.val);
            listNode = listNode.next;
        }
        //逆置list
        Collections.reverse(list);
        return list;
    }

    //方法二:使用栈
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> list = new ArrayList<>();
        //出栈
        while (!stack.empty()){
            list.add(stack.pop());
        }
        return list;
    }

    //方法三:递归输出
    public ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode p = listNode;
        if (p != null){
            if (p.next != null){
                list = printListFromTailToHead3(p.next);
            }

            list.add(p.val);
        }
        return list;
    }
}