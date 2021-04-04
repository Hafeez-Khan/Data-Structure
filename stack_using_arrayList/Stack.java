package stack_using_arrayList;

import java.util.ArrayList;

public class Stack {

	static ArrayList<Integer> stack = new ArrayList<Integer>();
	static int top = 0;
	
	public static void main(String[] args) {
		Stack list = new Stack();
		Stack.push(15);
		Stack.push(45);
		Stack.push(21);
		System.out.println("Top of the stack has: " + list.peek());
		Stack.pop();
		Stack.pop();
		Stack.pop();
		Stack.pop();
		Stack.show();
		System.out.println("Is it empty:" + list.isEmpty());


	}
	
	public int size() {
		return top;
	}
	
	public static boolean isEmpty() {

		return top == 0;
	}
	
	public static void push(int data) {
		stack.add(data);
		top++;	
	}
	
	public static void pop() {
		if(isEmpty()) {
			System.out.println("Stack is empty, cant pop.");
			return;
		}
		top--;
		stack.set(top, 0);
	}
	
	public static int peek() {
		return stack.get(--top);
	}
	
	public static void show() {
		for(int n:stack) {
			System.out.println(n);
		}
	}
	
	

}
