package com.sjt.linkedlist;

/**
 * @author sujuntao
 * @date 2022/6/8
 */
public class ListNode {

    // 数据
    int val;
    // 下一个节点的引用
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }


    // 数组 转化成 链表
    public static ListNode arrayToListNode(int[] arr) {
        if (arr.length == 0) return null;

        // 生成链表的根节点
        ListNode root = new ListNode(arr[0]);

        ListNode pre = root;
        for (int i = 1; i < arr.length; i++) {
            ListNode node = new ListNode(arr[i]);
            // 创建链接关系  将前一个节点的next设置为当前节点
            pre.next = node;
            // 更新pre为当前节点  下一个要处理的节点
            pre = node;
        }

        return root;
    }


    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) {
                System.out.print("->");
            }
            head = head.next;
        }
    }

    // pos 代表 尾节点指向 链表中某个节点的索引位置 (环的入口)
    public static void toCycle(ListNode node, int pos) {
        // 遍历  通过pos找到 入口对应的节点  记录下来
        // 遍历到尾节点时   设置为其next引用

        // 记录遍历的位置
        int cnt = 0;
        ListNode cycleNode = null;
        while (true) {
            // 判断是否是环的入口节点
            if (cnt == pos) {
                cycleNode = node;
            }

            // 判断是否是尾节点
            if (node.next == null) {
                node.next = cycleNode;
                return;
            }

            node = node.next;
            cnt++;
        }

    }
}
