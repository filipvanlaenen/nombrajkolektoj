package net.filipvanlaenen.nombrajkolektoj.integers;

import java.util.Iterator;
import java.util.Spliterator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

public abstract class IntegerCollection extends AbstractIntegerCollection implements NumericCollection<Integer> {
    public final static class ArrayCollection extends IntegerCollection {
        public ArrayCollection(Integer... integers) {
            super(new net.filipvanlaenen.kolektoj.array.ArrayCollection<Integer>(integers));
        }
    }

    private final Collection<Integer> collection;

    public IntegerCollection(Collection<Integer> collection) {
        this.collection = collection;
    }

    @Override
    public boolean contains(Integer arg0) {
        return collection.contains(arg0);
    }

    @Override
    public boolean containsAll(Collection<?> arg0) {
        return collection.containsAll(arg0);
    }

    @Override
    public Integer get() throws IndexOutOfBoundsException {
        return collection.get();
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return collection.getElementCardinality();
    }

    @Override
    public Iterator<Integer> iterator() {
        return collection.iterator();
    }

    @Override
    public int size() {
        return collection.size();
    }

    @Override
    public Spliterator<Integer> spliterator() {
        return collection.spliterator();
    }

    @Override
    public Integer[] toArray() {
        return collection.toArray();
    }
}
