package io.github.mzanthem.leetcodetraining.Node;

import io.github.mzanthem.leetcodetraining.base.ListNode;
import io.github.mzanthem.leetcodetraining.base.ListNodeUtil;

public class ReverseList {



    // 链表翻转 非递归
    public static ListNode reverseChainNotRecursive(ListNode head) {
        // 只有头结点
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = head;


        ListNode cur = head.next;
        ListNode temp;
        pre.next = null; // 把head断开

        while (cur != null) {

            // 先存放next节点
            temp = cur.next;

            // 修改next->pre
            cur.next = pre;

            pre = cur; // pre右移


            cur = temp; // cur右移指向原先的next

        }

        return pre;
    }


    // 链表翻转 递归
    public static ListNode reverseChainRecursive(ListNode head) {

        System.out.println("before "+ head);
        if (head == null || head.next == null) {
            return head;
        }
        // 递归一直找到尾
        ListNode headOfReverseChain = reverseChainRecursive(head.next);
        head.next.next = head; // 倒数第二个 指向head
        head.next = null;       // head 指向null
        System.out.println("after "+ headOfReverseChain);
        return headOfReverseChain;

    }


    public static void main(String[] args) {
        ListNode list = ListNodeUtil.build(new int[] {1, 1, 2, 3, 5});
        ListNodeUtil.print(list);

        ListNode list2 = reverseChainNotRecursive(list);
        ListNodeUtil.print(list2);

        System.out.println("------------------------------------");
        ListNode list3 = reverseChainRecursive(list2);
        ListNodeUtil.print(list3);

    }
}
