package solarsystemsimulation;

import java.awt.*;

public class MyVector {
    private double x;
    private double y;
    private double z;

    public MyVector(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;

    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    // Returns the sum of this vector and vector 'v'.
    public MyVector plus(MyVector v) {
        MyVector result = new MyVector(0, 0, 0);
        result.x = this.x + v.x;
        result.y = this.y + v.y;
        result.z = this.z + v.z;

        return result;

    }

    // Returns the product of this vector and 'd'.
    public MyVector times(double d) {

        MyVector result = new MyVector(0, 0, 0);
        result.x = this.x * d;
        result.y = this.y * d;
        result.z = this.z * d;

        return result;

    }

    // Returns the sum of this vector and -1*v.
    public MyVector minus(MyVector v) {

        MyVector result = new MyVector(0, 0, 0);
        result.x = this.x - v.x;
        result.y = this.y - v.y;
        result.z = this.z - v.z;

        return result;
    }

    // Returns the Euclidean distance of this vector
    // to the specified vector 'v'.
    public double distanceTo(MyVector v) {
        double dX = this.x - v.x;
        double dY = this.y - v.y;
        double dZ = this.z - v.z;

        return Math.sqrt(dX * dX + dY * dY + dZ * dZ);
    }

    // Returns the length (norm) of this vector.
    public double length() {
        return this.distanceTo(new MyVector(0, 0, 0));
    }

    // Normalizes this vector: changes the length of this vector such that it becomes one.
    // The direction and orientation of the vector is not affected.
    public void normalize() {
        double length = this.length();
        this.x /= length;
        this.y /= length;
        this.z /= length;

    }

    // Returns the coordinates of this vector in brackets as a string
    // in the form "[x,y,z]", e.g., "[1.48E11,0.0,0.0]".
    public String toString() {
        return "[" + x + "," + y + "," + z + "]";
    }
}
