/*
 * Copyright 2023 Marc Liberatore.
 */
package trees;

import javax.crypto.NullCipher;

/**
 * A (partial) implementation of AVL tree. You'll need to complete the rotations
 * to make insertion work. This project doesn't require you to implement
 * remove(), but you're welcome to do so if you want -- it requires a slight
 * modification to `insertionCheck` as written.
 *
 * If you're feeling like challenging yourself, reimplement the
 * add-and-rotation-fix algorithm the "traditional" way -- recursively.
 */
public class AVLTree<E extends Comparable<E>> {

    Node<E> root;
    int size;

    /**
     * Return the size of (number of elements stored in) the tree.
     *
     * @return the size of the tree
     */
    public int size() {
        return size;
    }

    /**
     * Add e to the tree.
     *
     * e is overwritten if it's already in the tree, but no duplication occurs.
     *
     * @param e
     */
    public void add(E e) {
        if (root == null) {
            root = new Node<>(e);
            size = 1;
            return;
        }
        add(e, root);
    }

    /**
     * The recursive helper method for add(E e).
     *
     * @param e
     * @param node
     */
    private void add(E e, Node<E> node) {
        if (e.equals(node.data)) {
            node.data = e;
        } else if (e.compareTo(node.data) < 0) {
            if (node.left == null) {
                node.left = new Node<>(e, node);
                size++;
                insertionCheck(node.left);
                return;
            } else {
                add(e, node.left);
            }
        } else {
            if (node.right == null) {
                node.right = new Node<>(e, node);
                size++;
                insertionCheck(node.right);
                return;
            } else {
                add(e, node.right);
            }
        }
    }

    /**
     * Check that the AVL property has not been broken after node's insertion.
     * If it has, then perform the rotation needed to restore it.
     *
     * @param node
     */
    private void insertionCheck(Node<E> node) {
        Node<E> n = node;
        String path = "";
        while (true) {
            if (!isAVL(n)) {
                // rotate (and be done, if this is insertion)
                String rot = path.substring(0, 2);
                if (rot.equals("LL")) {
                    rotateLL(n);
                } else if (rot.equals("RR")) {
                    rotateRR(n);
                } else if (rot.equals("LR")) {
                    rotateLR(n);
                } else if (rot.equals("RL")) {
                    rotateRL(n);
                } else {
                    // should never get here!
                    throw new IllegalStateException();
                }
                break; // if insertion, you're done after one fix
            } else if (n != root) {
                if (n == n.parent.left) {
                    path = "L" + path;
                } else {
                    path = "R" + path;
                }
                n = n.parent;
            } else { // n was the root
                // and so we're done
                break;
            }
        }
    }

    private int height(Node<E> n) {
        if (n == null) {
            return -1;
        } else if (n.left == null && n.right == null) {
            return 0;
        } else {
            return 1 + Math.max(height(n.left), height(n.right));
        }
    }

    private boolean isAVL(Node<E> n) {
        return Math.abs(height(n.left) - height(n.right)) <= 1;
    }

    /**
     * Perform an LL rotation around n.
     *
     * @param n
     */
    private void rotateLL(Node<E> n) {
        Node<E> A, B, T2, p;

        B = n;
        p = B.parent;
        A = B.left;
        T2 = A.right;

        // making A the root of the subtree
        if (B == root) { // special case: B was the root of the *whole* tree
            root = A;
            A.parent = null;
        } else { // otherwise, B was just a node in the tree, not its root
            if (p.left == B) {
                p.left = A;
            } else {
                p.right = A;
            }
            A.parent = p;
        }

        // now let's make B into A's right subchild
        A.right = B;
        B.parent = A;

        // finally, let's move T2 to B's new left subchild
        B.left = T2;
        if (T2 != null) {
            T2.parent = B;
        }
    }

    /**
     * Perform an RR rotation around n.
     *
     * @param n
     */
    private void rotateRR(Node<E> n) {
        Node<E> A, B, T1, p;

        B = n;
        p = B.parent;
        A = B.right;
        T1 = A.left;

        // making A the root of the subtree
        if (B == root) { // special case: B was the root of the *whole* tree
            root = A;
            A.parent = null;
        } else { // otherwise, B was just a node in the tree, not its root
            if (p.right == B) {
                p.right = A;
            } else {
                p.left = A;
            }
            A.parent = p;
        }

        // now let's make B into A's left subchild
        A.left = B;
        B.parent = A;

        // finally, let's move T1 to B's new right subchild
        B.right = T1;
        if (T1 != null) {
            T1.parent = B;
        }
    }

    /**
     * Perform an LR rotation around n.
     *
     * @param n
     */
    private void rotateLR(Node<E> n) {
        Node<E> A, B, T2, p;

        B = n;
        p = B.parent;
        A = B.left;
        T2 = A.right;

        // making T2 the root of the subtree
        if (B == root) { // special case: B was the root of the *whole* tree
            root = T2;
            T2.parent = null;
        } else { // otherwise, B was just a node in the tree, not its root
            if (p.left == B) {
                p.left = T2;
            } else {
                p.right = T2;
            }
            T2.parent = p;
        }

        // let's move T2's children
        B.left = T2.right;
        if (T2.right != null) {
            T2.right.parent = B;
        }
        A.right = T2.left;
        if (T2.left != null) {
            T2.left.parent = A;
        }

        // finally, lets make A and B subchilds
        T2.right = B;
        T2.left = A;
        B.parent = T2;
        A.parent = T2;
    }

    /**
     * Perform an RL rotation around n.
     *
     * @param n
     */
    private void rotateRL(Node<E> n) {
        Node<E> A, B, T1, p;

        B = n;
        p = B.parent;
        A = B.right;
        T1 = A.left;

        // making T1 the root of the subtree
        if (B == root) { // special case: B was the root of the *whole* tree
            root = T1;
            T1.parent = null;
        } else { // otherwise, B was just a node in the tree, not its root
            if (p.left == B) {
                p.left = T1;
            } else {
                p.right = T1;
            }
            T1.parent = p;
        }

        // let's move T1's children
        B.right = T1.left;
        if (T1.left != null) {
            T1.left.parent = B;
        }
        A.left = T1.right;
        if (T1.right != null) {
            T1.right.parent = A;
        }

        // finally, lets make A and B subchilds
        T1.right = A;
        T1.left = B;
        B.parent = T1;
        A.parent = T1;
    }

    /**
     * Return true iff the tree contains the value e.
     *
     * @param e
     * @return true iff the tree contains the value e
     */
    public boolean contains(E e) {
        return find(e) != null;
    }

    private Node<E> find(E e, Node<E> n) {
        if (n == null) {
            return null;
        } else if (e.equals(n.data)) {
            return n;
        } else if (e.compareTo(n.data) < 0) { // left
            return find(e, n.left);
        } else {  // right
            return find(e, n.right);
        }
    }

    private Node<E> find(E e) {
        return find(e, root);
    }

    public E findData(E e) {
        return find(e, root).data;
    }
}
