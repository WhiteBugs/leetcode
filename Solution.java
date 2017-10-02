package com.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;



public class Solution {
	private TreeNode root = null;

	public static void main(String arg[]){
		System.out.println("");
		Solution solution = new Solution();
		solution.insert(new int[]{5,3,6,2,4,7});
		solution.printElement();
		System.out.println(new Solution().findTarget(solution.root, 13));
		
	}
	
	//283. Move Zeroes
    public void moveZeroes(int[] nums) {
        for(int i=0; i<nums.length; i++){
        	if(nums[i] == 0 ){
        		for(int j=i+1; j<nums.length; j++){
        			if(nums[j] != 0){
        				nums[i] = nums[j];
        				nums[j] = 0;
        				break;
        			}
        		}
        		if(nums[i] == 0) 
        			break;
        	}
        }
    }
	
	
	
	private void insert(int[] array){
		root = new TreeNode(array[0]);
		for(int i=1; i<array.length; i++){
			insert(array[i] , root);
		}
	}
	private TreeNode insert(int num , TreeNode node){
		if(node == null){
			return new TreeNode(num);
		}
		if(num < node.val) node.left = insert(num, node.left);
		if(num > node.val) node.right = insert(num, node.right);
		return node;
	}
	public void printElement(){
		printElement(root);
	}
	private void printElement(TreeNode tree){
		if(tree.left!=null){
			printElement(tree.left);
		}
		System.out.print(" "+tree.val+" ");
		if(tree.right!=null){
			printElement(tree.right);
		}
	}
	
	
	//389. Find the Difference
	/*
	 * 
	 
	public char findTheDifference(String s, String t) {
		HashSet<Character> set = new HashSet<>();
		for(char c : s.toCharArray()){
			set.add(c);
		}
		for(char c : t.toCharArray()){
			if(!set.contains(c))
				return c;
		}
		return ' ';
	}
	*/
	
	//653. Two Sum IV - Input is a BST
    public boolean findTarget(TreeNode root, int k) {
    	HashMap< Integer, Integer> hash = new HashMap<>();
    	ArrayList<Integer> list = new ArrayList<>();
    	addItem( root , list);
    	for(int i : list){
    		hash.put(i, 0);
    	}
    	for(int i : list){
    		if(k!=2*i&&hash.containsKey(k-i)){
    			return true;
    		}
    	}
    	return false;
    }
    private void addItem(TreeNode node , ArrayList<Integer> list){
    	if(node==null) return;
    	list.add(node.val);
    	addItem(node.left , list);
    	addItem(node.right, list);
    }
	
	//448. Find All Numbers Disappeared in an Array
    public List<Integer> findDisappearedNumbers(int[] nums) {
    	HashSet<Integer> set = new HashSet<Integer>();
        for(int i=1; i<=nums.length; i++){
        	set.add(i);
        }
        for(int i : nums){
        	set.remove(i);
        }
        return new ArrayList<>(set);
    }
	
	
	
	//258. Add Digits
    public int addDigits(int num) {
        if(num<10){
        	return num;
        }
        num = 0;
        String n = new Integer(num).toString();
        for(char c : n.toCharArray()){
        	num += c-48;
        }
        return  addDigits(num);
    }
	
	
	
	//520. Detect Capital
	/*
	 * answer on leetcode
	 * 
	 * return word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+");
	 */
    public boolean detectCapitalUse(String word) {
    	int num = 0;
    	boolean first = false;
        for(int i=0; i<word.length();i++){
        	char c = word.charAt(i);
        	if(c<91 && c>64){
        		if (i==0) {
					first = true;
				}
        		num++;
        	}
        }
        return num==word.length()||num==0||(num==1&&first)? true : false;
    }	
	
	
	//226. Invert Binary Tree
    public TreeNode invertTree(TreeNode root) {
        if(root == null) 
        	return null;
        TreeNode temp;
        temp = root.left;
        root.left = root.right;
        root.right = temp;
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        return root;
    }
	
	
	//104. Maximum Depth of Binary Tree
    public int maxDepth(TreeNode root) {
    	if(root == null)
    		return 0;
    	int left = maxDepth(root.left);
    	int right = maxDepth(root.right);
        return left>right? left+1 : right+1;
    }
	
	//485. Max Consecutive Ones
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, another = 0;
        for(int i : nums){
        	another = i==1? another+1 : 0;
        	if(max<another){
    			max = another;
    		}
        }        
        return max;
    }
	
    
	//136. Single Number
    public int singleNumber(int[] nums) {
    	if(nums==null||nums.length%2==0)
            return 0;
        HashMap<Integer	, String> list = new HashMap<>();
    	for(int n : nums){
        	if(list.containsKey(n)){
        		list.remove(n);
        	}else {
				list.put(n, null);
			}
        }
    	return Integer.parseInt(list.toString().split("\\{")[1].split("\\=")[0]);
    }
	
	
	//292. Nim Game
	/* a better solution
	 * 
	 * return n&3!=0;
	 * 
	 */
    public boolean canWinNim(int n) {
        return n%4!=0;
    }	
	
	
	
	//521. Longest Uncommon Subsequence I
    public int findLUSlength(String a, String b) {
        if(a.equals("")||b.equals("")){
        	return 0;
        }
        if(a.equals(b)){
        	return -1;
        }
        return a.length()>b.length()? a.length():b.length();
    }
	
	
	
	//637. Average of Levels in Binary Tree
    public List<Double> averageOfLevels(TreeNode root) {
        ArrayList<long[]> list = new ArrayList<>();
        recursion(list, root, 0);
        ArrayList<Double> answer = new ArrayList<>();
        for(int i=0; i<list.size(); i++){
        	long[] temp = list.get(i);
        	answer.add(((double)temp[0])/temp[1]);
        }
        return answer;
    }
    public void recursion(List<long[]> list, TreeNode node,  int level){
    	try{
    		list.get(level);
    	}catch (Exception e) {
			list.add(new long[]{0,-1});//int[0] is sum , and int[1] is node number;
		}
    	long[] temp = list.get(level);
    	if(node==null){
    		if(temp[0]==0&&temp[1]==-1){
    			list.remove(level);
    		}
    		return ;
    	}
    	if(temp[1]==-1){
    		list.get(level)[1]=0;
    	}
		list.set(level, new long[]{temp[0]+node.val,++temp[1]});
    	recursion(list, node.left, level+1);
    	recursion(list, node.right, level+1);
    }
	
	
	
	//496. Next Greater Element I
	
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
	
	//463. Island Perimeter
    public int islandPerimeter(int[][] grid) {
    	//网上的解法:考虑临近是否有岛的时候，横向只需考虑一个方向即可，纵向也只需考虑一个方向即可，
    	//因为题干已经说了，只有一个大岛而且没有对角线连接。。。
        int length = 0;
        for(int i=0; i<grid.length; i++){
        	for(int j=0; j<grid[0].length; j++){
        		if(grid[i][j]==1){
        			length+=4;
        			try{
        				length+=grid[i-1][j]==1?-1:0;
        			}catch (ArrayIndexOutOfBoundsException e) {
					}
        			try{
        				length+=grid[i+1][j]==1?-1:0;
        			}catch (ArrayIndexOutOfBoundsException e) {
					}
        			try{
        				length+=grid[i][j-1]==1?-1:0;
        			}catch (ArrayIndexOutOfBoundsException e) {
					}
        			try{
        				length+=grid[i][j+1]==1?-1:0;
        			}catch (ArrayIndexOutOfBoundsException e) {
					}
        		}
        	}
        }
    	return length;
    }
	
	
	//682. Baseball Game
    public int calPoints(String[] ops) {
        Stack<Integer> list = new Stack<>();
        for(String s : ops){
        	if(s.matches("-?\\d+")){
        		list.push(Integer.parseInt(s));
        	}else{
        		switch (s) {
				case "D":
					list.add(list.peek()*2);
					break;
				case "C":
					list.pop();
					break;
				case "+":
					int temp1 = list.pop();
					int temp2 = temp1+list.peek();
					list.push(temp1);
					list.push(temp2);
					break;
				default:
					break;
				}
        	}
        }
        int answer=0;
        while(!list.isEmpty()){
        	answer+=list.pop();
        }
        return answer;
    }
	
	//412. Fizz Buzz
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
	
	
	//566. Reshape the Matrix
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if(nums.length*nums[0].length!=r*c){
        	return nums;
        }
        int[] save = new int[r*c];
        for(int i=0; i<nums.length; i++){
        	for(int j=0; j<nums[0].length; j++){
        		save[i*nums[0].length+j] = nums[i][j];
        	}
        }
        int[][] answer = new int[r][c];
        for(int i=0; i<r; i++){
        	for(int j=0; j<c; j++){
        		answer[i][j] = save[i*c+j];
        	}
        }
    	return answer;
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
