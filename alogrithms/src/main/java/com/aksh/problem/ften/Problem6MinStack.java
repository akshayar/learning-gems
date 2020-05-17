/**
 * 
 */
package com.aksh.problem.ften;

import java.util.Stack;

/**
 * @author aksha Design and stask that supports push , pop , top and retrieving
 *         the min element in constant time.
 *  When an element x is pushed and that is less then min, then create an element x'=f(x,min)=2x-min. 
 *  This will help in pop to calculate previous min. 
 *
 */
public class Problem6MinStack {
	// main stack to store elements
	private Stack<Integer> s = new Stack<>();

	// variable to store minimum element
	private int min;

	// Inserts a given element on top of the stack
	public void push(int x) {
		System.out.println("Before pushing :"+x+",stack:"+this);
		if (s.empty()) {
			s.push(x);
			min = x;
		} else if (x > min) {
			s.push(x);
		} else {
			s.push(2 * x - min);
			min = x;
		}
		System.out.println("After pushing :"+x+",stack:"+this);
	}

	// Removes top element from the stack and returns it
	public void pop() {
		System.out.println("Before pop stack:"+this);
		if (s.empty()) {
			System.out.println("Stack underflow!!");
		}

		int top = s.peek();
		if (top < min)
			min = 2 * min - top;
		s.pop();
		System.out.println("After pop stack:"+this);
	}

	// Returns the minimum element from the stack in constant time
	public int getMin() {
		return min;
	}

	@Override
	public String toString() {
		return "Min:" + min + ",stack:" + s;
	}

	public static void main(String[] args) {
		Problem6MinStack stack = new Problem6MinStack();
		stack.push(-2);
		stack.push(0);
		stack.push(-3);
		stack.push(2);
		stack.push(-5);
		System.out.println(stack.getMin());
		stack.pop();
		System.out.println(stack.getMin());
	}
}
