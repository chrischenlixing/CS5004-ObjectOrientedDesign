package polynomial;

import static org.junit.Assert.*;
import org.junit.Test;

public class PolynomialImplTest {

    @Test
    public void setUp(){
        assertThrows(IllegalArgumentException.class,()-> new PolynomialImpl("4x^2+3x^1 -2"));
        Polynomial p1 = new PolynomialImpl("3x^3 +6x^2 +4x^1 -1");
        assertEquals("3x^3 +6x^2 +4x^1 -1", p1.toString());
    }

    @Test
    public void testAdd() {
        Polynomial p1 = new PolynomialImpl("3x^3 +6x^2 +4x^1 +1");
        Polynomial p2 = new PolynomialImpl("5x^3 -2x^2 +3x^1 +2");
        Polynomial p3 = p1.add(p2);
        assertEquals("8x^3 +4x^2 +7x^1 +3", p3.toString());
    }
    
    @Test
    public void testGetCoefficient() {
        Polynomial p = new PolynomialImpl("3x^3 +6x^2 +4x^1 +1");
        assertEquals(4, p.getCoefficient(1));
        assertEquals(0, p.getCoefficient(4));
    }

    @Test
    public void testGetDegree() {
        Polynomial p = new PolynomialImpl("6x^5 +3x^4 +2x^3 +5x^1 -1");
        assertEquals(5, p.getDegree());
    }

    @Test
    public void testToString() {
        Polynomial p = new PolynomialImpl("6x^2 +3x^3 +4x^1 -1");
        assertEquals("3x^3 +6x^2 +4x^1 -1", p.toString());
    }
}