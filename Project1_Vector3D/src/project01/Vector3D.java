package project01;

public class Vector3D {
    private double x,y,z;

    /**
     * A constructor that takes in x, y, z components of the vector. Each parameter is of type double.
     * @param x
     * @param y
     * @param z
     */
    public Vector3D(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Get
     * @return this x
     */
    public double getX(){
        return this.x;
    }

    /**
     *
     * @return this y
     */

    public double getY(){
        return this.y;
    }

    /**
     *
     * @return this z
     */
    public double getZ(){
        return this.z;
    }

    /**
     * This string should be of the form “(x, y, z)” replacing the letters with their values.
     * Each component should be formatted to round to exactly two decimal places
     * (look at the String.format method to see how to do this).
     * @return a string that describes this vector
     */
    public String toString(){
       String s = String.format("(%.2f, %.2f, %.2f)",x,y,z);
       return s;
    }

    /**
     *
     * @return returns its magnitude.
     */

    public double getMagnitude(){
        return Math.sqrt(Math.pow(this.x,2) + Math.pow(this.y,2) + Math.pow(this.z,2));
    }

    /**
     *
     * @return a normalized version of this vector
     * @throws IllegalArgumentException
     */

    public Vector3D normalize() throws IllegalStateException{
        if (this.getMagnitude() == 0){
            throw new IllegalStateException("Magnitude shouldn't be zero.");
        }
        double normalizedX = this.x/this.getMagnitude();
        double normalizedY = this.y/this.getMagnitude();
        double normalizedZ = this.z/this.getMagnitude();
        return new Vector3D(normalizedX,normalizedY,normalizedZ);
    }

    /**
     *
     * @param other
     * @return the result of adding this vector to another vector.
     */
    public Vector3D add(Vector3D other){
        double totalX = this.x + other.x;
        double totalY = this.y + other.y;
        double totalZ = this.z + other.z;

        return new Vector3D(totalX,totalY,totalZ);
    }

    /**
     *
     * @param constant
     * @return the result of multiplying this vector by a constant.
     * It should not change the vector that is being multiplied.
     */

    public Vector3D multiply(double constant){
        double multipliedX = this.x * constant;
        double multipliedY = this.y * constant;
        double multipliedZ = this.z * constant;

        return new Vector3D(multipliedX,multipliedY,multipliedZ);
    }

    /**
     *
     * @param other
     * @return  the dot product of this vector and another vector. It should not change the two vectors.
     */

    public double dotProduct(Vector3D other){
        double dotX = this.x * other.x;
        double dotY = this.y * other.y;
        double dotZ = this.z * other.z;

        double dotVector = dotX + dotY + dotZ;
        return dotVector;
    }

    /**
     *
     * @param other
     * @return the angle between two vectors in degrees. It should not change the two vectors.
     * It should throw an IllegalStateException if this operation cannot be completed.
     */

    public double angleBetween(Vector3D other) throws IllegalStateException{
        if (this.getMagnitude() == 0 || other.getMagnitude() == 0){
            throw new IllegalStateException("Magnitude shouldn't be zero.");
        }
        double r = Math.acos(this.dotProduct(other)/(this.getMagnitude() * other.getMagnitude()));
        double degree = Math.toDegrees(r);
        return degree;
    }


    /**
     *
     * @param other
     * @return the cross product of this vector and another vector.
     * It should not change the two vectors.
     */
    public Vector3D crossProduct(Vector3D other){
        double crossX = this.y * other.z - this.z * other.y;
        double crossY = this.z * other.x - this.x * other.z;
        double crossZ = this.x * other.y - this.y * other.x;
        return new Vector3D(crossX,crossY,crossZ);
    }
}
