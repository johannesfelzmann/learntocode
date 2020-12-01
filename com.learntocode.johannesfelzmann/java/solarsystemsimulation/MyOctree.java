package solarsystemsimulation;

import java.util.LinkedList;

public class MyOctree{
    private static MyOctree root;
    private MyCelestialBody value;
    private MyOctree[] children;
    private double mass;
    private MyVector schwerpunkt;
    private static LinkedList<MyCelestialBody> allBodies;

    private double d;
    private MyVector center;
    private final double THETA = 1;


    public MyOctree(){
        allBodies = new LinkedList<>();
    }

    public MyOctree(MyCelestialBody v){
        this.value = v;
        this.mass = v.getMass();
        this.schwerpunkt = new MyVector((v.getPosition().getX()*v.getMass()+this.value.getPosition().getX()*this.value.getMass())/this.mass,(v.getPosition().getY()*v.getMass()+this.value.getPosition().getY()*this.value.getMass())/this.mass,(v.getPosition().getZ()*v.getMass()+this.value.getPosition().getZ()*this.value.getMass())/this.mass);
        this.center = new MyVector(0, 0, 0);
        this.d = 4*Simulation.AU;
    }

    public LinkedList<MyCelestialBody> getAllBodies() {
        return allBodies;
    }

    public boolean add(MyCelestialBody body){
        if(isLeaf()){
            if(value == null) {
                root = this;
                this.value = body;
                this.mass = body.getMass();
                this.center = new MyVector(0,0,0);
                schwerpunkt = new MyVector(body.getPosition().getX()*body.getMass()+this.value.getPosition().getX()*this.value.getMass()/this.mass,(body.getPosition().getY()*body.getMass()+this.value.getPosition().getY()*this.value.getMass())/this.mass,(body.getPosition().getZ()*body.getMass()+this.value.getPosition().getZ()*this.value.getMass())/this.mass);
                this.d = 4*Simulation.AU;
                return true;
            }
            put(value, this.center, this.d/2);
            put(body, this.center, this.d/2);
            this.schwerpunkt = this.schwerpunkt.plus(new MyVector(body.getPosition().getX()*body.getMass()+this.value.getPosition().getX()*this.value.getMass()/this.mass,(body.getPosition().getY()*body.getMass()+this.value.getPosition().getY()*this.value.getMass())/this.mass,(body.getPosition().getZ()*body.getMass()+this.value.getPosition().getZ()*this.value.getMass())/this.mass));
            value = null;
            return true;
        }
        else {
            if(!find(body)) {
                put(body, center, this.d/2);
                return true;
            }
        }

        return false;
    }

    //add now works, with new comparisons
    private void put(MyCelestialBody body, MyVector center, double d) {
        double x = body.getPosition().getX();
        double y = body.getPosition().getY();
        double z = body.getPosition().getZ();

        if(x > 2*Simulation.AU || x < -2*Simulation.AU || y > 2*Simulation.AU || y < -2*Simulation.AU){
            allBodies.remove(body);
            return;
        }

        MyVector c;

        if(children == null)
            children = new MyOctree[8];

        if (x < center.getX()) {
            if (y < center.getY()) {
                if (z < center.getZ()) {
                    c = center.plus(new MyVector(-d/2, -d/2, -d/2));
                    children[0] = this.putCaseDistinction(children[0], body, c, d);
                }
                else{
                    c = center.plus(new MyVector(-d/2, -d/2, d/2));
                    children[1] = this.putCaseDistinction(children[1], body, c, d);
                }
            } else {
                if (z < center.getZ()) {
                    c = center.plus(new MyVector(-d/2, d/2, -d/2));
                    children[2] = this.putCaseDistinction(children[2], body, c, d);
                }
                else {
                    c = center.plus(new MyVector(-d/2, d/2, d/2));
                    children[3] = this.putCaseDistinction(children[3], body, c, d);
                }
            }
        } else {
            if (y < center.getY()) {
                if (z < center.getZ()) {
                    c = center.plus(new MyVector(d/2, -d/2, -d/2));
                    children[4] = this.putCaseDistinction(children[4], body, c, d);
                }
                else {
                    c = center.plus(new MyVector(d/2, -d/2, d/2));
                    children[5] = this.putCaseDistinction(children[5], body, c, d);
                }
            } else {
                if (z < center.getZ()) {
                    c = center.plus(new MyVector(d/2, d/2, -d/2));
                    children[6] = this.putCaseDistinction(children[6], body, c, d);
                }
                else {
                    c = center.plus(new MyVector(d/2, d/2, d/2));
                    children[7] = this.putCaseDistinction(children[7], body, c, d);
                }
            }
        }
    }

    private MyOctree putCaseDistinction(MyOctree octree, MyCelestialBody body, MyVector c, double d) {
        if (octree == null) {
            octree = new MyOctree(body);
            this.schwerpunkt = this.schwerpunkt.plus(new MyVector((body.getPosition().getX()*body.getMass()+octree.value.getPosition().getX()*octree.value.getMass())/octree.mass,(body.getPosition().getY()*body.getMass()+octree.value.getPosition().getY()*octree.value.getMass())/octree.mass,(body.getPosition().getZ()*body.getMass()+octree.value.getPosition().getZ()*octree.value.getMass())/octree.mass));
            octree.center = c;
            octree.d = d;
        }
        else{
            if(octree.value == null)
                octree.put(body, c, d/2);
            else{
                octree.put(octree.value, c, d/2);
                octree.put(body, c, d/2);
                octree.mass += body.getMass();
                octree.schwerpunkt = octree.schwerpunkt.plus(new MyVector((body.getPosition().getX()*body.getMass()+octree.value.getPosition().getX()*octree.value.getMass())/octree.mass,(body.getPosition().getY()*body.getMass()+octree.value.getPosition().getY()*octree.value.getMass())/octree.mass,(body.getPosition().getZ()*body.getMass()+octree.value.getPosition().getZ()*octree.value.getMass())/octree.mass));
                octree.value = null;
            }
        }

        return octree;
    }

    public void drawTree(){
        if (this.value != null){
            //StdDraw.setPenColor(StdDraw.WHITE);
            //StdDraw.rectangle(center.getCoordinates()[0], center.getCoordinates()[1], d/2, d/2);
            this.value.draw();
        }
        if(children == null)
            return;


        if (children[0] != null)
            children[0].drawTree();
        if (children[1] != null)
            children[1].drawTree();
        if (children[2] != null)
            children[2].drawTree();
        if (children[3] != null)
            children[3].drawTree();
        if (children[4] != null)
            children[4].drawTree();
        if (children[5] != null)
            children[5].drawTree();
        if (children[6] != null)
            children[6].drawTree();
        if (children[7] != null)
            children[7].drawTree();

    }

    public boolean find(MyCelestialBody body) {

        //found
        if (this.value != null && this.value.getName().equals(body.getName())) {
            return true;
        }

        if(this.children == null)
            return false;

        double x = body.getPosition().getX();
        double y = body.getPosition().getY();
        double z = body.getPosition().getZ();

        if (x < this.center.getX()) {
            if (y < this.center.getY()) {
                if (z < this.center.getZ()) {
                    if (this.children[0] != null) {
                        return children[0].find(body);
                    }
                } else {
                    if (this.children[1] != null) {
                        return children[1].find(body);
                    }
                }
            } else {
                if (z < this.center.getZ()) {
                    if (this.children[2] != null) {
                        return children[2].find(body);
                    }
                } else {
                    if (this.children[3] != null) {
                        return children[3].find(body);
                    }
                }
            }
        } else {
            if (y < this.center.getY()) {
                if (z < this.center.getZ()) {
                    if (this.children[4] != null) {
                        return children[4].find(body);
                    }
                } else {
                    if (this.children[5] != null) {
                        return children[5].find(body);
                    }
                }
            } else {
                if (z < this.center.getZ()) {
                    if (this.children[6] != null) {
                        return children[6].find(body);
                    }
                } else {
                    if (this.children[7] != null) {
                        return children[7].find(body);
                    }
                }
            }
        }
        return false;
    }

    public void move(){
        if (this.value != null) {
            value.move();
            allBodies.add(this.value);
        }
        if(children == null)
            return;

        if (children[0] != null)
            children[0].move();
        if (children[1] != null)
            children[1].move();
        if (children[2] != null)
            children[2].move();
        if (children[3] != null)
            children[3].move();
        if (children[4] != null)
            children[4].move();
        if (children[5] != null)
            children[5].move();
        if (children[6] != null)
            children[6].move();
        if (children[7] != null)
            children[7].move();

    }

    public void calcGravityOf(MyCelestialBody body) {
        MyCelestialBody schwerpunkt = new MyCelestialBody(this.schwerpunkt, this.mass);
        double r = body.getPosition().distanceTo(center);

        if (!isLeaf()) {
            if (r / this.d < THETA) {       // if r/d < THETA, you have to go further into the tree, bc approx. is not good enough
                if(this.children[0] != null) {
                    this.children[0].calcGravityOf(body);
                }
                if(this.children[1] != null) {
                    this.children[1].calcGravityOf(body);
                }
                if(this.children[2] != null) {
                    this.children[2].calcGravityOf(body);
                }
                if(this.children[3] != null) {
                    this.children[3].calcGravityOf(body);
                }
                if(this.children[4] != null) {
                    this.children[4].calcGravityOf(body);
                }
                if(this.children[5] != null) {
                    this.children[5].calcGravityOf(body);
                }
                if(this.children[6] != null) {
                    this.children[6].calcGravityOf(body);
                }
                if(this.children[7] != null) {
                    this.children[7].calcGravityOf(body);
                }
            }else{
                body.gravitationalForce(schwerpunkt);

            }
        }
        else
            body.gravitationalForce(this.value);

    }

    public boolean isLeaf(){
        return children == null;
    }


    public void simulate(){
        if (this.value != null)
            root.calcGravityOf(this.value);

        if(children == null)
            return;

        if (children[0] != null)
            children[0].simulate();
        if (children[1] != null)
            children[1].simulate();
        if (children[2] != null)
            children[2].simulate();
        if (children[3] != null)
            children[3].simulate();
        if (children[4] != null)
            children[4].simulate();
        if (children[5] != null)
            children[5].simulate();
        if (children[6] != null)
            children[6].simulate();
        if (children[7] != null)
            children[7].simulate();

    }
}

