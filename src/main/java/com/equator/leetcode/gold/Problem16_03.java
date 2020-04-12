package com.equator.leetcode.gold;

import org.junit.Test;

import java.util.Arrays;

/**
 * 先把线段看成直线，求出交点的坐标，再检测交点是否在两条线段之外
 *
 * @Author: Equator
 * @Date: 2020/4/12 16:24
 **/

public class Problem16_03 {
    private class Point {
        private double x, y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    // y = kx+b
    private class Line {
        private double k, b;

        public Line(Point start, Point end) {
            double deltaX = end.x - start.x;
            double deltaY = end.y - start.y;
            if (deltaX == 0) {
                k = Integer.MAX_VALUE;
                b = end.y;
            } else {
                k = deltaY / deltaX;
                b = end.y - k * end.x;
            }
        }
    }

    private void swap(Point a, Point b) {
        double tempX = a.x, tempY = a.y;
        a.x = b.x;
        a.y = b.y;
        b.x = tempX;
        b.y = tempY;
    }

    private boolean isBetween(double start, double midle, double end) {
        if (start > end) {
            return end <= midle && midle <= start;
        } else {
            return start <= midle && midle <= end;
        }
    }

    private boolean isBetween(Point start, Point middle, Point end) {
        return isBetween(start.x, middle.x, end.x) && isBetween(start.y, middle.y, end.y);
    }

    private Point[] checkAndConvertIntoPoint(int[] start1_, int[] end1_, int[] start2_, int[] end2_) {
        Point start1 = new Point(start1_[0], start1_[1]);
        Point end1 = new Point(end1_[0], end1_[1]);
        Point start2 = new Point(start2_[0], start2_[1]);
        Point end2 = new Point(end2_[0], end2_[1]);
        if (start1.x > end1.x) {
            swap(start1, end1);
        }
        if (start2.x > end2.x) {
            swap(start2, end2);
        }
        if (start1.x > start2.x) {
            swap(start1, start2);
            swap(end1, end2);
        }
        return new Point[]{start1, end1, start2, end2};
    }


    public double[] intersection(int[] start1_, int[] end1_, int[] start2_, int[] end2_) {
        Point[] points = checkAndConvertIntoPoint(start1_, end1_, start2_, end2_);
        Point start1 = points[0], end1 = points[1];
        Point start2 = points[2], end2 = points[3];
        Line line1 = new Line(start1, end1);
        Line line2 = new Line(start2, end2);
        double diff = 1e-6f;
        Point intersection;
        if (line1.k == Integer.MAX_VALUE || line2.k == Integer.MAX_VALUE) {
            // 情况 1：（特殊情况）两条直线有一条斜率为正无穷
            if (line1.k == Integer.MAX_VALUE && line2.k == Integer.MAX_VALUE) {
                // 这里 b 不是截距的意思，而是表示 x = a 这条线段
                if (Math.abs(line1.b - line2.b) <= diff && isBetween(start1, start2, end1)) {
                    return new double[]{start2.x, start2.y};
                } else if (Math.abs(start1.x - start2.x) > diff) {
                    return new double[0];
                } else {
                    if (start1_[1] > end1_[1]) {
                        swap(start1, end1);
                    }
                    if (start2_[1] > end2_[1]) {
                        swap(start2, end2);
                    }
                    if (start1.y > end2.y || start2.y > end1.y) {
                        return new double[0];
                    }
                    if (start1.y > start2.y) {
                        return new double[]{start1.x, start1.y};
                    } else {
                        return new double[]{start2.x, start2.y};
                    }
                }
            }
            if (line1.k == Integer.MAX_VALUE) {
                intersection = new Point(line1.b, line1.b * line2.k + line2.b);
            } else {
                intersection = new Point(line2.b, line2.b * line1.k + line1.b);
            }

        } else if (Math.abs(line1.k - line2.k) <= diff) {
            // 情况 2：（特殊情况）斜率相等的情况下，如果在 y 轴上的截距相等，就表示两条直线重合
            if (Math.abs(line1.b - line2.b) <= diff && isBetween(start1, start2, end1)) {
                return new double[]{start2.x, start2.y};
            }
            return new double[0];
        } else {
            // 情况 3：（一般情况）使用公式计算交点的坐标
            double x = (line2.b - line1.b) / (line1.k - line2.k);
            double y = x * line1.k + line1.b;
            intersection = new Point(x, y);
        }
        // 检测所在直线的交点是否在两条线段的横纵坐标范围之内
        if (isBetween(start1, intersection, end1) && isBetween(start2, intersection, end2)) {
            return new double[]{intersection.x, intersection.y};
        }
        return new double[0];
    }

    @Test
    public void testEqual() {
        Integer a = 3;
        Integer b = 3;
        System.out.println(a.equals(b));
        System.out.println(a == b);
        Integer c = -129;
        Integer d = -129;
        System.out.println(c.equals(d));
        System.out.println(c == d);
    }

    public static void main(String[] args) {
//        int[] start1 = new int[]{0, 3};
//        int[] end1 = new int[]{0, 6};
//        int[] start2 = new int[]{0, 1};
//        int[] end2 = new int[]{0, 5};
        int[] start1 = new int[]{0, 0};
        int[] end1 = new int[]{0, 1};
        int[] start2 = new int[]{1, 0};
        int[] end2 = new int[]{1, 1};
        System.out.println(Arrays.toString(new Problem16_03().intersection(start1, end1, start2, end2)));
    }
}
