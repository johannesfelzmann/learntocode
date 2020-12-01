package solarsystemsimulation;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class Simulation {

    // gravitational constant
    public static final double G = 6.6743e-11;

    public static int width = 500;
    public static final double AU = 150e9;

    public static void main(String[] args) {
        int N = 10000;
        StdDraw.setCanvasSize(500, 500);
        StdDraw.setXscale(-2*AU, 2 * AU);
        StdDraw.setYscale(-2*AU, 2 * AU);
        StdDraw.enableDoubleBuffering();
        StdDraw.clear(StdDraw.BLACK);


        MyCelestialBody sun = new MyCelestialBody("Sol", 1.989e36, 63000e6, new MyVector(AU, -AU, AU), new MyVector(0, 0, 0), StdDraw.YELLOW);
        MyCelestialBody earth = new MyCelestialBody("Earth", 5.972e24, 61e3, new MyVector(148e9, 0, 300), new MyVector(0, 29.29e3, 0), StdDraw.BLUE);
        MyCelestialBody mercury = new MyCelestialBody("Mercury", 3.301e23, 2.4397e3, new MyVector(-46.0e9, 700, 0), new MyVector(0, -47.87e3, 0), StdDraw.GRAY);
        MyCelestialBody mars = new MyCelestialBody("Mars", 6.419e23, 67400, new MyVector(206e9, 230, 0), new MyVector(0, 24130, 0), StdDraw.RED);
        MyCelestialBody venus = new MyCelestialBody("Venus", 4869e24, 103e3, new MyVector(1.07411e11, 0, 0), new MyVector(0, 35e3, 0), StdDraw.PINK);

        //MyOctree test = new MyOctree();
        //test.add(sun);
        //test.add(earth);
        //test.add(mercury);
        //test.add(venus);
        //test.add(mars);

        LinkedList<MyCelestialBody> bodies = new LinkedList<>();
        //initializes the tree with N random planets
        for (int i = 0; i < N; i++) {
            double randomX = generatRandomNumbers(2 * AU, -2 * AU);
            double randomY = generatRandomNumbers(2 * AU, -2 * AU);
            double randomZ = generatRandomNumbers(2 * AU, -2 * AU);

            int randomColor = (int) (Math.random() * 10);
            bodies.add(new MyCelestialBody("Planet" + i, Math.random()*1.6e35, 61e2, new MyVector(randomX, randomY, randomZ), new MyVector(0, 0, 0), getRandomColor(randomColor)));
        }



        double seconds = 0;
        while (true) {
            MyOctree octree = new MyOctree();
            for(MyCelestialBody b:bodies){
                b.setGravity(new MyVector(0, 0, 0));
                octree.add(b);
            }


            seconds++;

            octree.simulate();
            octree.move();
            bodies = octree.getAllBodies();

            StdDraw.clear(StdDraw.BLACK);
            octree.drawTree();

            // show new positions
            StdDraw.show();

        }


    }

    public static Color getRandomColor(int i) {
        switch (i) {
            case 0:
                return StdDraw.WHITE;
            case 1:
                return StdDraw.RED;
            case 2:
                return StdDraw.BLUE;
            case 3:
                return StdDraw.GREEN;
            case 4:
                return StdDraw.YELLOW;
            case 5:
                return StdDraw.ORANGE;
            case 6:
                return StdDraw.MAGENTA;
            case 7:
                return StdDraw.BOOK_LIGHT_BLUE;
            case 8:
                return StdDraw.CYAN;
            case 9:
                return StdDraw.PRINCETON_ORANGE;
            case 10:

        }
        return null;
    }

    public static double generatRandomNumbers(double max, double min) {
        double random = Math.random() * (max - min) + min;
        return random;
    }


}

