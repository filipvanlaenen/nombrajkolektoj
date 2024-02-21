package net.filipvanlaenen.nombrajkolektoj.longs;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Predicate;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.ModifiableCollection;
import net.filipvanlaenen.kolektoj.array.ModifiableArrayCollection;
import net.filipvanlaenen.kolektoj.linkedlist.ModifiableLinkedListCollection;
import net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection;

public abstract class ModifiableLongCollection extends AbstractModifiableLongCollection
        implements ModifiableNumericCollection<Long> {
    public final static class ArrayCollection extends ModifiableLongCollection {
        public ArrayCollection(Long... Longs) {
            super(new ModifiableArrayCollection<Long>(Longs));
        }
    }

    public final static class LinkedListCollection extends ModifiableLongCollection {
        public LinkedListCollection(Long... Longs) {
            super(new ModifiableLinkedListCollection<Long>(Longs));
        }
    }

    private final ModifiableCollection<Long> collection;

    private ModifiableLongCollection(ModifiableCollection<Long> collection) {
        this.collection = collection;
    }

    @Override
    public boolean add(Long arg0) {
        return collection.add(arg0);
    }

    @Override
    public boolean addAll(Collection<? extends Long> arg0) {
        return collection.addAll(arg0);
    }

    @Override
    public void clear() {
        collection.clear();
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
    public boolean remove(Long arg0) {
        return collection.remove(arg0);
    }

    @Override
    public boolean removeAll(Collection<? extends Long> arg0) {
        return collection.removeAll(arg0);
    }

    @Override
    public boolean removeIf(Predicate<? super Long> arg0) {
        return collection.removeIf(arg0);
    }

    @Override
    public boolean retainAll(Collection<? extends Long> arg0) {
        return collection.retainAll(arg0);
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
