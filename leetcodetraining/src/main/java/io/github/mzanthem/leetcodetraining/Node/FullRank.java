package io.github.mzanthem.leetcodetraining.Node;

import java.util.ArrayList;

/**
 * 全排列
 */
public class FullRank {


    private static String[] getLeftArray(String[] array, int index) {
        int size = array.length;
        String[] array2 = new String[size - 1];
        int j = 0;
        for (int i = 0; i < size; i++) {
            String e = array[i];
            if (i == index) {
                continue;
            }
            array2[j++] = e;
        }
        return array2;
    }


    /**
     *
     * @param arr       元素数组
     * @param k         开始的位置
     * @param length    长度
     * @param result
     */
    public static void perm(String[] arr, int k, int length, ArrayList<String[]> result) {

        //只有一个数，则排列确定，将该数组保存在集合中
        if (k == length - 1) {
            String[] b = arr.clone();
            result.add(b);

        } else {

            for (int i = 0; i < length; i++) {
                if (IsSwap(arr,k,i)) {
                    swap(arr, k, i); // 交换k与i
                    perm(arr, k + 1, length,result);
                    swap(arr, k, i); // 恢复
               }

            }

        }

    }

    private static boolean IsSwap(Object[] arr, int begin, int end) {
        for (int i=begin;i<end;i++)
            if (arr[i]==arr[end])return false;
        return true;
    }

    private static void swap(Object[] arr, int k, int i) {
        Object temp;
        temp = arr[k];
        arr[k] = arr[i];
        arr[i] = temp;
    }




    public static void main(String[] args) {
        String[] a = new String[] {"A", "B", "C"};
        //String[] b = getLeftArray(a, 1);
        //System.out.println(Arrays.asList(b));

        ArrayList<String[]> list =  new ArrayList<String[]>();

        // 全排序
        perm(a, 0, a.length, list);

        //输出集合中的数组元素
        for (String[] o:list){
            for (int i=0;i<o.length;i++){
                System.out.print(o[i]+" ");
            }
            System.out.println();
        }

    }


}
