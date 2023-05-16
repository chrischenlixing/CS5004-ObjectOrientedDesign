import org.junit.jupiter.api.BeforeEach;

import static jdk.internal.foreign.abi.aarch64.AArch64Architecture.v1;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import project01.Vector3D;
class Vector3DTest {
    private Vector3D vector1;
    private Vector3D vector2;
    private Vector3D vector3;

    @BeforeEach
    public void setUp() {
        vector1 = new Vector3D(1, 2, 3);
        vector2 = new Vector3D(2,3, 4);
        vector3 = new Vector3D(0,0, 0);
    }

    @org.junit.jupiter.api.Test
    void getX() {
        assertEquals(1.0,vector1.getX());

        assertEquals(2.0,vector2.getX());


    }

    @org.junit.jupiter.api.Test
    void getY() {
        assertEquals(2.0,vector1.getY());

        assertEquals(3.0,vector2.getY());

    }

    @org.junit.jupiter.api.Test
    void getZ() {
        assertEquals(3.0,vector1.getZ(),0.01);

        assertEquals(4.0,vector2.getZ());

    }

    @org.junit.jupiter.api.Test
    void testToString() {
        assertEquals("(1.00, 2.00, 3.00)",vector1.toString());

        assertEquals("(2.00, 3.00, 4.00)",vector2.toString());
    }

    @org.junit.jupiter.api.Test
    void getMagnitude() {
        assertEquals(3.74,vector1.getMagnitude(),0.01);

        assertEquals(5.38,vector2.getMagnitude(),0.01);

    }

    @org.junit.jupiter.api.Test
    void normalize() {
        assertEquals(0.27,vector1.normalize().getX(),0.01);

        assertEquals(0.53,vector1.normalize().getY(),0.01);

        assertEquals(0.80,vector1.normalize().getZ(),0.01);

        assertThrows(
                IllegalStateException.class,
                () -> {
                    vector3.normalize();
                });
    }

    @org.junit.jupiter.api.Test
    void add() {
        Vector3D addVector = vector1.add(vector2);
        assertEquals(3.0,addVector.getX(),0.01);
    }

    @org.junit.jupiter.api.Test
    void multiply() {
        Vector3D multipliedVector = vector1.multiply(2);

        assertEquals(2.0,multipliedVector.getX(),0.01);

    }

    @org.junit.jupiter.api.Test
    void dotProduct() {
        assertEquals(20.0,vector1.dotProduct(vector2),0.01);
    }

    @Test
    void angleBetween() {
        assertEquals(6.98,vector1.angleBetween(vector2),0.01);

    }

    @org.junit.jupiter.api.Test
    void crossProduct() {
        assertEquals(-1.01,vector1.crossProduct(vector2).getX(),0.1);
    }
}


