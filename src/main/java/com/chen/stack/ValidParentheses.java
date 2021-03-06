package com.chen.stack;

import java.util.Stack;

/**
 * 有效的括号
 *
 * @Author LeifChen
 * @Date 2018-08-27
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char topChar = stack.pop();
                if (c == ')' && topChar != '(') {
                    return false;
                }
                if (c == ']' && topChar != '[') {
                    return false;
                }
                if (c == '}' && topChar != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println((new ValidParentheses()).isValid("()"));
        System.out.println((new ValidParentheses()).isValid("()[]{}"));
        System.out.println((new ValidParentheses()).isValid("(]"));
        System.out.println((new ValidParentheses()).isValid("([)]"));
        System.out.println((new ValidParentheses()).isValid("{[]}"));
    }
}
