package com.leetcode;

/**
 * Create by WhiteBugs .
 */
public class StudentAttendanceRecord1 {

    //551. Student Attendance Record I
    //https://leetcode.com/problems/student-attendance-record-i/descriptio

    public boolean checkRecord(String s) {
        int a = 0, l = 0, max = 0;
        for (char c : s.toCharArray()) {
            if (c == 'A') {
                a++;
                l = 0;
            } else if (c == 'L') {
                l++;
                max = Math.max(max, l);
            } else {
                l = 0;
            }
        }
        return a < 2 && max < 3;
    }
}
