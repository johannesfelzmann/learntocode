package java.ep2exam.probetest2;

// This class represents a Player in a counting game. Every player has a name
// and a unique number.
//
public class Player {

    // Use unique consecutive numbers for instances.
    // The first instance has number 1.
    private static int nextNumber = 1;
    // TODO: declare variables
    private int number;
    private String name;

    // A constructor with the 'name' of the player.
    // Precondition: name != null (needs not be checked).
    public Player(String name) {
        // TODO: implement this constructor
        this.name = name;
        this.number = nextNumber++;
    }

    // Returns the number of players that have been instantiated so far.
    public static int numberOfPlayers() {
        //TODO: implement this method
        return nextNumber-1;
    }

    // Returns a representation of this player with his name and his number in
    // parentheses, e.g.: Michael(5)
    public String toString() {
        // TODO: implement this method
        return this.name + "(" + this.number + ")";
    }

}

