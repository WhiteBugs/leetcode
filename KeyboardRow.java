package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Create by WhiteBugs .
 */
public class KeyboardRow {

    //500. Keyboard Row
    //https://leetcode.com/problems/keyboard-row/description/

    /* 500. Keyboard Row  Online Answer
	 * public String[] findWords(String[] words) {
          return Stream.of(words).filter(s -> s.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")).toArray(String[]::new);
          }
	 */

    public String[] findWords(String[] words) {
        ArrayList<String> answer = new ArrayList<>();
        ArrayList<Character> first = new ArrayList<>(Arrays.asList('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'));
        ArrayList<Character> second = new ArrayList<>(Arrays.asList('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'));
        ArrayList<Character> third = new ArrayList<>(Arrays.asList('z', 'x', 'c', 'v', 'b', 'n', 'm'));
        for (int j = 0; j < words.length; j++) {
            String item = words[j].toLowerCase();
            int queue = 0;
            for (int i = 0; i < item.length(); i++) {
                char c = item.charAt(i);
                if (first.contains(c)) {
                    if (i == 0) {
                        queue = 1;
                    } else if (queue != 1) {
                        break;
                    }
                } else if (second.contains(c)) {
                    if (i == 0) {
                        queue = 2;
                    } else if (queue != 2) {
                        break;
                    }
                } else if (third.contains(c)) {
                    if (i == 0) {
                        queue = 3;
                    } else if (queue != 3) {
                        break;
                    }
                }
                if (i == item.length() - 1) {
                    answer.add(words[j]);
                }
            }
        }
        return answer.toArray(new String[answer.size()]);
    }
}
