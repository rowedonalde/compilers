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
}
