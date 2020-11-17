package java.datastructures;

import java.datastructures.nodes.TreeANode;

import java.util.Iterator;

//created for preparation of EP2 exam @TU Wien 2020
public class BinaryTree implements Iterable{

    private TreeANode root;

    public String add(String k, String v){
        if (root != null){
            return root.add(k,v);
        }
        root = new TreeANode(k,v);
        return null;
    }

    public String get(String k){
        if(root == null){
            return  null;
        }
        TreeANode n = root.find(k);
        if(n != null){
            return n.value();
        }

        return null;
    }

    public boolean containsKey(String k){
        return root != null && root.find(k) != null;
    }

    public boolean containsValue(String v){
        return root != null && root.hasValue(v);
    }

    public Iterator<String> iterator(){
        return new Iterator<String>() {

            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public String next() {
                return null;
            }
        };
    }

}
