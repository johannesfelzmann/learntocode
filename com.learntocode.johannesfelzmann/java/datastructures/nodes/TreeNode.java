package datastructures.nodes;

//created for preparation of EP2 exam @TU Wien 2020
public class TreeNode {

    private int value;
    private TreeNode left, right;

    public TreeNode(int v) {
        this.value = v;
    }

    public void add(int v) {
        if (v < value) {
            if (left != null) {
                left.add(v);
            } else {
                left = new TreeNode(v);
            }
        } else if (v > value) {
            if (right != null) {
                right.add(v);
            } else {
                right = new TreeNode(v);
            }
        }
    }

    public boolean contains(int v) {
        if (v == value){
            return true;
        }

        if(v < value && left != null){
            left.contains(v);
        }else if(v > value && right != null){
            right.contains(v);
        }

        return false;
    }

}



