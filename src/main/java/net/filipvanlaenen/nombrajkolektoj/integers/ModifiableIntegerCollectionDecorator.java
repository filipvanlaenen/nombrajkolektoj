package net.filipvanlaenen.nombrajkolektoj.integers;

import java.util.function.Predicate;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.ModifiableCollection;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection} for integers.
 */
abstract class ModifiableIntegerCollectionDecorator extends IntegerCollectionDecorator
        implements ModifiableIntegerCollection {
    @Override
    public boolean augment(final Integer addend) throws IllegalArgumentException {
        int n = size();
        Integer[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            Integer originalValue = results[i];
            if (originalValue != null && addend != 0) {
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
    public boolean divide(final Integer divisor) throws IllegalArgumentException {
        int n = size();
        Integer[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            Integer originalValue = results[i];
            if (originalValue != null && originalValue != 0 && divisor != 1) {
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
    public boolean multiply(final Integer multiplicand) throws IllegalArgumentException {
        int n = size();
        Integer[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            Integer originalValue = results[i];
            if (originalValue != null && originalValue != 0 && multiplicand != 1) {
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
        Integer[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < size(); i++) {
            Integer originalValue = results[i];
            if (originalValue != null && originalValue != 0) {
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
     * Puts the content of an array with integers into the integers collection.
     *
     * @param results      An array with integers that should be put into the integers collection.
     * @param errorMessage The message to be used as the message for the {@link IllegalArgumentException}
     * @throws IllegalArgumentException If the results can't be put into the collection.
     */
    protected void putResults(final Integer[] results, final String errorMessage) throws IllegalArgumentException {
        clear();
        for (Integer n : results) {
            if (!add(n)) {
                throw new IllegalArgumentException(errorMessage);
            }
        }
    }

    @Override
    public boolean subtract(final Integer subtrahend) throws IllegalArgumentException {
        int n = size();
        Integer[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            Integer originalValue = results[i];
            if (originalValue != null && subtrahend != 0) {
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

    @Override
    abstract ModifiableCollection<Integer> getDecoratedCollection();

    @Override
    public boolean add(final Integer element) {
        return getDecoratedCollection().add(element);
    }

    @Override
    public boolean addAll(final Collection<? extends Integer> otherCollection) {
        return getDecoratedCollection().addAll(otherCollection);
    }

    @Override
    public void clear() {
        getDecoratedCollection().clear();
    }

    @Override
    public boolean remove(final Integer element) {
        return getDecoratedCollection().remove(element);
    }

    @Override
    public boolean removeAll(final Collection<? extends Integer> otherCollection) {
        return getDecoratedCollection().removeAll(otherCollection);
    }

    @Override
    public boolean removeIf(final Predicate<? super Integer> predicate) {
        return getDecoratedCollection().removeIf(predicate);
    }

    @Override
    public boolean retainAll(final Collection<? extends Integer> otherCollection) {
        return getDecoratedCollection().retainAll(otherCollection);
    }
}
