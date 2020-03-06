package org.review;

import com.equator.algorithm.sort.SortUtil;

import java.util.Arrays;

/**
 * @Author: Equator
 * @Date: 2020/3/6 15:12
 **/

public class HeapSort {
    public void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int len = nums.length, lastIdx = nums.length - 1;
        for (int i = (lastIdx + 1) / 2; i >= 0; i--) {
            heapify(nums, i, len);
        }
        for (int i = lastIdx; i >= 0; i--) {
            SortUtil.swap(nums, 0, i);
            heapify(nums, 0, i);
        }
    }

    private void heapify(int[] nums, int idx, int len) {
        if (idx >= len) {
            return;
        }
        int leftChildIdx = 2 * idx + 1;
        int rightChildIdx = 2 * idx + 2;
        int maxIdx = idx;
        if (leftChildIdx < len && nums[leftChildIdx] > nums[maxIdx]) {
            maxIdx = leftChildIdx;
        }
        if (rightChildIdx < len && nums[rightChildIdx] > nums[maxIdx]) {
            maxIdx = rightChildIdx;
        }
        if (maxIdx != idx) {
            SortUtil.swap(nums, idx, maxIdx);
            heapify(nums, maxIdx, len);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 6, 8, 4, 5, 6, 3, 1, 2, 5};
        new HeapSort().sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
