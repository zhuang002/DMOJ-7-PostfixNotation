/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postfixnotation;

import static java.lang.Math.pow;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author zhuan
 */
public class PostfixNotation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc=new Scanner(System.in);
        String sExp=sc.nextLine();
        try {
            System.out.printf("%.1f\r\n",evalPostfix(sExp));
        } catch (Exception e) {
            System.out.println("wrong expression!");
        }
    }

    private static double evalPostfix(String sExp) throws Exception {
        String[] tockens=sExp.split(" ");
        Stack<Double> numbers=new Stack();
        Stack<Character> operators=new Stack();
        for (String tocken:tockens) {
            if (isOperator(tocken)) {
                double operand2=numbers.pop();
                double operand1=numbers.pop();
                switch (tocken.charAt(0)) {
                    case '+':
                        numbers.push(operand1+operand2);
                        break;
                    case '-':
                        numbers.push(operand1-operand2);
                        break;
                    case '*':
                        numbers.push(operand1*operand2);
                        break;
                    case '/':
                        numbers.push(operand1/operand2);
                        break;
                    case '%':
                        numbers.push(operand1%operand2);
                        break;
                    case '^':
                        numbers.push(pow(operand1,operand2));
                        break;
                    default:
                        throw new Exception("wrong operand");
                        
                }
            } else {
                numbers.push(Double.parseDouble(tocken));
            }
        }
        return numbers.pop();
    }

    private static boolean isOperator(String tocken) {
        char c=tocken.charAt(0);
        return c=='+' || c=='-' || c=='*' || c=='/' || c=='%' || c=='^';
                
    }
    
}
