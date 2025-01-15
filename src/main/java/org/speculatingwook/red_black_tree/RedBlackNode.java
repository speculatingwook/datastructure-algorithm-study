package org.speculatingwook.red_black_tree;

public class RedBlackNode<T extends Comparable<T>> {
    T data;
    RedBlackNode<T> left;
    RedBlackNode<T> right;
    RedBlackNode<T> parent;
    boolean isRed;

    public RedBlackNode(T data) {
        this.data = data;
        this.isRed = true; // 새로운 노드는 항상 빨간색
    }
}