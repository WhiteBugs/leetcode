package com.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;




public class Solution {

	public static void main(String arg[]){
		System.out.println("");
		
	}
	
	
	//669. Trim a Binary Search Tree
	public TreeNode trimBST(TreeNode root, int L, int R) {
		if(root == null) return null;
		if(root.val<L){
			root = trimBST(root.right, L, R);
		}else if(root.val>R){
			root = trimBST(root.left, L, R);
		}else{
			root.left = trimBST(root.left, L, R);
			root.right = trimBST(root.right, L, R);
		}
		return root;
	}
	/*another answer of myself which can't pass the online judge but I think it is right.
	  oh...so sad...
	  it actually return an binary tree which only contains elements between L and R ...
	  but the struct of the tree is not the same as the online judge's and this is the reason , I think,
	  why I can't pass the judge.
	
    public TreeNode trimBST(TreeNode root, int L, int R) {
         ArrayList<Integer> content = getList(root , new ArrayList<>());
         content.sort(null);
         root = new TreeNode(L);
         for(int i : content){
        	 if(i<=R&&i>=L){
        		 root = insert(root , i);
        	 }
         }
         return root;
         
    }
    private TreeNode insert(TreeNode tree, int i){
    	if(tree == null){
    		return new TreeNode(i);
    	}
    	int result = i>tree.val? 1:(i==tree.val? 0 : -1);
    	if(result == -1 ){
    		tree.left = insert(tree.left, i);
    	}
    	if(result == 1 ){
    		tree.right = insert(tree.right, i);
    	}
    	return tree;
    }
    private ArrayList<Integer> getList(TreeNode root, ArrayList<Integer> content){
    	content.add(root.val);
    	if(root.left!=null){
    		getList(root.left, content);
    	}
    	if(root.right!=null){
    		getList(root.right, content);
    	}
    	return content;
    }
	*/
	
	// 575. Distribute Candies
    public int distributeCandies(int[] candies) {
        HashMap<Integer, Integer> saveCandies = new HashMap<>();
    	for(int candy : candies){
    		if(!saveCandies.containsKey(candy)){
    			saveCandies.put(candy, 1);
    		}
    	}
    	return saveCandies.size()>candies.length/2? candies.length/2: saveCandies.size();
    }
    
	
	//557. Reverse Words in a String III
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
	
	
	
	
	/* 500. Keyboard Row  Online Answer
	 * public String[] findWords(String[] words) {
          return Stream.of(words).filter(s -> s.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")).toArray(String[]::new);
          }
	 */
    public String[] findWords(String[] words) {
        ArrayList<String> answer = new ArrayList<>();
        ArrayList<Character> first = new ArrayList<>(Arrays.asList('q','w','e','r','t','y','u','i','o','p'));
        ArrayList<Character> second = new ArrayList<>(Arrays.asList('a','s','d','f','g','h','j','k','l'));
        ArrayList<Character> third = new ArrayList<>(Arrays.asList('z','x','c','v','b','n','m'));
        for(int j=0; j<words.length; j++){
        	String item = words[j].toLowerCase();
        	System.out.println(item);
        	int queue = 0;
        	for(int i=0; i<item.length(); i++){
        		char c = item.charAt(i);
        		if(first.contains(c)){
        			if(i==0){
        				queue = 1;
        			}else if(queue !=1){
        				break;
        			}
        		}else if(second.contains(c)){
        			if(i==0){
        				queue = 2;
        			}else if(queue !=2){
        				break;
        			}
        		}else if(third.contains(c)){
        			if(i==0){
        				queue = 3;
        			}else if(queue !=3){
        				break;
        			}
        		}
        		if(i==item.length()-1){
        			answer.add(words[j]);
        		}
        	}
        }
        return answer.toArray(new String[answer.size()]);
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
