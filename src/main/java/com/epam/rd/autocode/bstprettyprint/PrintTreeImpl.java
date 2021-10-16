package com.epam.rd.autocode.bstprettyprint;

import static com.epam.rd.autocode.bstprettyprint.PseudographicSymbol.LEFT_DOWN;
import static com.epam.rd.autocode.bstprettyprint.PseudographicSymbol.LEFT_UP;
import static com.epam.rd.autocode.bstprettyprint.PseudographicSymbol.NEW_LINE;
import static com.epam.rd.autocode.bstprettyprint.PseudographicSymbol.RIGHT_DOWN;
import static com.epam.rd.autocode.bstprettyprint.PseudographicSymbol.RIGHT_UP;
import static com.epam.rd.autocode.bstprettyprint.PseudographicSymbol.SPACE;
import static com.epam.rd.autocode.bstprettyprint.PseudographicSymbol.UP_DOWN;
import static com.epam.rd.autocode.bstprettyprint.PseudographicSymbol.VERTICAL;

public class PrintTreeImpl implements PrintableTree {

    private final BinaryTree tree;

    public PrintTreeImpl() {
        this.tree = new BinaryTree();
    }

    @Override
    public void add(int element) {
        tree.insert(element);
    }

    @Override
    public String prettyPrint() {
        Node root = tree.getRoot();
        StringBuilder result = new StringBuilder();
        if (root.getRightChild() != null)
            result.append(printNode(root.getRightChild(),true, ""));
        result.append(printNodeElement(root));
        if (root.getLeftChild() != null)
            result.append(printNode(root.getLeftChild(), false, ""));
        return result.toString();
    }

    private String printNode(Node node, boolean isRight, String indent) {
        StringBuilder result = new StringBuilder();
        String spaces = addSpaces(node.getParentElement());
        Node right = node.getRightChild();
        Node left = node.getLeftChild();
        if (right != null) {
            result.append(printNode(right, true, indent + spaces + (isRight ? SPACE.getSymbol() : VERTICAL.getSymbol())));
        }
        result.append(indent).append(spaces);
        if (isRight) {
            result.append(LEFT_DOWN.getSymbol());
        } else {
            result.append(LEFT_UP.getSymbol());
        }
        result.append(printNodeElement(node));
        if (left != null)
            result.append(printNode(left,false, indent + spaces + (isRight ? VERTICAL.getSymbol() : SPACE.getSymbol())));
        return result.toString();
    }

    private String addSpaces(Integer element) {
        return SPACE.getSymbol().repeat(String.valueOf(element).length());
    }

    private String printNodeElement(Node node) {
        StringBuilder result = new StringBuilder();
        Node right = node.getRightChild();
        Node left = node.getLeftChild();
        if (right != null && left != null) {
            result.append(node.getElement()).append(UP_DOWN.getSymbol());
        }
        if (right != null && left == null) {
            result.append(node.getElement()).append(RIGHT_UP.getSymbol());
        }
        if (right == null && left != null) {
            result.append(node.getElement()).append(RIGHT_DOWN.getSymbol());
        }
        if (right == null && left == null) {
            result.append(node.getElement());
        }
        result.append(NEW_LINE.getSymbol());
        return result.toString();
    }
}
