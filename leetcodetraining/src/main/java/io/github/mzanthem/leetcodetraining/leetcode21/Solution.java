package io.github.mzanthem.leetcodetraining.leetcode21;

import io.github.mzanthem.leetcodetraining.base.ListNode;
import io.github.mzanthem.leetcodetraining.base.ListNodeUtil;

/**
 * leetcode21
 * @ClassName Solution
 * @Description https://leetcode.com/problems/merge-two-sorted-lists/
 * @Author zan.ma
 * @Date 2019/10/7 4:28 PM
 * @Version 1.0
 *
 *
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 *
 * Example:
 *
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 *
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 **/
public class Solution {

    /**
     * 2个指针， 依次向后移动
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        // 先比较 首元素的大小,小的放首位
        if (l1.val > l2.val) {
            return mergeTwoLists(l2, l1);
        }

        //
        ListNode list = new ListNode(l1.val);
        ListNode cursor = list;


        ListNode p = l1.next;
        ListNode q = l2;

        // 只要还有一个列表有值
        while (p!=null || q!=null) {
            ListNode e = null; // 构造新的节点

            if (p != null && q == null) {
                // p 右移
                e = new ListNode(p.val);
                p = p.next;
            } else if (p == null && q != null) {
                // q 右移
                e = new ListNode(q.val);
                q = q.next;
            }
            else if (p != null && q!= null) {
                // 均不为null
                if (p.val <= q.val) {
                    // p 右移
                    e = new ListNode(p.val);
                    p = p.next;
                } else {
                    // q 右移
                    e = new ListNode(q.val);
                    q = q.next;
                }
            }

            // 节点拼接
            cursor.next = e;
            // 重置节点
            cursor = cursor.next; // 指针右移

        }



        return list;
    }



    public static void main(String[] args) {

        Solution solution = new Solution();

        ListNode list1 = ListNodeUtil.build(new int[]{1, 2, 4});
        ListNode list2 = ListNodeUtil.build(new int[]{1, 3, 5, 6});

        ListNode result = solution.mergeTwoLists(list1, list2);

        ListNodeUtil.print(result);

    }

}