package com.leetcode;

/**
 * Create by WhiteBugs .
 */
public class NimGame {

    //292. Nim Game
    //https://leetcode.com/problems/nim-game/description/
    /* a better solution
     *
     * return n&3!=0;
     *
     */
    public boolean canWinNim(int n) {
        if(n%4==0){
            return false;
        }
        return true;
    }
}
