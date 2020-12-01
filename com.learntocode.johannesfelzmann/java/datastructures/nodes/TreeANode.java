package datastructures.nodes;
//created for preparation of EP2 exam @TU Wien 2020
public class TreeANode {

    private String key, value;
    private TreeANode left, right;

    public TreeANode(String k, String v){
        key = k;
        value = v;
    }

    public int compare(String k){
        if(k == null){
            if (key == null) {
                return 0;
            }else{
                return -1;
            }
        }
        if(key == null){
            return 1;
        }
        return key.compareTo(k);
    }

    public String add(String k, String v){

        int cmp = compare(k);

        if(cmp < 0){
            if(left != null){
                return left.add(k,v);
            }
            left = new TreeANode(k,v);
        }else if( cmp > 0){
            if(right != null){
                return right.add(k,v);
            }
            right = new TreeANode(k,v);
        }else{
            String result = value;
            value = v;
            return result;
        }

        return null;
    }

    public TreeANode find(String k){
        int cmp = compare(k);

        if(cmp == 0){
            return this;
        }

        TreeANode n;

        if(cmp < 0){
            n = left;
        }else{
            n = right;
        }

        if(n == null){
            return null;
        }

        return n.find(k);
    }

    public boolean hasValue(String v){
        if (v.equals(value)){
            return true;
        }

        if(left != null){
            return left.hasValue(v);
        }

        if(right != null){
            return right.hasValue(v);
        }

        return false;
    }

    public String value(){
        return value;
    }

}
