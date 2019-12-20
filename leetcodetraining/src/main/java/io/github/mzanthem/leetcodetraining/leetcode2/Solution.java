package io.github.mzanthem.leetcodetraining.leetcode2;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author zan.ma
 * @Date 2019/10/7 4:33 PM
 * @Version 1.0
 *
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。
 * 将两数相加返回一个新的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */

import io.github.mzanthem.leetcodetraining.base.ListNode;
import io.github.mzanthem.leetcodetraining.base.ListNodeUtil;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummyHead = new ListNode(0); // 存储表头(最低位)
        ListNode p = l1;
        ListNode q = l2;
        ListNode curr = dummyHead;

        int carry = 0; //进位

        while (p != null || q != null) {
            int x = p!=null? p.val : 0;  // x
            int y = q!=null? q.val : 0;  // y
            int sum = carry + x + y; // 加上上次的进位
            carry = sum/10; // 是否进位

            // 形成新的节点

            curr.next = new ListNode(sum % 10); // 去除掉进位后的值

            // 右移(向高位)
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;

        }
        if (carry > 0) {
            curr.next = new ListNode(carry); // 最高位
        }
        return dummyHead.next; //

    }


    public static void main(String[] args) {
        ListNode l1 = ListNodeUtil.build(new int[]{2, 4, 3});
        ListNode l2 = ListNodeUtil.build(new int[]{5, 6, 4});

        ListNode res = addTwoNumbers(l1, l2);

        ListNodeUtil.print(res);
    }
}