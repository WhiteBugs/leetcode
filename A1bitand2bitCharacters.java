package com.leetcode;

/**
 * Create by WhiteBugs .
 */
public class A1bitand2bitCharacters {

    //717. 1-bit and 2-bit Characters
    //https://leetcode.com/problems/1-bit-and-2-bit-characters/description/
	/*
	 * a faster solution on leetcode by using Greedy Algorithm
	 *
	 *public boolean isOneBitCharacter(int[] bits) {
          int i = bits.length - 2;
          while (i >= 0 && bits[i] > 0) i--;
          return (bits.length - i) % 2 == 0;
      }
	 *
	 */
    public boolean isOneBitCharacter(int[] bits) {
        int  i=0;
        while(i<bits.length-1){
            if(bits[i] == 1)
                i+=2;
            else
                i++;
        }
        if(i == bits.length-1)
            return true;
        return false;
    }
}
