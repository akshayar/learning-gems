/**
 * 
 */
package com.aksh.problem.ften;

import java.util.Stack;

/**
 * @author aksha Design and stask that supports push , pop , top and retrieving
 *         the min element in constant time.
 *
 */
public class Problem6MinStack {
	Stack<Integer> stack=new Stack<Integer>();
	int min=Integer.MAX_VALUE;
	public void push(int i) {
		if(i<=min) {
			min=i;
			stack.push(min);
		}
		stack.push(i);
		
	}
	public int pop() {
		
	}
	public 
	

}
