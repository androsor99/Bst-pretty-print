package com.epam.rd.autocode.bstprettyprint;

public class Node {

    private final Integer element;
    private Integer parentElement;
    private Node leftChild, rightChild;
    private boolean isDeleted;

    Node(Integer value) {
        this.element = value;
    }

    public Integer getElement() {
        return element;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    private void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
        leftChild.parentElement = element;
    }

    private void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
        rightChild.parentElement = element;
    }

    public Node insert(Node node, int element) {
        if (node == null) {
            return new Node(element);
        }
        if (element > node.getElement()) {
            node.setLeftChild(insert(node.getLeftChild(), element));
        } else if (element < node.getElement()) {
            node.setRightChild(insert(node.getRightChild(), element));
        } else {
            return node;
        }
        return node;
    }

    public Node find(Integer element) {
        if (this.element == element && !isDeleted) {
            return this;
        }
        if (this.element > element && leftChild != null) {
            return leftChild.find(element);
        }
        if (rightChild != null) {
            return rightChild.find(element);
        }
        return null;
    }

    public void delete() {
        this.isDeleted = true;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public Integer getParentElement() {
        return parentElement;
    }
}
