package com.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;




public class Solution {

	public static void main(String arg[]){
		System.out.println(Integer.toBinaryString(Integer.highestOneBit(-2)-1));
		System.out.println(new Solution().findComplement(-2));
	}
	
	//617. Merge Two Binary Trees
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    	if(t1==null){
    		return t2;
    	}else if(t2==null){
    		return t1;
    	}else{
    		TreeNode t = new TreeNode(t1.val+t2.val);
            t.left=mergeTrees(t1.left, t2.left);
            t.right=mergeTrees(t1.right, t2.right);
            return t;
    	}  
    }
	
    
    //
    public int findComplement(int num) {
    	//if(true) return ~num & ((Integer.highestOneBit(num) << 1) - 1);//leetcode上的discussion
    	int value = 0;
        for(int i=31; i>=0; i--){
        	int n=num;
        	n>>>=i;
        	if(n==0){
        		System.out.println(n+"!");
        		continue;
        	}else{
        		value=i;
        		break;
        	}
        }
        int number = 0;
        for(;value>=0;value--){
        	int n = num;
        	if(((n>>>=value)&1)==0){
        		number<<=1;
        		number++;
        	}else{
        		number<<=1;
        	}
        }
        return number;
    }
    
    
    
	//657. Judge Route Circle
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
	
    //190. Reverse Bits
    public int reverseBits(int n) {
    	int result = 0;
        for (int i = 0; i <32; i++) {
        	int num =n;
        	
        	if(((num>>>=i)&1)==1){
        		result <<=1;
        		result++;
        	}else{
        		result<<=1;
        	}
        }
        return result;
    }
	
    //191. Number of 1 Bits
    public int hammingWeight(int n) {
        Integer num = 0;
        String binary = num.toBinaryString(n);
        for(int i=0; i<binary.length(); i++){
        	if(binary.charAt(i)=='1'){
        		num++;
        	}
        }
        return num;
    }

	//461. Hamming Distance
    public int hammingDistance(int x, int y) {
    	Integer a = new Integer(0);
    	String xb = a.toBinaryString(x);
    	String yb = a.toBinaryString(y);
    	ArrayList<Integer> al = new ArrayList<>();
    	ArrayList<Integer> bl = new ArrayList<>();
    	for(int i=xb.length()-1;i>=0; i--){
    		al.add(xb.charAt(i)-48);
    	}
    	for(int i=yb.length()-1; i>=0; i--){
    		bl.add(yb.charAt(i)-48);
    	}
    	int num=0;
    	for(int i=0; i<(al.size()>bl.size()? al.size():bl.size()); i++){
    		try{
    			if(al.get(i)!=bl.get(i)){
    				num++;
    			}
    		}catch (Exception e) {
				if((al.size()>bl.size()? al:bl).get(i)==1){
					num++;
				}
			}
    	}
    	return num;
    	
    }
	
	
	//1. Two Sum
	public int maximumSwap(int num) {
		String n = String.valueOf(num);
		System.out.println(n.charAt(0));
        int first = n.charAt(0)-48;
        for(int i=9; i>=0; i--){
        	int position = n.indexOf(i+48);
        	if(position != -1){
        		
        	}
        }
        return 0;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
