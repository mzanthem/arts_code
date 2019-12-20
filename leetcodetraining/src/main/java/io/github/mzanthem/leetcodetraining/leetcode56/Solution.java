package io.github.mzanthem.leetcodetraining.leetcode56;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * Merge Intervals
 *
 * 2014.2.26 21:28
 *
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 *
 * Solution:
 *
 * 　　The problem didn't guarantee that the set of intervals is sorted, so a sort() has to be performed first.
 *
 * 　　After sorting the set, the intervals are arranged first in the order of their x-coordinates, and y-coordinates later.
 *
 * 　　When scanning the intervals, there will be three possibilities:
 *
 * 　　　　1. the next interval is contained by the current one, ignore the next one and move on
 *
 * 　　　　2. the next interval overlaps with the current one, merge them and move on
 *
 * 　　　　3. the next interval is separated from the current one, move the "current" iterator to the next one
 *
 * 　　Total time complexity is O(n * log(n)). Space complexity is O(1).
 *
 * *******************************************************************************************
 *
 * 区间合并，如果两个区间有重叠那么合并成一个区间
 *
 * 问题关键：
 * 对区间按照一个元素排序，如果前区间的end小于后面区间的start，那么这个区间是不能被合并的。
 * 建立自己的比较函数，区间的大小。
 * 如果end > start，那么说明有重叠，但是还要比较两个区间的end哪个更大
 *
 */
public class Solution {


    public static int[][] merge(int[][] intervals) {
        LinkedList<int[]> res = new LinkedList<>();
        if (intervals == null || intervals.length == 0) {
            return res.toArray(new int[0][]);
        }





        // 基本排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });


        //// 1.根据第一个元素排序
        //Arrays.sort(intervals, (int[] o1, int[] o2) -> {
        //    return o1[0] - o2[0];
        //});

        //3.
        //Arrays.sort(intervals, (a, b) -> a[0] - b[0]);


        for (int i = 0; i < intervals.length; i++) {
            // 如果res最后一个元素[a,b]，b小于当前[c, d]的第一个c，则不合并,
            if (res.isEmpty() || res.getLast()[1] < intervals[i][0]) {
                res.add(intervals[i]);
            } else {
                // 合并区间[a,b]+[c,d]-->[a, max(b,d)]
                res.getLast()[1] = Math.max(res.getLast()[1], intervals[i][1]);
            }
        }

        //为什么放0，0长度？可以看下源码就知道了
        return res.toArray(new int[0][0]);
    }


    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        int[][] res = merge(intervals);

        for (int i = 0; i< res.length; i++) {
            System.out.print(" [");
            for(int j = 0; j< res[i].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.print("] ");
            System.out.println();
        }
    }
}
