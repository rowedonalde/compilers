/**
 * Monomial.java
 *
 * PolynomialEvaluator object for evaluating a
 * monomial (e.g., 3x, 4x^2, etc.)
 */

public class Monomial
{
    private int coefficient;
    private Degree degree;
    
    public Monomial(int coefficient, Degree degree)
    {
        this.coefficient = coefficient;
        this.degree = degree;
    }
    
    public int getCoefficient()
    {
        return this.coefficient;
    }
    
    public Degree getDegree()
    {
        return this.degree;
    }
    
    /**
     * Evaluates this Monomial with the given value for x:
     */
    public double evaluate(int x)
    {
        return this.coefficient * this.degree.evaluate(x);
    }
}
