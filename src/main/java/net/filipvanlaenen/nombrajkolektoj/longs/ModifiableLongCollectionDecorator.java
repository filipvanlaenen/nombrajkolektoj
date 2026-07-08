package net.filipvanlaenen.nombrajkolektoj.longs;

import java.util.function.Predicate;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.ModifiableCollection;

/**
 * An abstract decorator class providing implementations for the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.longs.ModifiableLongCollection} interface.
 */
abstract class ModifiableLongCollectionDecorator extends LongCollectionDecorator
        implements ModifiableLongCollection {
    @Override
    public boolean add(final Long element) {
        return getDecoratedCollection().add(element);
    }

    @Override
    public boolean addAll(final Collection<? extends Long> otherCollection) {
        return getDecoratedCollection().addAll(otherCollection);
    }

    @Override
    public boolean augment(final Long addend) throws IllegalArgumentException {
        int n = size();
        Long[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            Long originalValue = results[i];
            if (originalValue != null && addend != 0L) {
                results[i] = originalValue + addend;
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
    public void clear() {
        getDecoratedCollection().clear();
    }

    @Override
    public boolean divide(final Long divisor) throws IllegalArgumentException {
        int n = size();
        Long[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            Long originalValue = results[i];
            if (originalValue != null && originalValue != 0L && divisor != 1L) {
                results[i] = originalValue / divisor;
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
    abstract ModifiableCollection<Long> getDecoratedCollection();

    @Override
    public boolean multiply(final Long multiplicand) throws IllegalArgumentException {
        int n = size();
        Long[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            Long originalValue = results[i];
            if (originalValue != null && originalValue != 0L && multiplicand != 1L) {
                results[i] = originalValue * multiplicand;
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
        Long[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < size(); i++) {
            Long originalValue = results[i];
            if (originalValue != null && originalValue != 0L) {
                results[i] = -originalValue;
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
     * Puts the content of an array with longs into the longs collection.
     *
     * @param results      An array with longs that should be put into the longs collection.
     * @param errorMessage The message to be used as the message for the {@link IllegalArgumentException}
     * @throws IllegalArgumentException If the results can't be put into the collection.
     */
    protected void putResults(final Long[] results, final String errorMessage) throws IllegalArgumentException {
        clear();
        for (Long n : results) {
            if (!add(n)) {
                throw new IllegalArgumentException(errorMessage);
            }
        }
    }

    @Override
    public boolean remove(final Long element) {
        return getDecoratedCollection().remove(element);
    }

    @Override
    public boolean removeAll(final Collection<? extends Long> otherCollection) {
        return getDecoratedCollection().removeAll(otherCollection);
    }

    @Override
    public boolean removeIf(final Predicate<? super Long> predicate) {
        return getDecoratedCollection().removeIf(predicate);
    }

    @Override
    public boolean retainAll(final Collection<? extends Long> otherCollection) {
        return getDecoratedCollection().retainAll(otherCollection);
    }

    @Override
    public boolean subtract(final Long subtrahend) throws IllegalArgumentException {
        int n = size();
        Long[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            Long originalValue = results[i];
            if (originalValue != null && subtrahend != 0L) {
                results[i] = originalValue - subtrahend;
                changed = true;
            }
        }
        if (!changed) {
            return false;
        }
        putResults(results, "Cannot subtract the subtrahend due to the cardinality constraint.");
        return true;
    }
}
