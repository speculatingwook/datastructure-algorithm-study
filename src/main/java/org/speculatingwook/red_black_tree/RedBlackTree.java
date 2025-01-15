package org.speculatingwook.red_black_tree;

public class RedBlackTree<T extends Comparable<T>> {
    private RedBlackNode<T> root;
    private RedBlackNode<T> NIL;

    public RedBlackTree() {
        NIL = new RedBlackNode<>(null);
        NIL.isRed = false;
        root = NIL;
    }

    private void leftRotate(RedBlackNode<T> x) {

    }

    private void rightRotate(RedBlackNode<T> y) {

    }

    public void insert(T data) {

    }

    private void fixInsert(RedBlackNode<T> k) {

    }
}