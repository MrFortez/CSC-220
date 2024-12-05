/* ***************************************************
 * Brandon Fortes
 * November 7, 2024
 * Infix2Postfix.java
 *
 * Creates a class that takes in input files through the terminal. It will take infix
 *  Expressions from this file, convert them into postfix, and then evaluate them.
 *  It will print out each step of this process.
 *************************************************** */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.sound.midi.SysexMessage;

public class Infix2Postfix {

    public static void main(String[] args) {
        // Put the infix expressions from the input file into a Queue
        Queue<String> expressions = readFile();

        String expression = "";
       
        // Iterate over the queue until it is empty.
        while ((expression = expressions.Dequeue()) != null) {

            // Print the infix expression
            System.out.println(expression);

            // Convert the infix expression to postfix then print it.
            expression = convertInfixToPostfix(expression);
            System.out.println(expression);
            
            // Evaluate and print the postfix expression
            System.out.println(evaluatePostfix(expression));

            // New line for formatting
            System.out.println();
        }   
    }

    // Reads a file passed into the code upon initiation. Each line in
    // the file is placed into a queue. The queue is then returned.
    public static Queue<String> readFile() {
        Queue<String> expressions = new Queue<String>();

        int i = 0;

        try {
            // Make the buffered reader, and map it to the input terminal
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String line = "";

            // read lines in the file until there is an empty line.
            while((line = br.readLine()) != null) {
                expressions.Enqueue(line);
                i++;
            }
        

        }
        catch (IOException e) {
            
        }
        return expressions;
    }

    // Takes a String representation of an Infix expression then returns the 
    // Postfix conversion.
    public static String convertInfixToPostfix(String infix) {
        Stack<String> stack = new Stack<String>();

        String postfix = "";

        // Iterate over the infix expression
        for (int i = 0; i < infix.length(); i++) {
            String nextVal = infix.substring(i, i + 1);
            
            // Try to convert the next character into a double.
            // If it is a number, at it to the postfix String. 
            try {
                Double.valueOf(nextVal);
                postfix += nextVal;
            }

            // Otherwise, determine what to do based on the operator.
            catch (Exception e) {
                switch (nextVal) {

                    // If it is an opening parenthesis, push it to the stack.
                    case "(":
                        stack.Push(nextVal);
                        break;

                    // If it is a closing paranthesis, pop everything between this
                    // closing parenthesis and the opening parenthesis it goes with.
                    case ")":
                        while (!(nextVal = stack.Pop()).equals("(")) {
                            postfix += nextVal;
                        }
                        break;
                    
                    // Otherwise (aka operators), pop from the stack until either the stack is empty,
                    // the iterator finds an opening parenthesis, or until the operator at the top of the stack
                    // has less precedence than the nextVal. Then, push the nextVal to the stack.
                    // Also, if the current operator and the operator at the top of the stack are both
                    // exponents (^), just push it to the stack. This is because in infix, back to back
                    // exponents are to be evaluated right to left, unlike every other operator.
                    default:
                        while (!stack.IsEmpty() && 
                            !stack.Peek().equals("(") && 
                            precedence(nextVal) <= precedence(stack.Peek()) &&
                            !(nextVal.equals("^") && stack.Peek().equals("^"))) {
                            
                            postfix += stack.Pop();
                        }
                        stack.Push(nextVal);
                        break;
                }
            }
        }
        
        // Once the infix expression has been exhausted, pop the remaining operators from the 
        // stack to the postfix expression.
        while (!stack.IsEmpty()) {
            postfix += stack.Pop();
        }

        return postfix;
    }

    // Return an int representing the level of precedence of the given operator.
    private static int precedence(String operator) {
        if (operator.equals("^"))
            return 3;
        else if (operator.equals("*") || operator.equals("/") || operator.equals("%")) {
            return 2;
        }
        else if (operator.equals("+") || operator.equals("-")) {
            return 1;
        }
        return 0;
    }

    // Takes a string representation of a post fix expression and evaluates it.
    // Returns the result of the evaluation as a double.
    public static double evaluatePostfix(String expression) {
        Stack<Double> evalStack = new Stack<Double>();
        
        for (int i = 0; i < expression.length(); i++) {
            // System.out.println(evalStack.Peek());
            
            String nextVal = expression.substring(i, i + 1);
            
            // Try to convert the next character into a double and push it to the stack.
            // If it is a number, this will work without issue. 
            try {
                evalStack.Push(Double.valueOf(nextVal));
            }

            // If it is not a number, it is an operator.
            catch (Exception e) {

                // due to how stacks work, the second number being popped will be the first
                // number in the expression.
                double secondNum = evalStack.Pop();
                double firstNum = evalStack.Pop();

                // Check which operator it is, then do the operation to the top two numbers
                // in the stack.
                switch (nextVal) {
                    case "+":
                        evalStack.Push(firstNum + secondNum);
                        break;
                    case "-":
                        evalStack.Push(firstNum - secondNum);
                        break;
                    case "*":
                        evalStack.Push(firstNum * secondNum);
                        break;
                    case "/":
                        evalStack.Push(firstNum / secondNum);
                        break;
                    case "^":
                        evalStack.Push(Math.pow(firstNum, secondNum));
                        break;
                }
            }
        }

        // return the top value in the stack, which will be the 
        // result of the postfix evaluation.
        return evalStack.Peek();
    }
}