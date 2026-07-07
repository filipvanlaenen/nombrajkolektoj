package net.filipvanlaenen.nombrajkolektoj.bytes;

import java.util.function.Predicate;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.ModifiableCollection;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection} for bytes.
 */
abstract class ModifiableByteCollectionDecorator extends ByteCollectionDecorator
        implements ModifiableByteCollection {
    @Override
    public boolean augment(final Byte addend) throws IllegalArgumentException {
        int n = size();
        Byte[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            Byte originalValue = results[i];
            if (originalValue != null && addend != (byte) 0) {
                results[i] = (byte) (originalValue + addend);
                changed = true;
            }
        }
        if (!changed) {
            return false;
        }
        putResults(results, "Cannot augment with the addend due to the cardinality constraint.");
        return true;
    }

    @Override
    public boolean divide(final Byte divisor) throws IllegalArgumentException {
        int n = size();
        Byte[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            Byte originalValue = results[i];
            if (originalValue != null && originalValue != (byte) 0 && divisor != (byte) 1) {
                results[i] = (byte) (originalValue / divisor);
                changed = true;
            }
        }
        if (!changed) {
            return false;
        }
        putResults(results, "Cannot divide by the divisor due to the cardinality constraint.");
        return true;
    }

    @Override
    public boolean multiply(final Byte multiplicand) throws IllegalArgumentException {
        int n = size();
        Byte[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            Byte originalValue = results[i];
            if (originalValue != null && originalValue != (byte) 0 && multiplicand != (byte) 1) {
                results[i] = (byte) (originalValue * multiplicand);
                changed = true;
            }
        }
        if (!changed) {
            return false;
        }
        putResults(results, "Cannot multiply with the multiplicand due to the cardinality constraint.");
        return true;
    }

    @Override
    public boolean negate() throws IllegalArgumentException {
        Byte[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < size(); i++) {
            Byte originalValue = results[i];
            if (originalValue != null && originalValue != (byte) 0) {
                results[i] = (byte) (-originalValue);
                changed = true;
            }
        }
        if (!changed) {
            return false;
        }
        putResults(results, "Cannot negate due to the cardinality constraint.");
        return true;
    }

    /**
     * Puts the content of an array with bytes into the bytes collection.
     *
     * @param results      An array with bytes that should be put into the bytes collection.
     * @param errorMessage The message to be used as the message for the {@link IllegalArgumentException}
     * @throws IllegalArgumentException If the results can't be put into the collection.
     */
    protected void putResults(final Byte[] results, final String errorMessage) throws IllegalArgumentException {
        clear();
        for (Byte n : results) {
            if (!add(n)) {
                throw new IllegalArgumentException(errorMessage);
            }
        }
    }

    @Override
    public boolean subtract(final Byte subtrahend) throws IllegalArgumentException {
        int n = size();
        Byte[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            Byte originalValue = results[i];
            if (originalValue != null && subtrahend != (byte) 0) {
                results[i] = (byte) (originalValue - subtrahend);
                changed = true;
            }
        }
        if (!changed) {
            return false;
        }
        putResults(results, "Cannot subtract the subtrahend due to the cardinality constraint.");
        return true;
    }

    @Override
    abstract ModifiableCollection<Byte> getDecoratedCollection();

    @Override
    public boolean add(final Byte element) {
        return getDecoratedCollection().add(element);
    }

    @Override
    public boolean addAll(final Collection<? extends Byte> otherCollection) {
        return getDecoratedCollection().addAll(otherCollection);
    }

    @Override
    public void clear() {
        getDecoratedCollection().clear();
    }

    @Override
    public boolean remove(final Byte element) {
        return getDecoratedCollection().remove(element);
    }

    @Override
    public boolean removeAll(final Collection<? extends Byte> otherCollection) {
        return getDecoratedCollection().removeAll(otherCollection);
    }

    @Override
    public boolean removeIf(final Predicate<? super Byte> predicate) {
        return getDecoratedCollection().removeIf(predicate);
    }

    @Override
    public boolean retainAll(final Collection<? extends Byte> otherCollection) {
        return getDecoratedCollection().retainAll(otherCollection);
    }
}
