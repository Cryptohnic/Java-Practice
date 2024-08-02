/*
 * Copyright 2023 Marc Liberatore.
 */
package lists;

import java.util.Iterator;

public class ArrayList<E> implements List<E> {

    // Note: do not declare any additional instance variables
    E[] array;
    int size;

    public ArrayList() {
        size = 0;
        array = (E[]) new Object[10];
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        for (int i = 0; i < size; i++) {
            result = prime * result + array[i].hashCode();
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
        for (int i = 0; i < size; i++) {
            if (!array[i].equals(other.get(i))) { // slow if other is linkedlist
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    private void resizeDown() {
        E[] newArr = (E[]) new Object[array.length / 2];
        for (int i = 0; i < size; i++) {
            newArr[i] = array[i];
        }
        array = newArr;
    }

    private void resizeUp() {
        E[] newArr = (E[]) new Object[array.length * 2];
        for (int i = 0; i < size; i++) {
            newArr[i] = array[i];
        }
        array = newArr;
    }

    @Override
    public void add(E e) {
        if (size == array.length) {
            resizeUp();
        }
        array[size++] = e;
    }

    @Override
    public void add(int index, E e) throws IndexOutOfBoundsException {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == array.length) { // if we need more room
            resizeUp();
        }
        for (int i = size++; i > index; i--) { // update the size and move everything needed up a position
            array[i] = array[i - 1];
        }
        array[index] = e;
    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        E removed = array[index];
        for (int i = index; i < size - 1; i++) { // move everything down (leaves items at the end of the list greater than the length)
            array[i] = array[i + 1];
        }
        size--;
        if (size == array.length / 4) {
            resizeDown();
        }
        return removed;
    }

    @Override
    public E set(int index, E e) throws IndexOutOfBoundsException {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        E removed = array[index];
        array[index] = e;
        return removed;
    }

    @Override
    public int indexOf(E e) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayListIterator<>(array, size);
    }
}
