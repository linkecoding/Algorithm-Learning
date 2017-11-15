/**
 *
 * public class ListNode {
 *    int val;
 *    ListNode next = null;
 *    ListNode(int val) {
 *        this.val = val;
 *    }
 * }
 *
 * 题目描述
 * 输入一个链表，输出该链表中倒数第k个结点。
 *
 * 解题思路
 * 这道题使用快慢指针来解决
 * 我们设置两个指针fast指针和slow指针刚开始都指向链表头结点
 * 然后我们先让fast指针先走k-1步
 * 最后我们让fast指针和slow指针同时走,当fast指针指向的节点指向最后一个节点时,
 * slow指针指向的正好是链表的倒数第k个节点
 *
 * 证明思路
 * 如果我们要找到倒数第k个节点,也就是正向的第n-k+1个节点
 * n-(n-k+1) = k-1就是说我们的最后一个节点和倒数第k个节点之相隔的节点是k-1个
 * 所以我们刚开始让fast指针先走k-1步,便于我们构造出这样一个间隔
 */
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null || k < 0){
            return null;
        }

        //快慢指针
        ListNode fastNode = head;
        ListNode slowNode = head;
        //快指针先走k步
        while (k-- > 1){
            if (fastNode.next != null){
                fastNode = fastNode.next;
            }else{
                //链表长度小于k
                return null;
            }
        }
        while (fastNode.next != null){
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        return slowNode;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode p = head;
        for (int i = 2; i < 6; i++) {
            ListNode listNode = new ListNode(i);
            p.next = listNode;
            p = p.next;
        }
        System.out.println(new Solution().FindKthToTail(head, 5).val);
        //输出链表
        while (head != null){
            System.out.println("value = " + head.val);
            head = head.next;
        }
    }
}