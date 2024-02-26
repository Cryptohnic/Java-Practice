/*
 * Copyright 2023 Marc Liberatore.
 */
package lists;

import com.sun.source.doctree.SerialFieldTree;

public class LinkedList<E> implements List<E> {

    // Note: do not declare any additional instance variables
    Node<E> head;
    Node<E> tail;
    int size;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        Node<E> n = head;
        while (n != null) {
            result = prime * result + head.data.hashCode();
        }
        result = prime * result + size;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List other = (List) obj;
        if (size != other.size()) {
            return false;
        }
        Node<E> frontCurr = head;
        for (int i = 0; i < size; i++) {
            if (!frontCurr.data.equals(other.get(i))) { // slow if other is a linked list
                return false;
            }
            frontCurr = frontCurr.next;
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size - 1) {
            return tail.data;
        }
        Node<E> curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.data;
    }

    @Override
    public void add(E e) {
        if (size == 0) {
            head = new Node<E>(e);
            tail = head;
        } else {
            tail.next = new Node<E>(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public void add(int index, E e) throws IndexOutOfBoundsException {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) { // add to back
            add(e);
            return;
        }
        if (index == 0) { // add to front
            head = new Node<E>(e, head.next);
        } else { // add to middle
            Node<E> nodeBefore = head;
            for (int i = 0; i < index - 1; i++) {
                nodeBefore = nodeBefore.next;
            }
            nodeBefore.next = new Node<E>(e, nodeBefore.next);
        }
        size++;
    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        E removed;
        if (index == 0) { // remove from front
            removed = head.data;
            head = head.next;
        } else { // remove anywhere else
            Node<E> nodeBefore = head;
            for (int i = 0; i < index - 1; i++) {
                nodeBefore = nodeBefore.next;
            }
            removed = nodeBefore.next.data;
            nodeBefore.next = nodeBefore.next.next;
            if (index == size - 1) { // update tail if removed
                tail = nodeBefore;
            }
        }
        size--;
        return removed;
    }

    @Override
    public E set(int index, E e) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        E removed;
        if (index == size - 1) { // change back
            removed = tail.data;
            tail.data = e;
        } else { // change anywhere else
            Node<E> node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            removed = node.data;
            node.data = e;
        }
        return removed;
    }

    @Override
    public int indexOf(E e) {
        Node<E> node = head;
        for (int i = 0; i < size; i++) {
            if (node.data.equals(e)) {
                return i;
            }
            node = node.next;
        }
        return -1;
    }
}
