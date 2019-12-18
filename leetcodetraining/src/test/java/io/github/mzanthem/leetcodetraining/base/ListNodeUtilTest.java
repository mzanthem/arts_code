package io.github.mzanthem.leetcodetraining.base;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ListNodeUtilTest {

    ListNode listNode;
    int[] array;
    String result;

    @Before
    public void setUp() throws Exception {
        array = new int[]{1,2,3,4,5};
        listNode = ListNodeUtil.build(array);
        result = "[1 -> 2 -> 3 -> 4 -> 5]";

    }

    @After
    public void tearDown() throws Exception {
    }



    @Test
    public void convert() {

        ListNode la = ListNodeUtil.convert(3);
        String expectA = "[3]";
        assertEquals(expectA, ListNodeUtil.toString(la));

        ListNode lb = ListNodeUtil.convert(12345);
        String expectB = "[5 -> 4 -> 3 -> 2 -> 1]";
        assertEquals(expectB, ListNodeUtil.toString(lb));
    }

    @Test
    public void build() {
        int[] a = new int[] {1};
        ListNode la = ListNodeUtil.build(a);
        assertEquals("[1]", ListNodeUtil.toString(la));


        int[] b = new int[] {1,1};
        ListNode lb = ListNodeUtil.build(b);
        assertEquals("[1 -> 1]", ListNodeUtil.toString(lb));

        int[] c = new int[] {1,1,2,3,5};
        ListNode lc = ListNodeUtil.build(c);
        assertEquals("[1 -> 1 -> 2 -> 3 -> 5]", ListNodeUtil.toString(lc));
    }

    @Test
    public void testClone() {
        int[] a= new int[] {1,1,2};
        ListNode la = ListNodeUtil.build(a);
        assertEquals("[1 -> 1 -> 2]", ListNodeUtil.toString(la));

        System.out.println(la);
        ListNode la2 = ListNodeUtil.clone(la);
        System.out.println(la2);

        assertEquals("[1 -> 1 -> 2]", ListNodeUtil.toString(la2));
    }

    @Test
    public void getEnd() {
        ListNode e = ListNodeUtil.getEnd(listNode);
        ListNode expect = new ListNode(5);

        assertEquals(ListNodeUtil.toString(expect), ListNodeUtil.toString(e));

        assertEquals(result, ListNodeUtil.toString(listNode));
    }

    @Test
    public void toStringTest() {
        String expect= "[1 -> 1 -> 2 -> 3 -> 5]";
        ListNode listNode = ListNodeUtil.build(new int[] {1, 1, 2, 3, 5});
        assertEquals(expect, ListNodeUtil.toString(listNode));
    }

    @Test
    public void toNumber() {
        int number = 12345;
        ListNode listNode = ListNodeUtil.build(new int[] {5, 4, 3, 2, 1});
        assertEquals(number, ListNodeUtil.toNumber(listNode));
    }

    @Test
    public void print() {
    }

    @Test
    public void append() {
        int[] a= new int[] {1,1,2};
        ListNode la = ListNodeUtil.build(a);
        assertEquals("[1 -> 1 -> 2]", ListNodeUtil.toString(la));

        ListNodeUtil.append(la, 3);
        assertEquals("[1 -> 1 -> 2 -> 3]", ListNodeUtil.toString(la));


        ListNodeUtil.append(ListNodeUtil.append(la, 4), 5);
        assertEquals("[1 -> 1 -> 2 -> 3 -> 4 -> 5]", ListNodeUtil.toString(la));


    }

    @Test
    public void addFirst() {
        int[] a= new int[] {1,1,2};
        ListNode la = ListNodeUtil.build(a);
        assertEquals("[1 -> 1 -> 2]", ListNodeUtil.toString(la));

        ListNode la2 = ListNodeUtil.addFirst(la,0);
        assertEquals("[0 -> 1 -> 1 -> 2]", ListNodeUtil.toString(la2));

    }

    @Test
    public void deleteTail() {

        int[] a= new int[] {1};
        ListNode la = ListNodeUtil.build(a);
        assertEquals("[1]", ListNodeUtil.toString(la));

        try {
            ListNodeUtil.deleteTail(la);
        } catch (Exception e) {
            assertTrue(e instanceof IndexOutOfBoundsException);
        }

        int[] b = new int[] {1,2};
        ListNode lb = ListNodeUtil.build(b);
        assertEquals("[1 -> 2]", ListNodeUtil.toString(lb));

        ListNodeUtil.deleteTail(lb);
        assertEquals("[1]", ListNodeUtil.toString(lb));

    }
}