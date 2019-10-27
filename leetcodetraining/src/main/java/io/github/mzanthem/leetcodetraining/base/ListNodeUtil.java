package io.github.mzanthem.leetcodetraining.base;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @ClassName ListNodeUtil
 * @Description help to generate a listNode
 * @Author zan.ma
 * @Date 2019/10/7 4:51 PM
 * @Version 1.0
 **/
@Slf4j
public class ListNodeUtil {

    // 增
    /**
     * 整数，逆序存储
     * 123 -> [3,2,1] -> [3 -> 2 -> 1]
     **/
    public static ListNode convert(int number) {


        String s = String.valueOf(number);
        int length = s.length();

        if (length == 0) {
            throw new IndexOutOfBoundsException();
        }

        // 获取最后位
        char last = s.charAt(length - 1);
        ListNode listNode = new ListNode(Integer.parseInt(String.valueOf(last)));

        // 大于一位
        if (length > 1) {
            ListNode cursour = listNode;
            // 逆序排列
            for (int i = length - 2 ; i >= 0; i--) {
                char c = s.charAt(i);
                ListNode node = new ListNode(Integer.parseInt(String.valueOf(c)));
                cursour.next = node;

                cursour = cursour.next;
            }
        }

        return listNode;
    }



    /**
     * 根据数组, [正序]生成一个单链表
     * [1,1,2,4] -> [1 -> 1 -> 2 -> 4]
     **/
    public static ListNode build(int[] array) {
        int size = array.length;
        if (size == 0) {
            throw new NullPointerException();
        }

        ListNode listNode = new ListNode(array[0]);

        ListNode cursor = listNode;
        for(int i = 1; i < array.length; i++) {
            ListNode node = new ListNode(array[i]);
            cursor.next = node;
            cursor = cursor.next;

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
     * 导出
     * -->打印
     **/
    public static String toString(ListNode listNode) {
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

        log.info(stringBuilder.toString());
        return stringBuilder.toString();
    }

    /**
     * 逆序产生整数
     * [1->2->3] ==>> "123" ==>> 321
     * 非0
     * TODO
     **/
    public static int toNumber(ListNode listNode) {
        StringBuilder stringBuilder = new StringBuilder();
        // 打印队首
        stringBuilder.append(listNode.val);

        ListNode nextNode = listNode.next;
        // 遍历节点
        while (nextNode != null) {
            stringBuilder.append(nextNode.val);
            nextNode = nextNode.next;
        }

        String str = stringBuilder.reverse().toString();
        // reverse
        log.info(str);

        Integer number = Integer.parseInt(str);
        return number;
    }

    /**
     * 打印
     **/
    public static void print(ListNode listNode) {

        System.out.println(toString(listNode));
    }

    // 增
    /**
     * 添加一个节点到队尾
     * 可以链式添加
     **/
    public static ListNode append(ListNode listNode, int x) {
        ListNode end = new ListNode(x);

        ListNode cursorNode = listNode;

        // 遍历
        while (cursorNode != null) {
            // 检测下一个是否为null
            if (cursorNode.next == null) {
                // null 则把end添加到队尾,并退出循环
                cursorNode.next = end;
                break;
            } else {
                cursorNode = cursorNode.next;
            }

        }


        return listNode;
    }

    /**
     * 添加一个节点到队首
     * 因为是单向链表，只能返回一个新的链表
     **/
    public static ListNode addFirst(ListNode listNode, int x) {
        ListNode first = new ListNode(x);
        ListNode clone = clone(listNode);

        first.next = clone;

        return first;
    }

    /**
     * 删除末尾元素
     **/
    public static ListNode deleteTail(ListNode listNode) {

        ListNode cursorNode = listNode;

        if (cursorNode.next == null) {
            throw new IndexOutOfBoundsException("Only Root Element!");
        }

        // 遍历
        while (cursorNode != null) {
            // 检测下一个的下一个是否为null()
            if (cursorNode.next.next == null) {
                // null 则把end添加到队尾,并退出循环
                cursorNode.next = null;
                break;
            } else {
                cursorNode = cursorNode.next;
            }

        }


        return listNode;
    }



}