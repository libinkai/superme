package com.falcon.gradePointCalculator;

/**
 * @Author: Equator
 * @Date: 2020/1/16 22:46
 **/

public class Grade {
    // 成绩
    private float score;
    // 绩点
    private float gradePoint;
    // 学分
    private float credits;

    public static float getGradePointByScore(float score) {
        if (score >= 90) {
            return 4.0f;
        } else if (score >= 85) {
            return 3.7f;
        } else if (score >= 82) {
            return 3.3f;
        } else if (score >= 78) {
            return 3.0f;
        } else if (score >= 75) {
            return 2.7f;
        } else if (score >= 72) {
            return 2.3f;
        } else if (score >= 68) {
            return 2.0f;
        } else if (score >= 66) {
            return 1.7f;
        } else if (score >= 63) {
            return 1.3f;
        } else {
            return 1.0f;
        }
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public float getGradePoint() {
        return gradePoint;
    }

    public void setGradePoint(float gradePoint) {
        this.gradePoint = gradePoint;
    }

    public float getCredits() {
        return credits;
    }

    public void setCredits(float credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "score=" + score +
                ", gradePoint=" + gradePoint +
                ", credits=" + credits +
                '}';
    }
}
