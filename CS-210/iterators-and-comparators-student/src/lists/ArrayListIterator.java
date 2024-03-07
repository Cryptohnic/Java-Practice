/*
 * Copyright 2023 Marc Liberatore.
 */
package lists;

import java.util.Iterator;
import java.util.NoSuchElementException;

class ArrayListIterator<E> implements Iterator<E> {

    private final E[] items;
    private final int size;
    private int pos;

    public ArrayListIterator(E[] items, int size) {
        this.items = items;
        this.size = size;
        pos = 0;
    }

    @Override
    public boolean hasNext() {
        return pos < size;
    }

    @Override
    public E next() {
        if (hasNext()) {
            return items[pos++];
        }
        throw new NoSuchElementException();
    }
}
