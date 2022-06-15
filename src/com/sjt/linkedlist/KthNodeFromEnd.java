package com.sjt.linkedlist;

/**
 *  ###### 链表中倒数第k个节点
 *
 * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 *
 * >剑指 Offer 22. 链表中倒数第k个节点
 * >输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 * >
 * >示例：
 * >
 * >给定一个链表: 1->2->3->4->5, 和 k = 2.
 * >
 * >返回链表 4->5.
 * @author sujuntao
 */
public class KthNodeFromEnd {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6};
        ListNode head = ListNode.arrayToListNode(arr);
        ListNode node = getKthFromEnd1(head, 3);
        System.out.println(node.val);

        ListNode.print(node);

    }

    public static ListNode getKthFromEnd(ListNode head, int k) {

        int n = 0;
        // 先求出链表总长度
        ListNode tmp = head;
        while (tmp.next != null) {
            n++;
            tmp = tmp.next;
        }

        // 再次遍历  找到第n-k+1个节点
        tmp = head;
        for (int i = 0; i < n - k + 1; i++) {
            tmp = tmp.next;
        }

        return tmp;
    }

    public static ListNode getKthFromEnd1(ListNode head, int k) {
        // 快慢指针
        ListNode slow = head;
        ListNode fast = head;
        // 正数第k个节点
        for (int i = 1; i < k; i++) {
            fast = fast.next;
        }
        System.out.println(fast.val);

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            System.out.println("slow移动到" + slow.val + ",fast移动到" + fast.val);
        }
        return slow;
    }
}
