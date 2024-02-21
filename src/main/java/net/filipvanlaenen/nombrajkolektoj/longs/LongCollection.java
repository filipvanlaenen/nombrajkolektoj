package net.filipvanlaenen.nombrajkolektoj.longs;

import java.util.Iterator;
import java.util.Spliterator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

public abstract class LongCollection extends AbstractLongCollection implements NumericCollection<Long> {
    public final static class ArrayCollection extends LongCollection {
        public ArrayCollection(Long... integers) {
            super(new net.filipvanlaenen.kolektoj.array.ArrayCollection<Long>(integers));
        }
    }

    private final Collection<Long> collection;

    public LongCollection(Collection<Long> collection) {
        this.collection = collection;
    }

    @Override
    public boolean contains(Long arg0) {
        return collection.contains(arg0);
    }

    @Override
    public boolean containsAll(Collection<?> arg0) {
        return collection.containsAll(arg0);
    }

    @Override
    public Long get() throws IndexOutOfBoundsException {
        return collection.get();
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return collection.getElementCardinality();
    }

    @Override
    public Iterator<Long> iterator() {
        return collection.iterator();
    }

    @Override
    public int size() {
        return collection.size();
    }

    @Override
    public Spliterator<Long> spliterator() {
        return collection.spliterator();
    }

    @Override
    public Long[] toArray() {
        return collection.toArray();
    }
}
