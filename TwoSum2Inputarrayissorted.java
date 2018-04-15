package com.leetcode;

import java.util.HashMap;

/**
 * Create by WhiteBugs
 */
public class TwoSum2Inputarrayissorted {

    //167. Two Sum II - Input array is sorted
    //https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/

    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] answer = new int[2];
        for (int i = 1; i < numbers.length + 1; i++)
            map.put(numbers[i - 1], i);
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                answer[0] = i + 1;
                answer[1] = map.get(target - numbers[i]);
                break;
            }
        }
        if (answer[0] == answer[1]) {
            return new int[2];
        }
        return answer;
    }
}
