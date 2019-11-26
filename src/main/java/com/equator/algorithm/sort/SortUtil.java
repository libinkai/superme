package com.equator.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author: Equator
 * @Date: 2019/11/26 19:34
 **/

public class SortUtil {
    /**
     * 打印数组
     *
     * @param array
     */
    public static void print(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static void print(String msg, int[] array) {
        System.out.println(msg + " : " + Arrays.toString(array));
    }

    /**
     * 交换数组两个指定位置的数据
     *
     * @param array
     * @param i
     * @param j
     */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 生成一个随机数组
     *
     * @param size
     * @param bound
     * @return
     */
    public static int[] generateArray(int size, int bound) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(bound);
        }
        return array;
    }

    /**
     * 计算排序的耗时
     * @param sortable
     * @param array
     * @return
     */
    public static long monitor(Sortable sortable, int[] array) {
        long start = System.currentTimeMillis();
        sortable.sort(array);
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static void main(String[] args) {
        print(generateArray(100, 1000));
    }
}
