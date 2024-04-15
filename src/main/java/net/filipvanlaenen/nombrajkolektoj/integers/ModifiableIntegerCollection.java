package net.filipvanlaenen.nombrajkolektoj.integers;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Predicate;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.ModifiableCollection;
import net.filipvanlaenen.kolektoj.array.ModifiableArrayCollection;
import net.filipvanlaenen.kolektoj.linkedlist.ModifiableLinkedListCollection;
import net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection} interface
 * for integers and containing inner classes with concrete implementations.
 */
public abstract class ModifiableIntegerCollection extends AbstractModifiableIntegerCollection
        implements ModifiableNumericCollection<Integer> {
    /**
     * Inner class using an array backed implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableCollection}
     * interface.
     */
    public static final class ArrayCollection extends ModifiableIntegerCollection {
        /**
         * Constructs a collection from another collection, with the same integers and the same element cardinality.
         *
         * @param source The collection to create a new collection from.
         */
        public ArrayCollection(final Collection<Integer> source) {
            this(source.getElementCardinality(), source.toArray(EmptyArrays.INTEGERS));
        }

        /**
         * Constructs a collection with the given integers and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param integers           The integers of the collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Integer... integers) {
            super(new ModifiableArrayCollection<Integer>(elementCardinality, integers));
        }

        /**
         * Constructs a collection with the given integers. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param integers The integers of the collection.
         */
        public ArrayCollection(final Integer... integers) {
            super(new ModifiableArrayCollection<Integer>(integers));
        }
    }

    /**
     * Inner class using a linked list backed implementation of the
     * {@link net.filipvanlaenen.kolektoj.ModifiableCollection} interface.
     */
    public static final class LinkedListCollection extends ModifiableIntegerCollection {
        /**
         * Constructs a collection from another collection, with the same integers and the same element cardinality.
         *
         * @param source The collection to create a new collection from.
         */
        public LinkedListCollection(final Collection<Integer> source) {
            this(source.getElementCardinality(), source.toArray(EmptyArrays.INTEGERS));
        }

        /**
         * Constructs a collection with the given integers and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param integers           The integers of the collection.
         */
        public LinkedListCollection(final ElementCardinality elementCardinality, final Integer... integers) {
            super(new ModifiableLinkedListCollection<Integer>(elementCardinality, integers));
        }

        /**
         * Constructs a collection with the given integers. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param integers The integers of the collection.
         */
        public LinkedListCollection(final Integer... integers) {
            super(new ModifiableLinkedListCollection<Integer>(integers));
        }
    }

    /**
     * The modifiable collection holding the integers.
     */
    private final ModifiableCollection<Integer> collection;

    /**
     * Private constructor taking a collection with the integers as its parameter.
     *
     * @param integers The collection holding the integers.
     */
    private ModifiableIntegerCollection(final ModifiableCollection<Integer> integers) {
        this.collection = integers;
    }

    @Override
    public boolean add(final Integer element) {
        return collection.add(element);
    }

    @Override
    public boolean addAll(final Collection<? extends Integer> otherCollection) {
        return collection.addAll(otherCollection);
    }

    @Override
    public void clear() {
        collection.clear();
    }

    @Override
    public boolean contains(final Integer element) {
        return collection.contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> otherCollection) {
        return collection.containsAll(otherCollection);
    }

    /**
     * Returns a new empty modifiable integer collection.
     *
     * @return A new empty modifiable integer collection.
     */
    static ModifiableIntegerCollection empty() {
        return new ArrayCollection();
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

    /**
     * Returns a new modifiable integer collection with the specified integers.
     *
     * @param integers The integers for the new modifiable integer collection.
     * @return A new modifiable integer collection with the specified integers.
     */
    static ModifiableIntegerCollection of(final Integer... integers) {
        return new ArrayCollection(integers);
    }

    /**
     * Returns a new modifiable integer collection with the specified element cardinality and the integers.
     *
     * @param elementCardinality The element cardinality.
     * @param integers           The integers for the new modifiable integer collection.
     * @return A new modifiable integer collection with the specified element cardinality and the integers.
     */
    static ModifiableIntegerCollection of(final ElementCardinality elementCardinality, final Integer... integers) {
        return new ArrayCollection(elementCardinality, integers);
    }

    @Override
    public boolean remove(final Integer element) {
        return collection.remove(element);
    }

    @Override
    public boolean removeAll(final Collection<? extends Integer> otherCollection) {
        return collection.removeAll(otherCollection);
    }

    @Override
    public boolean removeIf(final Predicate<? super Integer> predicate) {
        return collection.removeIf(predicate);
    }

    @Override
    public boolean retainAll(final Collection<? extends Integer> otherCollection) {
        return collection.retainAll(otherCollection);
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
        return collection.toArray(EmptyArrays.INTEGERS);
    }
}
