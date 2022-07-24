package com.greatlearning.balancingbrackets;

import java.util.Stack;

public class BalancingBrackets {
	// This stack will store the String of brackets character wise
	Stack<Character> st = new Stack<Character>();
	
	//Method to check whether the string has balancing brackets or not.
	public boolean balacingBracket(String str) {
		
		boolean status = true; // It will change to false when it encounters the brackets are not balanced.
		
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			
			if(ch == '(' || ch =='{' ||ch == '[') {
				st.push(ch);
	//			continue;
				}
			else 
			{
			switch(ch) {
			case '}' :
				if(st.peek() == '{') {
					st.pop();
					break;
				}else {
					status = false;
				break;
				}
				
			case ']' :
				if(st.peek() == '[') {
					st.pop();
					break;
				}else {
					status = false;
					break;
				}
			case ')' : 
				if(st.peek() == '(') {
					st.pop();
					break;
				}else {
					status = false;
				break;
				}
			}
			}
		}
		if(!st.isEmpty()) {
			status = false;
		}
		return status;
	}

	public static void main(String[] args) {
		String str = "([[[{}]]])";
		
		BalancingBrackets bbTest = new BalancingBrackets();
		
		boolean status =
		bbTest.balacingBracket(str);
		
		if(status) {
			System.out.println("The entered String has Balanced Brackets");
		}else {
			System.out.println("The entered Strings do not contain Balanced Brackets");
		}
}
}

