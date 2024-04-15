package net.filipvanlaenen.nombrajkolektoj.longs;

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
 * for longs and containing inner classes with concrete implementations.
 */
public abstract class ModifiableLongCollection extends AbstractModifiableLongCollection
        implements ModifiableNumericCollection<Long> {
    /**
     * Inner class using an array backed implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableCollection}
     * interface.
     */
    public static final class ArrayCollection extends ModifiableLongCollection {
        /**
         * Constructs a collection from another collection, with the same longs and the same element cardinality.
         *
         * @param source The collection to create a new collection from.
         */
        public ArrayCollection(final Collection<Long> source) {
            this(source.getElementCardinality(), source.toArray(EmptyArrays.LONGS));
        }

        /**
         * Constructs a collection with the given longs and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param longs              The longs of the collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Long... longs) {
            super(new ModifiableArrayCollection<Long>(elementCardinality, longs));
        }

        /**
         * Constructs a collection with the given longs. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param longs The longs of the collection.
         */
        public ArrayCollection(final Long... longs) {
            super(new ModifiableArrayCollection<Long>(longs));
        }
    }

    /**
     * Inner class using a linked list backed implementation of the
     * {@link net.filipvanlaenen.kolektoj.ModifiableCollection} interface.
     */
    public static final class LinkedListCollection extends ModifiableLongCollection {
        /**
         * Constructs a collection from another collection, with the same longs and the same element cardinality.
         *
         * @param source The collection to create a new collection from.
         */
        public LinkedListCollection(final Collection<Long> source) {
            this(source.getElementCardinality(), source.toArray(EmptyArrays.LONGS));
        }

        /**
         * Constructs a collection with the given longs and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param longs              The longs of the collection.
         */
        public LinkedListCollection(final ElementCardinality elementCardinality, final Long... longs) {
            super(new ModifiableLinkedListCollection<Long>(elementCardinality, longs));
        }

        /**
         * Constructs a collection with the given longs. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param longs The longs of the collection.
         */
        public LinkedListCollection(final Long... longs) {
            super(new ModifiableLinkedListCollection<Long>(longs));
        }
    }

    /**
     * The modifiable collection holding the longs.
     */
    private final ModifiableCollection<Long> collection;

    /**
     * Private constructor taking a collection with the longs as its parameter.
     *
     * @param longs The collection holding the longs.
     */
    private ModifiableLongCollection(final ModifiableCollection<Long> longs) {
        this.collection = longs;
    }

    @Override
    public boolean add(final Long element) {
        return collection.add(element);
    }

    @Override
    public boolean addAll(final Collection<? extends Long> otherCollection) {
        return collection.addAll(otherCollection);
    }

    @Override
    public void clear() {
        collection.clear();
    }

    @Override
    public boolean contains(final Long element) {
        return collection.contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> otherCollection) {
        return collection.containsAll(otherCollection);
    }

    /**
     * Returns a new empty modifiable long collection.
     *
     * @return A new empty modifiable long collection.
     */
    static ModifiableLongCollection empty() {
        return new ArrayCollection();
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

    /**
     * Returns a new modifiable longs collection with the specified longs.
     *
     * @param longs The longs for the new modifiable longs collection.
     * @return A new modifiable longs collection with the specified longs.
     */
    static ModifiableLongCollection of(final Long... longs) {
        return new ArrayCollection(longs);
    }

    /**
     * Returns a new modifiable longs collection with the specified element cardinality and the longs.
     *
     * @param elementCardinality The element cardinality.
     * @param longs              The longs for the new modifiable longs collection.
     * @return A new modifiable longs collection with the specified element cardinality and the longs.
     */
    static ModifiableLongCollection of(final ElementCardinality elementCardinality, final Long... longs) {
        return new ArrayCollection(elementCardinality, longs);
    }

    @Override
    public boolean remove(final Long element) {
        return collection.remove(element);
    }

    @Override
    public boolean removeAll(final Collection<? extends Long> otherCollection) {
        return collection.removeAll(otherCollection);
    }

    @Override
    public boolean removeIf(final Predicate<? super Long> predicate) {
        return collection.removeIf(predicate);
    }

    @Override
    public boolean retainAll(final Collection<? extends Long> otherCollection) {
        return collection.retainAll(otherCollection);
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
        return collection.toArray(EmptyArrays.LONGS);
    }
}
