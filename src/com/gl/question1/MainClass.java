package com.gl.question1;
import java.util.*;

public class MainClass {
	
	static boolean checkingBalance(String exp) {
		Stack<Character> stack = new Stack<Character>();
		
		for (int i = 0; i < exp.length(); i++) {
			char bracket = exp.charAt(i);
			
			if(bracket == '(' || bracket == '{' || bracket == '[') {
				stack.push(bracket);
				continue;
			}
			
			if(stack.isEmpty()) {
				return false;
			}
			
			char temp;
			
			switch (bracket) {
			case '}':
				temp = stack.pop();
				if(temp == '(' || temp == '[') {
					return false;
				}
				break;
			
			case ')':
				temp = stack.pop();
				if(temp == '{' || temp == '[') {
					return false;
				}
				break;
				
			case ']':
				temp = stack.pop();
				if(temp == '{' || temp == '(') {
					return false;
				}
				break;
			}
		}
		return (stack.isEmpty());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String brackets = "([[{}]])";
		
		boolean result = checkingBalance(brackets);
		
		if(result) {
			System.out.println("The entered String has Balanced Brackets");
		}else {
			System.out.println("The entered Strings do not contain Balanced Brackets");
		}
	}

}
