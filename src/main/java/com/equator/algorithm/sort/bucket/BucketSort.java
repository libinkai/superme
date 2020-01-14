package com.equator.algorithm.sort.bucket;

import com.equator.algorithm.sort.SortUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * @Author: Equator
 * @Date: 2019/12/2 10:41
 **/

public class BucketSort {
    public static double[] sort(double[] array) {
        double max = array[0], min = array[0];
        int len = array.length;
        // 找到待排序数组的最大值与最小值
        for (int i = 0; i < len; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        // 计算跨度，创建统计数组
        double span = max - min;
        // 初始化桶
        int bucketNumber = array.length;
        ArrayList<LinkedList<Double>> bucketList = new ArrayList<>(bucketNumber);
        for (int i = 0; i < bucketNumber; i++) {
            bucketList.add(new LinkedList<>());
        }
        // 装桶
        for (int i = 0; i < len; i++) {
            // (array[i] - min) * ((bucketNumber - 1) / span)
            int index = (int) ((array[i] - min) * (bucketNumber - 1) / span);
            bucketList.get(index).add(array[i]);
        }
        // 对每一个桶进行排序
        for (int i = 0; i < bucketNumber; i++) {
            Collections.sort(bucketList.get(i));
        }
        // 输出到结果数组
        double[] resultArray = new double[len];
        int i = 0;
        for (LinkedList<Double> bucket : bucketList){
            for (double el : bucket) {
                resultArray[i++] = el;
            }
        }
        return resultArray;
    }

    public static void main(String[] args) {
        double[] array = SortUtil.generateDoubleArray(100000, 1000);
        SortUtil.print("排序前", array);
        long start = System.currentTimeMillis();
        array = sort(array);
        long end = System.currentTimeMillis();
        SortUtil.print("排序后", array);
        System.out.println("耗时：" + (end - start));
    }
}
