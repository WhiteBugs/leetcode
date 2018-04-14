package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by WhiteBugs .
 */
public class FizzBuzz {

    //412. Fizz Buzz
    //https://leetcode.com/problems/fizz-buzz/description/

    public List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<>();
        for(int i=1; i<n+1; i++){
            String string = "";
            int temp3 = i%3 , temp5 = i%5;
            if(temp3==0){
                string+="Fizz";
            }
            if(temp5==0){
                string+="Buzz";
            }
            if(string.equals("")){
                answer.add(new Integer(i).toString());
            }else{
                answer.add(string);
            }
        }
        return answer;
    }
}
