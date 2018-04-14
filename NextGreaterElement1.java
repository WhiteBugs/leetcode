package com.leetcode;

import java.util.HashMap;

/**
 * Create by WhiteBugs .
 */
public class NextGreaterElement1 {

    //496. Next Greater Element I
    //https://leetcode.com/problems/next-greater-element-i/description/

    /* a smarter solution on leetcode.com
     *
     *  public int[] nextGreaterElement(int[] findNums, int[] nums) {
           Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
           Stack<Integer> stack = new Stack<>();
           for (int num : nums) {
               while (!stack.isEmpty() && stack.peek() < num)
                   map.put(stack.pop(), num);
               stack.push(num);
           }
           for (int i = 0; i < findNums.length; i++)
               findNums[i] = map.getOrDefault(findNums[i], -1);
           return findNums;
        }
     *
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> list = new HashMap<>();
        for(int i=0; i<nums2.length; i++){
            int greater = 0;
            if(i==nums2.length-1){
                list.put(nums2[i], -1);
                break;
            }
            for(int j=i+1; j<nums2.length; j++){
                if(nums2[j]>nums2[i]){
                    greater = nums2[j];
                    list.put(nums2[i], greater);
                    break;
                }
                if(j==nums2.length-1){
                    list.put(nums2[i], -1);
                    break;
                }
            }
        }
        for(int i=0; i<nums1.length; i++){
            nums1[i] = list.get(nums1[i]);
        }
        return nums1;
    }
}
