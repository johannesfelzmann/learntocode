package ep2exam.probetest2;

// This class represents players sitting in a circle in a counting game.
// Objects of type 'Player' are stored in a ring list (all nodes have a successor node != null).
// The first player starts counting "1", the second counts "2", etc., until the player, who reaches the
// specified dropout number. This player is removed from the game and the player next to his position
// starts counting again with "1" in the next round.
//
// Example (4 Players, dropout number is 3):
//
// Round 1:
// Player1      Player2     Player3     Player4
// "1"
//              "2"
//                          "3!"
// -> Player3 removed
//
// Round 2:
// Player1      Player2     Player4
//                          "1"
// "2"                      ⤶
//              "3!"
// -> Player2 removed
//
// Round 3:
// Player1      Player4
//              "1"
// "2"          ⤶
//              "3!"
// -> Player4 removed
// Player1 wins!
//
// TODO: define further classes for the implementation of the ring list, if needed (either in this file
//  or in separate files)
//
public class GameCircle {

    // TODO: declare variables
    private ListNode nil;

    // Initializes this GameCircle with the players created according to
    // 'playerNames'. The player playerNames[i] gets the number i+1.
    // playerNames[0] is the player who will start counting.
    // Preconditions: 'playerNames' is not null and has no 'null'-entries (need not be checked).
    public GameCircle(String[] playerNames) {
        // TODO: implement this constructor
        nil = new ListNode(null, null);
        nil.setNext(nil);


        for (int i = 0; i < playerNames.length; i++) {
            nil.setValue(new Player(playerNames[i]));
            nil.setNext(nil = new ListNode(null, nil.next()));
        }

        nil.next().setActive(true);
    }

    // This method simulates one round of the counting game with
    // dropout number 'dropOutCount'. It returns the player who is removed
    // in this round. Returns 'null' if there is no player in the game circle.
    // Note that the starting position for counting depends on the previous round!
    // Precondition: dropOutCount > 0 (needs not be checked).
    public Player play(int dropOutCount) {
        // TODO: implement this method

        if(!isEmpty()){

            ListNode start = getActive();
            start.setActive(false);


            while(dropOutCount > 0){

                if(start.value() != null) {

                    if (dropOutCount == 1) {
                        if(start.next().value() != null){
                            start.next().setActive(true);
                        }else{
                            start.next().next().setActive(true);
                        }

                        remove(start);
                        return start.value();
                    }

                    dropOutCount--;
                }

                start = start.next();
            }

        }

        return null;
    }

    private void remove(ListNode n){
        ListNode curr = nil;

        while(curr.next() != n){
            curr = curr.next();
        }

        curr.setNext(curr.next().next());
    }

    private ListNode getActive() {
        ListNode curr = nil.next();

        while(curr != nil){

            if(curr.isActive()){
                return curr;
            }

            curr = curr.next();
        }

        return null;
    }

    // Returns 'true' if there is no player in the game circle.
    public boolean isEmpty() {
        // TODO: implement this method
        return nil.next().value() == null;
    }

    // Returns a representation of this game circle with all its (remaining) players in
    // brackets in order of their insertion (player with smallest number is left).
    // The player that starts counting in the next round is marked by '*'.
    // Returns "[]" if the circle is empty.
    public String toString() {
        // TODO: implement this method
        ListNode curr = nil.next();
        String retVal = "[";

        while(curr != nil){

            if(curr.isActive()){
                retVal += " *" + curr.value().toString() + "*" ;
            }else{
                retVal += " " + curr.value().toString() ;
            }

            curr = curr.next();
        }

        return retVal + " ]";
    }
}

class ListNode{
    private Player value;
    private ListNode next;
    private boolean active;

    public ListNode(Player p, ListNode n){
        this.value = p;
        this.next = n;
    }

    public Player value() {
        return value;
    }

    public void setValue(Player value) {
        this.value = value;
    }

    public ListNode next() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}

