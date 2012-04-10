/**
 * PolynomialEvaluator.java
 *
 * Runs the polynomial evaluator as a command-line application
 * 
 * Syntax:
 *     java PolynomialEvaluator expression xValue
 *
 * where expression is a single-variable (specifically, x) polynomial
 * and xValue is an integer value for x.
 */

public class PolynomialEvaluator
{
    public static void main(String[] args)
    {
        //Grab the polynomial and the x-value from the
        //command line args
        String polynomial = args[0];
        int xValue = Integer.parseInt(args[1]);
        
        //Build the parser for the given polynomial String:
        Parser parser = new Parser(java.io.StringReader(polynomial));
        
        //The actual expression tree object, which we can evaluate
        //with the x-value:
        Expression exp = parser.parse();
        
        //Evaluate the expression:
        double solution = exp.evaluate(xValue);
        
        //Print the solution to stdout:
        System.out.println(solution);
    }
}
