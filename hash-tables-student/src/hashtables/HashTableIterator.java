package hashtables;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class HashTableIterator<E> implements Iterator<E> {

    private final LinkedList<E>[] items;
    private int currSize;
    private int listNum;
    private int pos;

    public HashTableIterator(LinkedList<E>[] items) {
        this.items = items;
        listNum = 0;
        while (listNum < items.length && items[listNum] == null) {
            listNum++;
        }
        currSize = listNum < items.length ? items[listNum].size() : 0;
        pos = 0;
    }

    @Override
    public boolean hasNext() {
        return pos < currSize;
    }

    @Override
    public E next() {
        if (hasNext()) {
            E toReturn = items[listNum].get(pos);
            pos = pos + 1 < currSize ? pos + 1 : 0;
            if (pos == 0) {
                do {
                    listNum++;
                } while (listNum < items.length && items[listNum] == null);
                currSize = listNum < items.length ? items[listNum].size() : 0;
            }
            return toReturn;
        }
        throw new NoSuchElementException();
    }

}
