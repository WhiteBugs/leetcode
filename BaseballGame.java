package com.leetcode;

import java.util.Stack;

/**
 * Create by WhiteBugs .
 */
public class BaseballGame {

    //682. Baseball Game
    //https://leetcode.com/problems/baseball-game/description/

    public int calPoints(String[] ops) {
        Stack<Integer> list = new Stack<>();
        for (String s : ops) {
            if (s.matches("-?\\d+")) {
                list.push(Integer.parseInt(s));
            } else {
                switch (s) {
                    case "D":
                        list.add(list.peek() * 2);
                        break;
                    case "C":
                        list.pop();
                        break;
                    case "+":
                        int temp1 = list.pop();
                        int temp2 = temp1 + list.peek();
                        list.push(temp1);
                        list.push(temp2);
                        break;
                    default:
                        break;
                }
            }
        }
        int answer = 0;
        while (!list.isEmpty()) {
            answer += list.pop();
        }
        return answer;
    }
}
