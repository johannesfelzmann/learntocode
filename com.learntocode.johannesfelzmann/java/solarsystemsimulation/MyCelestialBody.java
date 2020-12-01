package java.solarsystemsimulation;

import java.awt.*;

// This class represents celestial bodies like stars, planets, asteroids, etc..
public class MyCelestialBody {

    private String name;
    private double mass;
    private double radius;
    private MyVector position; // position of the center.
    private MyVector currentMovement;
    private Color color; // for drawing the body.
    private MyVector gravity = new MyVector(0,  0, 0);

    public MyCelestialBody(String name, double mass, double radius, MyVector position, MyVector currentMovement, Color color) {
        this.name = name;
        this.mass = mass;
        this.radius = radius;
        this.position = position;
        this.currentMovement = currentMovement;
        this.color = color;
    }

    public MyCelestialBody(MyVector position, double mass){
        this.position = position;
        this.mass = mass;
    }

    public MyCelestialBody(MyCelestialBody body, MyVector position, MyVector velocity){
        this.name = body.name;
        this.mass = body.mass;
        this.radius = body.radius;
        this.color = body.color;
        this.position = position;
        this.currentMovement = velocity;

    }

    //creates empty Body
    public MyCelestialBody(){
        this.name = null;
        this.mass = 0;
        this.radius = 0;
        this.position = null;
        this.currentMovement = null;
        this.color = null;

    }

    public String getName(){ return this.name; }
    public MyVector getPosition(){return this.position;}

    public void setGravity(MyVector gravity) {
        this.gravity = gravity;
    }

    // Returns the distance between this celestial body and the specified 'body'.
    public double distanceTo(MyCelestialBody body) {
        double dX = this.position.getX() - body.position.getX();
        double dY = this.position.getY() - body.position.getY();
        double dZ = this.position.getZ() - body.position.getZ();

        return Math.sqrt(dX * dX + dY * dY + dZ * dZ);

    }

    // Returns a vector representing the gravitational force exerted by 'body' on this celestial body.
    public void gravitationalForce(MyCelestialBody body) {
        if(this.equals(body))
            return;
        MyVector direction = body.position.minus(this.position);
        double r = direction.length();
        direction.normalize();
        double force = Simulation.G * this.mass * body.mass / (r * r);
        this.gravity = this.gravity.plus(direction.times(force));
    }



    // Moves this body to a new position, according to the specified force vector 'force' exerted
    // on it, and updates the current movement accordingly.
    // (Movement depends on the mass of this body, its current movement and the exerted force.)
    public void move() {
        MyVector newPosition = this.position.plus(gravity.times(1 / this.mass)).plus(this.currentMovement);

        this.currentMovement = newPosition.minus(this.position);
        this.position = newPosition;
    }

    // Returns a string with the information about this celestial body including
    // name, mass, radius, position and current movement. Example:
    // "Earth, 5.972E24 kg, radius: 6371000.0 m, position: [1.48E11,0.0,0.0] m, movement: [0.0,29290.0,0.0] m/s."
    public String toString() {
        return name + "," + mass + " kg, radius:" + radius + " m, position: " + this.position.toString() + " m, movement: " + this.currentMovement.toString() + " m/s.";
    }

    // Prints the information about this celestial body including
    // name, mass, radius, position and current movement, to the console (without newline).
    // Earth, 5.972E24 kg, radius: 6371000.0 m, position: [1.48E11,0.0,0.0] m, movement: [0.0,29290.0,0.0] m/s.
    public void print() {
        System.out.print(this.toString());
    }

    // Draws the celestial body to the current StdDraw canvas as a dot using 'color' of this body.
    // The radius of the dot is in relation to the radius of the celestial body
    // (use a conversion based on the logarithm as in 'Simulation.java').
    public void draw() {
        StdDraw.setPenColor(color);
        StdDraw.filledCircle(this.position.getX(), this.position.getY(), 1e8 * Math.log10(this.radius));
    }


    public double getMass() {
        return mass;
    }

}

