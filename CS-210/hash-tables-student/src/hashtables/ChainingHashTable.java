package hashtables;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * An implementation of HashTable.
 *
 * This implementation uses chaining to resolve collisions. Chaining means the
 * underlying array stores references to growable structures (like LinkedLists)
 * that we expect to remain small in size. When there is a collision, the
 * element is added to the end of the growable structure. It must search the
 * entire growable structure whenever checking membership or removing elements.
 *
 * This implementation maintains a capacity equal to 2^n - 1 for some positive
 * integer n. When the load factor exceeds 0.75, the next add() triggers a
 * resize by incrementing n (by one). For example, when n=3, then capacity=7.
 * When size=6, then load factor ~=0.86. (size/capacity) The addition of the
 * seventh item would trigger a resize, increasing the capacity of the array to
 * 15.
 */
public class ChainingHashTable<E> implements HashTable<E> {

    private LinkedList<E>[] hashtable;
    private int size;

    /**
     * Instantiate a new hash table. The initial capacity should be 7.
     */
    public ChainingHashTable() {
        hashtable = (LinkedList<E>[]) new LinkedList[7];
        size = 0;
    }

    /**
     * Instantiate a new hash table. The initial capacity should be at least
     * sufficient to hold n elements, but must be one less than a power of two.
     */
    public ChainingHashTable(int n) {
        int capacity = (1 << ((int) Math.ceil(Math.log(n + 1) / Math.log(2)))) - 1;
        hashtable = (LinkedList<E>[]) new LinkedList[capacity];
        size = 0;
    }

    @Override
    public int capacity() {
        return hashtable.length;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public double loadFactor() {
        return (double) size / hashtable.length;
    }

    private void resize() {
        LinkedList<E>[] oldData = hashtable;
        int newCapacity = (capacity() + 1 << 1) - 1;
        hashtable = (LinkedList<E>[]) new LinkedList[newCapacity];
        size = 0;
        for (LinkedList<E> l : oldData) {
            if (l != null) {
                for (E item : l) {
                    add(item);
                }
            }
        }
    }

    @Override
    public boolean add(E e) {
        if (loadFactor() > 0.75) {
            resize();
        }
        int position = e.hashCode() % capacity();
        boolean removed = false;
        if (hashtable[position] == null) {
            hashtable[position] = new LinkedList<E>();
        } else {
            removed = remove(e);
        }
        hashtable[position].add(e);
        size++;
        return !removed;
    }

    @Override
    public boolean remove(E e) {
        int position = e.hashCode() % capacity();
        if (hashtable[position] == null) {
            return false;
        }
        int i = 0;
        for (E item : hashtable[position]) {
            if (item.equals(e)) {
                hashtable[position].remove(i);
                size--;
                return true;
            }
            i++;
        }
        return false;
    }

    @Override
    public boolean contains(E e) {
        LinkedList<E> currList = hashtable[e.hashCode() % capacity()];
        if (currList == null) {
            return false;
        }
        for (E item : currList) {
            if (item.equals(e)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public E get(E e) {
        LinkedList<E> currList = hashtable[e.hashCode() % capacity()];
        if (currList != null) {
            for (E item : currList) {
                if (item.equals(e)) {
                    return item;
                }
            }
        }
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return new HashTableIterator<E>(hashtable);
    }
}
