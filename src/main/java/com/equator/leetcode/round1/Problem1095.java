package com.equator.leetcode.round1;

/**
 * @Author: Equator
 * @Date: 2020/4/29 11:04
 **/

public class Problem1095 {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int topIdx = findTopIdx(mountainArr, 0, mountainArr.length() - 1);
        int leftIdx = findFromArr(mountainArr, target, 0, topIdx);
        if (leftIdx != -1) {
            return leftIdx;
        }
        return findFromDescArr(mountainArr, target, topIdx + 1, mountainArr.length() - 1);
    }

    private int findTopIdx(MountainArray array, int low, int high) {
        while (low < high) {
            int mid = (low + high) / 2;
            if (array.get(mid) < array.get(mid + 1)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private int findFromArr(MountainArray array, int target, int low, int high) {
        while (low < high) {
            int mid = (low + high) / 2;
            if (array.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        if (array.get(low) == target) {
            return low;
        }
        return -1;
    }

    private int findFromDescArr(MountainArray array, int target, int low, int high) {
        while (low < high) {
            int mid = (low + high) / 2;
            if (array.get(mid) > target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        if (array.get(low) == target) {
            return low;
        }
        return -1;
    }
}
