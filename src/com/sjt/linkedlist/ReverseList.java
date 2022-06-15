package com.sjt.linkedlist;

/**
 *  ###### 反转链表
 *
 * https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * >反转链表
 * >反转一个单链表。
 * >
 * >示例:
 * >
 * >输入: 1->2->3->4->5->NULL
 * >输出: 5->4->3->2->1->NULL
 * >
 * >进阶:
 * >你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * @author sujuntao
 */
public class ReverseList {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        ListNode head = ListNode.arrayToListNode(arr);
        ListNode result = reverseList(head);

        ListNode.print(result);
    }

    private static ListNode reverseList(ListNode head) {

        // 记录前置节点  和当前节点
        ListNode pre = null;
        ListNode cur = head;

        // 不断移动cur节点  向后遍历  同时更改其next
        // 当cur 为空时  遍历完成
        while (cur != null) {
            ListNode tmp = cur.next;
            // 更改指向
            cur.next = pre;
            if (cur != null && pre != null) {
                System.out.println("让" + cur.val + "的next指向" + pre.val);
            }
            // pre和cur向后移动
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

}
