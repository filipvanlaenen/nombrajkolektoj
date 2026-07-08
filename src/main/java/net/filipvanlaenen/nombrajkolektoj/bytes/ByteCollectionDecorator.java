package net.filipvanlaenen.nombrajkolektoj.bytes;

import java.util.Iterator;
import java.util.Spliterator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;

/**
 * An abstract decorator class providing implementations for the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.bytes.ByteCollection} interface.
 */
abstract class ByteCollectionDecorator implements ByteCollection {
    @Override
    public boolean contains(final Byte element) {
        return getDecoratedCollection().contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> collection) {
        return getDecoratedCollection().containsAll(collection);
    }

    @Override
    public Byte get() throws IndexOutOfBoundsException {
        return getDecoratedCollection().get();
    }

    /**
     * Returns the internal decorated collection.
     *
     * @return The internal decorated collection
     */
    abstract Collection<Byte> getDecoratedCollection();

    @Override
    public ElementCardinality getElementCardinality() {
        return getDecoratedCollection().getElementCardinality();
    }

    @Override
    public Iterator<Byte> iterator() {
        return getDecoratedCollection().iterator();
    }

    @Override
    public Byte max() throws IndexOutOfBoundsException {
        if (size() == 0) {
            throw new IndexOutOfBoundsException("Cannot return a maximum for an empty collection.");
        }
        Byte max = null;
        for (Byte n : this) {
            // EQMU: Changing the conditional boundary below produces an equivalent mutant.
            if (n != null && (max == null || n > max)) {
                max = n;
            }
        }
        return max;
    }

    @Override
    public Byte min() throws IndexOutOfBoundsException {
        if (size() == 0) {
            throw new IndexOutOfBoundsException("Cannot return a minimum for an empty collection.");
        }
        Byte min = null;
        for (Byte n : this) {
            // EQMU: Changing the conditional boundary below produces an equivalent mutant.
            if (n != null && (min == null || n < min)) {
                min = n;
            }
        }
        return min;
    }

    @Override
    public Byte product() {
        Byte product = (byte) 1;
        for (Byte n : this) {
            if (n != null) {
                product = (byte) (product * n);
            }
        }
        return product;
    }

    @Override
    public int size() {
        return getDecoratedCollection().size();
    }

    @Override
    public Spliterator<Byte> spliterator() {
        return getDecoratedCollection().spliterator();
    }

    @Override
    public Byte sum() {
        Byte sum = (byte) 0;
        for (Byte n : this) {
            if (n != null) {
                sum = (byte) (sum + n);
            }
        }
        return sum;
    }

    @Override
    public Byte[] toArray() {
        return getDecoratedCollection().toArray(EmptyArrays.BYTES);
    }
}
