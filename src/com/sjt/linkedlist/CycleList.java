package com.sjt.linkedlist;

/**
 * @author sujuntao
 * @date 2022/6/8
 */
public class CycleList {

    public static void main(String[] args) {
        int[] arr = {3, 2, 0, -4};
        ListNode node = ListNode.arrayToListNode(arr);
        ListNode.toCycle(node, 1);

        ListNode result = detectCycle(node);
        System.out.println(result.val);
    }


    public static boolean hasCycle(ListNode head) {
        // 链表本身不能为空  或者只有一个节点  也是无环的
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (true) {
            // 没有环时  fast会先走到链表尾部
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
            if(slow != null) {
                System.out.print("slow走到" + slow.val);
            }
            if(fast != null) {
                System.out.println(",fast走到" + fast.val);
            }
            if (slow == fast) return true;
        }
    }


    public static ListNode detectCycle(ListNode head) {
        // 链表本身不能为空  或者只有一个节点  也是无环的
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (true) {
            // 没有环时  fast会先走到链表尾部
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            if(slow != null) {
                System.out.print("slow走到" + slow.val);
            }
            if(fast != null) {
                System.out.println(",fast走到" + fast.val);
            }
            if (slow == fast) break;
        }

        // 第一次相遇后，让fast重新指向头结点head,slow保持不变。
        // fast和slow按照相同速度移动，第二次相遇后，此节点即为入口节点。
        fast = head;
        while (true){
            slow = slow.next;
            fast = fast.next;
            if(slow != null) {
                System.out.print("slow走到" + slow.val);
            }
            if(fast != null) {
                System.out.println(",fast走到" + fast.val);
            }
            if(slow == fast) return slow;
        }
    }
}
