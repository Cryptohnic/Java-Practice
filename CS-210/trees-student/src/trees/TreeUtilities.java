/*
 * Copyright 2023 Marc Liberatore.
 */
package trees;

import java.util.ArrayList;
import java.util.List;

/**
 * A collection of utility methods for trees and their nodes.
 *
 * You will almost certainly need to add some methods here to complete the
 * unimplemented methods!
 */
public class TreeUtilities {

    /**
     * Perform an in-order traversal of the tree rooted at the given node, and
     * return a list of the elements in the order they were visited.
     *
     * @param node
     * @return a list of elements from the tree from an in-order traversal
     * starting at node
     */
    static <E> List<E> inOrder(Node<E> node) {
        return inOrder(node, new ArrayList<E>());
    }

    private static <E> List<E> inOrder(Node<E> node, ArrayList<E> list) {
        if (node != null) {
            inOrder(node.left, list);
            list.add(node.data);
            inOrder(node.right, list);
        }
        return list;
    }

    /**
     * Returns the height of the node n.
     *
     * null has a height of -1; otherwise, the height is defined as 1 + the
     * height of the larger of the node's two subtrees.
     *
     * @param n
     * @return the height of the node n
     */
    static <E> int height(Node<E> n) {
        if (n == null) {
            return -1;
        }
        if (n.left == null && n.right == null) {
            return 0;
        }
        return 1 + Math.max(height(n.left), height(n.right));
    }

    /**
     * Return a new, balanced tree containing all the values of the old tree
     * bst.
     *
     * @param bst
     * @return a new, balanced tree containing all the values of the old tree
     * bst
     */
    static <E extends Comparable<E>> BinarySearchTree<E> intoBalanced(BinarySearchTree<E> bst) {
        List<E> sorted = inOrder(bst.root);
        BinarySearchTree<E> balanced = new BinarySearchTree<>();
        return intoBalanced(balanced, sorted, 0, sorted.size() - 1);
    }

    static <E extends Comparable<E>> int size(BinarySearchTree<E> n) {
        return size(n.root);
    }

    private static <E extends Comparable<E>> int size(Node<E> n) {
        if (n == null) {
            return 0;
        }
        return 1 + size(n.left) + size(n.right);
    }

    private static <E extends Comparable<E>> BinarySearchTree<E> intoBalanced(BinarySearchTree<E> balanced, List<E> sorted, int left, int right) {
        if (left <= right) {
            int mid = (left + right) / 2;
            balanced.add(sorted.get(mid));
            intoBalanced(balanced, sorted, left, mid - 1);
            intoBalanced(balanced, sorted, mid + 1, right);
            return balanced;
        }
        return balanced;
    }

    /**
     * Returns true iff the tree rooted at n is a Binary Search Tree.
     *
     * It must have no more than two children per node.
     *
     * Each node's value must be greater than all the values in its left
     * subtree, and smaller than all the values in its right subtree. (This
     * implies duplicate values are not allowed.)
     *
     * @param n true iff the tree rooted at n is a Binary Search Tree
     * @return
     */
    static <E extends Comparable<E>> boolean isBST(Node<E> n) {
        if (n == null || (n.left == null && n.right == null)) {
            return true;
        }
        if (n.left != null && n.left.data.compareTo(n.data) > 0 || n.right != null && n.right.data.compareTo(n.data) < 0) {
            return false;
        }
        return isBST(n.left) && isBST(n.right);
    }

    /**
     * Returns true iff the tree rooted at n is an AVL tree.
     *
     * AVL trees are Binary Search trees with the additional property that every
     * node in the tree has the AVL property.
     *
     * A node has the AVL property iff the height of its left subtree and the
     * height of its right subtree differ by no more than 1.
     *
     * @param <E>
     * @param n
     * @returntrue iff the tree rooted at n is an AVL tree
     */
    static <E extends Comparable<E>> boolean isAVLTree(Node<E> n) {
        if (n == null || n.left == null && n.right == null) {
            return true;
        }
        if (Math.abs(height(n.right) - height(n.left)) > 1) {
            return false;
        }
        return isAVLTree(n.left) && isAVLTree(n.right) && isBST(n.left) && isBST(n.right);
    }

    /**
     * Returns true iff the subtrees rooted at n and m have the same values and
     * same structure.
     *
     * Only checks child references, not parent references.
     *
     * @param n
     * @param m
     * @return true iff the subtrees rooted at n and m have the same values and
     * same structure
     */
    static <E> boolean equalSubtrees(Node<E> n, Node<E> m) {
        if (n == null && m == null) {
            return true;
        } else if (n == null || m == null) {
            return false;
        } else {
            return n.data.equals(m.data) && equalSubtrees(n.left, m.left) && equalSubtrees(n.right, m.right);
        }
    }

    static <E extends Comparable<E>> E findData(BinarySearchTree<E> bst, E data) {
        Node<E> node = bst.root;
        while (node != null) {
            if (data.equals(node.data)) {
                return node.data;
            }
            if (data.compareTo(node.data) > 0) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return null;
    }
}
