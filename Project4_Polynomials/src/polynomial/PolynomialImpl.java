package polynomial;

import java.util.*;


/**
 * This Class represents a Polynomial it implements a Polynomial Interface, it has a TreeMap and
 * a varLabel.
 */
public class PolynomialImpl implements Polynomial {


    private final TreeMap<Integer, Integer> PolynomialTree = new TreeMap<>(Collections.reverseOrder());
    private char varLabel = 'x';

    public PolynomialImpl() {}


    /**
     * Constructor that implements a Polynomial from a string.
     * @param PolyString One single variable Polynomial.
     * @throws IllegalArgumentException If there is a negative power in the Polynomial.
     */
    public PolynomialImpl (String PolyString) throws IllegalArgumentException {


        if (PolyString.length() == 0) return;


        String options = PolyString.toLowerCase().replaceAll("[^a-z]","");
        if (options.length() > 0) this.varLabel = options.charAt(0);


        String[] terms = PolyString
                .toLowerCase()
                .split(" ");


        Arrays.stream(terms).forEach(term-> {
            try {
                String[] bounds = term.split("\\^");
                int coefficient = Integer.parseInt(bounds[0].replaceAll( "" + this.varLabel,""));
                int power = (bounds.length > 1) ? Integer.parseInt(bounds[1]) :
                        (bounds[0].indexOf(this.varLabel) >= 0 ? 1 : 0);


                this.addTerm(coefficient,power);


            } catch (IllegalArgumentException Error) {
                throw new IllegalArgumentException(Error);
            }
        });
    }


    /**
     * Add this polynomial to another and return the result as another polynomial.
     * Note: As per implementation, any polynomial with different varLabel will be added as equals,
     *      as an abstraction x = [a-z] therefore, 4x^2 + 4y^2 = 8y^2 the varLabel to be used
     *      in the new object will depend on the other Polynomial varLAbel that is added to this.
     * @param other the other polynomial to be added
     * @return A polynomial with the sum of terms of this and other Polynomial.
     * @throws IllegalArgumentException If other is not a concrete class of the same type Polynomial.
     */
    @Override
    public Polynomial add(Polynomial other) throws IllegalArgumentException {

        if (!(other instanceof PolynomialImpl)) throw new IllegalArgumentException();

        Polynomial merge = new PolynomialImpl(other.toString());

        this.PolynomialTree.forEach((k,v) -> merge.addTerm(v,k));


        return merge;
    }


    /**
     *
     * @param coefficient the coefficient of the term to be added
     * @param power the power of the term to be added
     * @throws IllegalArgumentException
     */
    @Override
    public void addTerm(int coefficient, int power) throws IllegalArgumentException {
        if(power < 0) throw new IllegalArgumentException("No negative power allowed");


        if(coefficient == 0) return;


        int preCoefficient = this.getCoefficient(power) + coefficient;


        if (preCoefficient == 0) this.PolynomialTree.remove(power);
        else this.PolynomialTree.put(power, preCoefficient);
    }

    /**
     *
     * @param poly the polynomial to use
     * @return
     */
    @Override
    public boolean isSame(Polynomial poly) {
        return this.equals(poly);
    }

    /**
     *
     * @param x the value at which the polynomial is to be evaluated.
     * @return
     */

    @Override
    public double evaluate(double x) {


        double evaluator = 0;
        for (Map.Entry<Integer,Integer> term: this.PolynomialTree.entrySet()) {
            evaluator += term.getValue() * (Math.pow(x,term.getKey()));
        }

        return evaluator;


    }

    /**
     *
     * @param power the power whose coefficient is sought
     * @return
     */

    @Override
    public int getCoefficient(int power) {
        return this.PolynomialTree.get(power) == null ? 0 : this.PolynomialTree.get(power);
    }

    /**
     *
     * @return this.PolynomialTree.firstKey()
     */

    @Override
    public int getDegree() {
        return this.PolynomialTree.firstKey();
    }


    /**
     * This will format the MapTree from root to lower key
     * @return string with format from higher key to lower e.g "4x^2 +4x^1 -2"
     */
    @Override
    public String toString() {


        if (this.PolynomialTree.isEmpty()) return "0";


        String data = "";


        for(Map.Entry<Integer,Integer> term : this.PolynomialTree.entrySet()) {
            Integer power = term.getKey();
            Integer coefficient = term.getValue();


            String addSymbol = (coefficient > 0 && power != this.getDegree())? "+" : "";
            data += addSymbol + coefficient;
            data += power == 0 ? "" : this.varLabel + "^" + power + " " ;
        }


        return data.trim();
    }

    /**
     *
     * @param other
     * @return this.toString().equals(otherPoly.toString())
     */
    @Override
    public boolean equals(Object other) {


        if (other == this) return true;
        if (!(other instanceof PolynomialImpl)) return false;
        Polynomial otherPoly = (Polynomial) other;


        return this.toString().equals(otherPoly.toString());
    }



}
