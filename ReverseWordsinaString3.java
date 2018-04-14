package com.leetcode;

/**
 * Create by WhiteBugs .
 */
public class ReverseWordsinaString3 {

    //557. Reverse Words in a String III
    //https://leetcode.com/problems/reverse-words-in-a-string-iii/description/

    public String reverseWords(String s) {
        String[] items = s.split("\\s+");
        if(items.length==1){
            StringBuilder answer = new StringBuilder();
            for(int i=0; i<items[0].length(); i++){
                answer.append(items[0].charAt(items[0].length()-i-1));
            }
            return answer.toString();
        }else{
            StringBuilder answer = new StringBuilder();
            for(String item : items){
                answer.append(reverseWords(item));
                answer.append(" ");
            }
            answer.deleteCharAt(answer.toString().length()-1);
            return answer.toString();
        }
    }
}
