/**
 * Degree.java
 *
 * PolynomialEvaluator object for evaluating a degree (e.g., x^3, x, etc.)
 */

public class Degree
{
    private int exponent;
    
    /**
     * Constructs a new Degree object with the given exponent:
     */
    public Degree(int exponent)
    {
        this.exponent = exponent;
    }
    
    public int getExponent()
    {
        return this.exponent;
    }
    
    /**
     * Evaluate this Degree with the given value for x:
     */
    public double evaluate(int x)
    {
        return Math.pow(x, this.exponent);
    }
}