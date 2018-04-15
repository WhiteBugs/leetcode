package com.leetcode;

/**
 * Create by WhiteBugs .
 */
public class AddStrings {

    //415. Add Strings
    //https://leetcode.com/problems/add-strings/description/

    public String addStrings(String num1, String num2) {
        StringBuilder string = new StringBuilder();
        int cur = 0, carry = 0;
        for (int i = 0; i < Math.max(num1.length(), num2.length()); i++) {
            cur = getInt(num1, num1.length() - 1 - i) + getInt(num2, num2.length() - 1 - i) + carry;
            string.append(cur % 10);
            carry = cur / 10;
        }
        if (carry != 0)
            string.append(carry);
        return string.reverse().toString();

    }

    private int getInt(String num, int position) {
        if (position >= num.length() || position < 0)
            return 0;
        return num.charAt(position) - '0';
    }
}
