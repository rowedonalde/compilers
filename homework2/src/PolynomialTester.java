/**
 * PolynomialTester.java
 *
 * Test suite for the polynomial evaluator
 */

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class PolynomialTester
{
    /**
     * Evaluate the degree x^0: should always evaluate to 1,
     * regardless of the value of x.
     */
    @Test
    public void testDegreeZero()
    {
        Degree deg = new Degree(0);
        assertThat(deg.getExponent(), is(0));
        assertThat(deg.evaluate(0), is(1));
        assertThat(deg.evaluate(1), is(1));
        assertThat(deg.evaluate(-1), is(1));
        assertThat(deg.evaluate(2), is(1));
        assertThat(deg.evaluate(1000), is(1));
    }
    
    /**
     * Evaluate the degree x^1: should always evaluate to x
     */
    @Test
    public void testDegreeOne()
    {
        Degree deg = new Degree(1);
        assertThat(deg.getExponent(), is(1));
        assertThat(deg.evaluate(1), is(1));
        assertThat(deg.evaluate(0), is(0));
        assertThat(deg.evaluate(-1), is(-1));
        assertThat(deg.evaluate(2), is(2));
        assertThat(deg.evaluate(10), is(10));
        assertThat(deg.evaluate(-10), is(-10));
    }
    
    /**
     * Evaluate the degree x^2
     */
    @Test
    public void testDegreeTwo()
    {
        Degree deg = new Degree(2);
        assertThat(deg.getExponent(), is(2));
        assertThat(deg.evaluate(0), is(0));
        assertThat(deg.evaluate(1), is(1));
        assertThat(deg.evaluate(-1), is(1));
        assertThat(deg.evaluate(2), is(4));
        assertThat(deg.evaluate(-2), is(4));
        assertThat(deg.evaluate(10), is(100));
        assertThat(deg.evaluate(-10), is(100));
    }
    
    /**
     * Test that no argument in Degree constructor throws error
     */
    @Test(expected = IllegalArgumentException.class)
    public void testDegreeNoArgument()
    {
        Degree deg = new Degree();
    }
    
    /**
     * Test that Degree constructor does not take double type
     */
     @Test(expected = IllegalArgumentException.class)
     public void testDegreeDoubleArgument()
     {
         double x = 1.1;
         Degree deg = new Degree(x);
     }
     
     /**
      * Test some evaluations of 1x^2
      */
     @Test
     public void testMonomialOneDegreeTwo()
     {
         Degree deg = new Degree(2);
         Monomial mon = new Monomial(1, deg);
         assertThat(mon.getCoefficient(), is(1));
         assertThat(mon.evaluate(0), is(0));
         assertThat(mon.evaluate(1), is(1));
         assertThat(mon.evaluate(2), is(4));
         assertThat(mon.evaluate(-1), is(1));
         assertThat(mon.evaluate(-2), is(4));
     }
     
     /**
      * Test some evaluations of 2x^2
      */
     @Test
     public void testMonomialTwoDegreeTwo()
     {
         Degree deg = new Degree(2);
         Monomial mon = new Monomial(2, deg);
         assertThat(mon.getCoefficient(), is(2));
         assertThat(mon.evaluate(0), is(0));
         assertThat(mon.evaluate(1), is(2));
         assertThat(mon.evaluate(2), is(8));
         assertThat(mon.evaluate(-1), is(2));
         assertThat(mon.evaluate(-2), is(4));
     }
}















