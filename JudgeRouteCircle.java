package com.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Create by WhiteBugs .
 */
public class JudgeRouteCircle {

    //657. Judge Route Circle
    //https://leetcode.com/problems/judge-route-circle/description/
    public boolean judgeCircle(String moves) {
        Deque<Character> vertical = new ArrayDeque<>();
        Deque<Character> horizontal = new ArrayDeque<>();
        for(int i=0; i<moves.length(); i++){
            switch (moves.charAt(i)) {
                case 'U':
                    if(vertical.isEmpty()||vertical.peek()=='U'){
                        vertical.push('U');
                    }else if(vertical.peek()=='D'){
                        vertical.pop();
                    }
                    break;

                case 'D':
                    if(vertical.isEmpty()||vertical.peek()=='D'){
                        vertical.push('D');
                    }else if(vertical.peek()=='U'){
                        vertical.pop();
                    }
                    break;

                case 'R':
                    if(horizontal.isEmpty()||horizontal.peek()=='R'){
                        horizontal.push('R');
                    }else if(horizontal.peek()=='L'){
                        horizontal.pop();
                    }
                    break;

                case 'L':
                    if(horizontal.isEmpty()||horizontal.peek()=='L'){
                        horizontal.push('L');
                    }else if(horizontal.peek()=='R'){
                        horizontal.pop();
                    }
                    break;

                default:
                    break;
            }
        }
        if(vertical.isEmpty()&&horizontal.isEmpty()){
            return true;
        }
        return false;
    }
}
