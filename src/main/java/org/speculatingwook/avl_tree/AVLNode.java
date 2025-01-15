package org.speculatingwook.avl_tree;

public class AVLNode<T extends Comparable<T>> {
    T data;
    AVLNode<T> left;
    AVLNode<T> right;
    int height;

    public AVLNode(T data) {
        this.data = data;
        this.height = 1;
    }
}