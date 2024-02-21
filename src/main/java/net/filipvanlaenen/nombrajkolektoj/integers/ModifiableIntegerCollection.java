package net.filipvanlaenen.nombrajkolektoj.integers;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Predicate;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.ModifiableCollection;
import net.filipvanlaenen.kolektoj.array.ModifiableArrayCollection;
import net.filipvanlaenen.kolektoj.linkedlist.ModifiableLinkedListCollection;
import net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection;

public abstract class ModifiableIntegerCollection extends AbstractModifiableIntegerCollection
        implements ModifiableNumericCollection<Integer> {
    public final static class ArrayCollection extends ModifiableIntegerCollection {
        public ArrayCollection(Integer... integers) {
            super(new ModifiableArrayCollection<Integer>(integers));
        }
    }

    public final static class LinkedListCollection extends ModifiableIntegerCollection {
        public LinkedListCollection(Integer... integers) {
            super(new ModifiableLinkedListCollection<Integer>(integers));
        }
    }

    private final ModifiableCollection<Integer> collection;

    private ModifiableIntegerCollection(ModifiableCollection<Integer> collection) {
        this.collection = collection;
    }

    @Override
    public boolean add(Integer arg0) {
        return collection.add(arg0);
    }

    @Override
    public boolean addAll(Collection<? extends Integer> arg0) {
        return collection.addAll(arg0);
    }

    @Override
    public void clear() {
        collection.clear();
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
    public boolean remove(Integer arg0) {
        return collection.remove(arg0);
    }

    @Override
    public boolean removeAll(Collection<? extends Integer> arg0) {
        return collection.removeAll(arg0);
    }

    @Override
    public boolean removeIf(Predicate<? super Integer> arg0) {
        return collection.removeIf(arg0);
    }

    @Override
    public boolean retainAll(Collection<? extends Integer> arg0) {
        return collection.retainAll(arg0);
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
