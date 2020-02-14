package com.other.gradePointCalculator;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: Equator
 * @Date: 2020/1/16 22:44
 **/

public class GradePointCalculator {
    public static void main(String[] args) {
        List<Grade> gradeList = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        Integer input = 1;
        do {
            System.out.print("请输入成绩：");
            float score = scanner.nextFloat();
            System.out.print("请输入学分：");
            float credits = scanner.nextFloat();
            Grade grade = new Grade();
            grade.setScore(score);
            grade.setGradePoint(Grade.getGradePointByScore(score));
            grade.setCredits(credits);
            gradeList.add(grade);
            System.out.print("继续录入吗？");
            input = scanner.nextInt();
            System.out.println("-----------------");
        } while (input == 1);
        float sumGradePoint = 0, sumCredits = 0;
        for (Grade grade : gradeList) {
            System.out.println(grade.toString());
            sumGradePoint += grade.getGradePoint() * grade.getCredits();
            sumCredits += grade.getCredits();
        }
        float avg = sumGradePoint / sumCredits;
        System.out.println("平均绩点：" + avg);
    }
}
