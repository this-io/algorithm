package main.implementation.easy.string;

import java.util.Stack;

public class ValidParentheses {

  public static void main(String[] args) {
    ValidParentheses v = new ValidParentheses();
    System.out.println(v.isValid("(){}}{"));
  }

  public boolean isValid(String s) {
    if (s.length() == 0 || s.isEmpty()) {
      return false;
    }

    Stack theStack = new Stack();
    char[] theInput = s.toCharArray();

    for (char c : theInput) {
      if((c == '}' || c == ']' || c == ')') && theStack.isEmpty()) {
        return false;
      }

      if (c == '(' || c == '{' || c == '[') {
        theStack.push(c);
      } else {
        if (theStack.isEmpty()) {
          return false;
        } else {
          char popped = (char) theStack.pop();
          if (c == ')' && popped != '(') {
            return false;
          } else if (c == '}' && popped != '{') {
            return false;
          } else if (c == ']' && popped != '[') {
            return false;
          }
        }
      }
    }

    return theStack.isEmpty() ? true : false;
  }
}
