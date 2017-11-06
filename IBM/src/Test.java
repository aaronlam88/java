//Write a program that would reverse the order of words in a sentence.
//For example, "Interview are fun" would be output as "fun are Interview"

import java.util.Stack;

public class Test {
  public String reverseWordsOrder (String in) {
    String[] tokens = in.split(" ");
    Stack<String> stack = new Stack<>();
    for(String word : tokens) {
      stack.push(word); 
    }

    StringBuilder strbuilder = new StringBuilder();
    while(!stack.isEmpty()) {
      strbuilder.append(stack.pop());
      strbuilder.append(" ");
    }

    return strbuilder.toString().trim();
  }

  public static void main(String[] args) {
    String test = "Interview are fun";
    
    Test test1 = new Test();
    
    System.out.println(test1.reverseWordsOrder(test));
  }
}