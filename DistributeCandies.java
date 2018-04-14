package com.leetcode;

import java.util.HashMap;

/**
 * Create by WhiteBugs .
 */
public class DistributeCandies {

    //575.Distribute Candies
    //https://leetcode.com/problems/distribute-candies/description/

    public int distributeCandies(int[] candies) {
        HashMap<Integer, Integer> saveCandies = new HashMap<>();
        for(int candy : candies){
            if(!saveCandies.containsKey(candy)){
                saveCandies.put(candy, 1);
            }
        }
        return saveCandies.size()>candies.length/2? candies.length/2: saveCandies.size();
    }
}
