/**
 * PolynomialTester.java
 *
 * Test suite for the polynomial evaluator
 */

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import java.io.StringReader;

public class PolynomialTester
{
    
    //Since only one Parser instance can be built per execution,
    //the Parser needs to be re-initialized each time. Declare that
    //Parser here:
    private Parser parser;
    
    /**
     * Evaluate the degree x^0: should always evaluate to 1,
     * regardless of the value of x.
     */
    @Test
    public void testDegreeZero()
    {
        Degree deg = new Degree(0);
        assertThat(deg.getExponent(), is(0));
        assertThat(deg.evaluate(0), is(1.0));
        assertThat(deg.evaluate(1), is(1.0));
        assertThat(deg.evaluate(-1), is(1.0));
        assertThat(deg.evaluate(2), is(1.0));
        assertThat(deg.evaluate(1000), is(1.0));
    }
    
    /**
     * Evaluate the degree x^1: should always evaluate to x
     */
    @Test
    public void testDegreeOne()
    {
        Degree deg = new Degree(1);
        assertThat(deg.getExponent(), is(1));
        assertThat(deg.evaluate(1), is(1.0));
        assertThat(deg.evaluate(0), is(0.0));
        assertThat(deg.evaluate(-1), is(-1.0));
        assertThat(deg.evaluate(2), is(2.0));
        assertThat(deg.evaluate(10), is(10.0));
        assertThat(deg.evaluate(-10), is(-10.0));
    }
    
    /**
     * Evaluate the degree x^2
     */
    @Test
    public void testDegreeTwo()
    {
        Degree deg = new Degree(2);
        assertThat(deg.getExponent(), is(2));
        assertThat(deg.evaluate(0), is(0.0));
        assertThat(deg.evaluate(1), is(1.0));
        assertThat(deg.evaluate(-1), is(1.0));
        assertThat(deg.evaluate(2), is(4.0));
        assertThat(deg.evaluate(-2), is(4.0));
        assertThat(deg.evaluate(10), is(100.0));
        assertThat(deg.evaluate(-10), is(100.0));
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
         assertThat(mon.evaluate(0), is(0.0));
         assertThat(mon.evaluate(1), is(1.0));
         assertThat(mon.evaluate(2), is(4.0));
         assertThat(mon.evaluate(-1), is(1.0));
         assertThat(mon.evaluate(-2), is(4.0));
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
         assertThat(mon.evaluate(0), is(0.0));
         assertThat(mon.evaluate(1), is(2.0));
         assertThat(mon.evaluate(2), is(8.0));
         assertThat(mon.evaluate(-1), is(2.0));
         assertThat(mon.evaluate(-2), is(8.0));
     }
     
     /**
      * Test some evaluations of 3x^2 + 2x + 1
      */
     @Test
     public void testExpression()
     {
         Degree degA = new Degree(2);
         Monomial a = new Monomial(3, degA);
         Degree degB = new Degree(1);
         Monomial b = new Monomial(2, degB);
         Degree degC = new Degree(0);
         Monomial c = new Monomial(1, degC);
         List<Monomial> mons = new ArrayList<Monomial>();
         mons.add(a);
         mons.add(b);
         mons.add(c);
         Expression exp = new Expression(mons);
         
         assertThat(exp.evaluate(0), is(1.0));
         assertThat(exp.evaluate(1), is(6.0));
         assertThat(exp.evaluate(2), is(17.0));
         assertThat(exp.evaluate(-1), is(2.0));
         assertThat(exp.evaluate(-2), is(9.0));
     }
     
     /**
      * Test some compiled String evaluations of
      * "3x^2 + 2x + 1"
      *
      * Should be the same as testExpression()
      */
     @Test
     public void testParserDegreeTwo()
     {
         String polynomial = "3x^2 + 2x + 1";
         parser = new Parser(new StringReader(polynomial));
         Expression exp = parser.parse();
         
         assertThat(exp.evaluate(0), is(1.0));
         assertThat(exp.evaluate(1), is(6.0));
         assertThat(exp.evaluate(2), is(17.0));
         assertThat(exp.evaluate(-1), is(2.0));
         assertThat(exp.evaluate(-2), is(9.0));
     }
     
     /**
      * Test that a polynomial String with weird spacing is valid
      *
      * Equivalent to testParserDegreeTwo()
      */
     @Test
     public void testParserWeirdSpacing()
     {
         String polynomial = "   3 x    ^2 +2 x +     1 ";
         Parser.ReInit(new StringReader(polynomial));
         Expression exp = parser.parse();
         
         assertThat(exp.evaluate(0), is(1.0));
         assertThat(exp.evaluate(1), is(6.0));
         assertThat(exp.evaluate(2), is(17.0));
         assertThat(exp.evaluate(-1), is(2.0));
         assertThat(exp.evaluate(-2), is(9.0));
     }
}
