package com.tokio.listas;

import java.util.Stack;

public class StackExample {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		
		stack.add(1);
		System.out.println("get: "+stack.get(0));
		System.out.println("peek: "+stack.peek());
	}

}
