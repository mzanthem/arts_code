package io.github.mzanthem.leetcodetraining.base;

import java.util.List;

/**
 * @ClassName ListNodeUtil
 * @Description help to generate a listNode
 * @Author zan.ma
 * @Date 2019/10/7 4:51 PM
 * @Version 1.0
 **/
public class ListNodeUtil {

    // 增
    /**
     * 生成一个单链表
     * [1,1,2,4] -> [1 -> 1 -> 2 -> 4]
     **/
    public static ListNode build(int[] array) {
        int size = array.length;
        if (size == 0) {
            throw new NullPointerException();
        }

        ListNode listNode = new ListNode(array[0]);

        for(int i = 1; i < array.length; i++) {
            listNode = append(listNode, array[i]);
        }

        return listNode;
    }

    /**
     * 克隆一个链表
     **/
    public static ListNode clone (ListNode listNode) {
        ListNode clone = new ListNode(listNode.val);

        // 游标
        ListNode cursor = listNode.next; 
        ListNode cloneCursor = clone;

        while(cursor != null) {
            cloneCursor.next = cursor;
            cloneCursor = cloneCursor.next;

            // 迭代
            cursor = cursor.next;
        }

        return clone;
    }

    // 查
    /**
     * 查找最后一个节点
     **/
    public static ListNode getEnd(ListNode listNode){
        ListNode end = new ListNode(listNode.val);

        ListNode nextNode = listNode.next;
        while (nextNode != null) {
            if (nextNode.next == null) {
                end = nextNode;
                break;
            } else {
                nextNode = nextNode.next;
            }

        }
        return end;
    }

    /**
     * 打印
     **/
    public static void print(ListNode listNode) {


        StringBuilder stringBuilder = new StringBuilder();
        // 打印队首
        stringBuilder.append("[").append(listNode.val);

        // 下一节点
        ListNode nextNode = listNode.next;
        // 遍历节点
        while (nextNode != null) {
            stringBuilder.append(" -> ").append(nextNode.val);
            nextNode = nextNode.next;
        }
        // 打印结束
        stringBuilder.append("]");

        System.out.println(stringBuilder.toString());
    }

    // 增
    /**
     * 添加一个节点到队尾
     **/
    public static ListNode append(ListNode listNode, int x) {
        ListNode end = new ListNode(x);

        ListNode nextNode = listNode;

        // 遍历
        while (nextNode != null) {
            // 检测下一个是否为null
            if (nextNode.next == null) {
                // null 则把end添加到队尾,并退出循环
                nextNode.next = end;
                break;
            } else {
                nextNode = nextNode.next;
            }

        }


        return listNode;
    }

    /**
     * 添加一个节点到队首
     **/
    public static ListNode addFirst(ListNode listNode, int x) {
        ListNode first = new ListNode(x);
        first.next = listNode;

        return first;
    }




    public static void main(String[] args) {

        System.out.println("----------- build ------------");
        ListNode a = build(new int[]{1,1,2,4});
        print(a);

        System.out.println("----------- clone ------------");
        ListNode b = clone(a);
        print(b);

        print(a);

        System.out.println("----------- append ------------");

        ListNode l = new ListNode(1);
        print(l);

//        l.next = new ListNode(2);
        l = append(l, 2);
        print(l);

        System.out.println("----------- addFirst ------------");
        l = addFirst(l,0);
        print(l);

        l = append(l, 3);
        print(l);


        System.out.println("----------- getEnd ------------");
        ListNode e = getEnd(l);
        print(e);
        print(l);

    }
}