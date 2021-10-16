package com.epam.rd.autocode.bstprettyprint;

public class BinaryTree {

    private Node root;

    public void insert(Integer element) {
        if (this.root == null) {
            this.root = new Node(element);
        } else {
            this.root.insert(root,element);
        }
    }

    public Node find(Integer element) {
       if (this.root != null) {
           return this.root.find(element);
       }
       return null;
    }

    public void delete(Integer element) {
        Node toDel = find(element);
        toDel.delete();
    }

    public Node getRoot() {
        return root;
    }
}
