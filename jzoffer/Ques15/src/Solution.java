/**
 * public class ListNode {
 *     int val;
 *     ListNode next = null;
 *     ListNode(int val) {
 *         this.val = val;
 *     }
 * }
 *
 * 题目描述
 * 输入两个单调递增的链表，输出两个链表合成后的链表，
 * 当然我们需要合成后的链表满足单调不减规则。
 *
 * 解题思路
 * 方法一:该题目首先注意对空链表异常情况的处理
 *       然后用head节点作为最终链表的头节点(该节点不要变化,最终返回)
 *       使用phead作为移动节点,使用head1和head2分别指向需要合并的两个链表当前需要处理的节点,
 *       依次比较两个链表节点的值,直到有一个指针的next为空,此时需要判断是否是有一个链表处理完成还有一个链表的节点没有处理完成
 *       然后将没有处理完成的链表剩余节点接在最终链表的最后面即可
 *
 * 方法二:我们可以使用递归
 *       当我们链表一的头节点的值小于链表二的头节点的值,那么合并之后的链表头节点就是链表一的头节点,反之亦然
 *       当这一步完成后,头节点的下一个节点就会成为新的头节点,我们可以继续递归处理,将每次比较产生的较小的头节点接在合并链表之后即可
 *       当其中一个较短的链表已经比较完成时,我们就可将较长链表的剩余部分接在合并链表的最后面即可
 */
public class Solution {

    //方法一
    public ListNode Merge(ListNode list1, ListNode list2) {
        //异常情况判断
        if (list1 == null && list2 == null){
            return null;
        }else if (list1 != null && list2 == null){
            return list1;
        }else if (list1 == null){
            return list2;
        }
        ListNode head1 = list1;
        ListNode head2 = list2;
        //最终合成的链表的头结点(最终返回)
        ListNode head = null;
        if (head1.val <= head2.val){
            //head1作为开始节点
            head = head1;
            head1 = head1.next;
        }else{
            //head2作为开始节点
            head = head2;
            head2 = head2.next;
        }
        //负责移动的指针,不断在其后面添加合适的节点
        ListNode phead = head;
        while (head1 != null && head2 != null){
            if (head1.val <= head2.val){
                phead.next = head1;
                head1 = head1.next;
            }else{
                phead.next = head2;
                head2 = head2.next;
            }
            phead = phead.next;
        }

        //处理其中一个链表已经遍历完成,但还有链表没有遍历完成的情况
        if (head1 != null){
            phead.next = head1;
        }
        if (head2 != null){
            phead.next = head2;
        }
        return head;
    }

    //方法二
    public ListNode Merge2(ListNode list1, ListNode list2) {
        if (list1 == null){
            return list2;
        }else if (list2 == null){
            return list1;
        }
        ListNode mergeHead = null;
        if (list1.val < list2.val){
            mergeHead = list1;
            mergeHead.next = Merge2(list1.next, list2);
        }else{
            mergeHead = list2;
            mergeHead.next = Merge2(list1, list2.next);
        }
        return mergeHead;
    }
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode p1 = head1;
        ListNode p2 = head2;
        for (int i = 3; i <= 5; i += 2) {
            p1.next = new ListNode(i);
            p1 = p1.next;
        }

        for (int i = 4; i <= 6; i += 2) {
            p2.next = new ListNode(i);
            p2 = p2.next;
        }

        ListNode head = new Solution().Merge(head1, head2);
        while (head != null){
            System.out.print(head.val + "  ");
            head = head.next;
        }
    }
}