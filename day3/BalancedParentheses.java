package CapgeminiTraining.day3;

import java.util.Stack;
import java.util.Scanner;

public class BalancedParentheses {

    public static boolean isBalanced(String exp) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            else if (ch == ')' || ch == '}' || ch == ']') {

                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((ch == ')' && top != '(') ||
                        (ch == '}' && top != '{') ||
                        (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter expression:");
        String exp = sc.nextLine();
        if (isBalanced(exp)) {
            System.out.println("Expression is Balanced.");
        } else {
            System.out.println("Expression is NOT Balanced.");
        }
    }
}
