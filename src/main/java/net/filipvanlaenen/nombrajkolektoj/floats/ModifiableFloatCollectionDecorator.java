package net.filipvanlaenen.nombrajkolektoj.floats;

import java.util.function.Predicate;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.ModifiableCollection;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection} for floats.
 */
abstract class ModifiableFloatCollectionDecorator extends FloatCollectionDecorator
        implements ModifiableFloatCollection {
    @Override
    public boolean augment(final Float addend) throws IllegalArgumentException {
        int n = size();
        Float[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            Float originalValue = results[i];
            if (originalValue != null && addend != 0F) {
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
    public boolean divide(final Float divisor) throws IllegalArgumentException {
        int n = size();
        Float[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            Float originalValue = results[i];
            if (originalValue != null && originalValue != 0F && divisor != 1F) {
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
    public boolean multiply(final Float multiplicand) throws IllegalArgumentException {
        int n = size();
        Float[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            Float originalValue = results[i];
            if (originalValue != null && originalValue != 0F && multiplicand != 1F) {
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
        Float[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < size(); i++) {
            Float originalValue = results[i];
            if (originalValue != null && originalValue != 0F) {
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
     * Puts the content of an array with floats into the floats collection.
     *
     * @param results      An array with floats that should be put into the floats collection.
     * @param errorMessage The message to be used as the message for the {@link IllegalArgumentException}
     * @throws IllegalArgumentException If the results can't be put into the collection.
     */
    protected void putResults(final Float[] results, final String errorMessage) throws IllegalArgumentException {
        clear();
        for (Float n : results) {
            if (!add(n)) {
                throw new IllegalArgumentException(errorMessage);
            }
        }
    }

    @Override
    public boolean subtract(final Float subtrahend) throws IllegalArgumentException {
        int n = size();
        Float[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            Float originalValue = results[i];
            if (originalValue != null && subtrahend != 0F) {
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
    abstract ModifiableCollection<Float> getDecoratedCollection();

    @Override
    public boolean add(final Float element) {
        return getDecoratedCollection().add(element);
    }

    @Override
    public boolean addAll(final Collection<? extends Float> otherCollection) {
        return getDecoratedCollection().addAll(otherCollection);
    }

    @Override
    public void clear() {
        getDecoratedCollection().clear();
    }

    @Override
    public boolean remove(final Float element) {
        return getDecoratedCollection().remove(element);
    }

    @Override
    public boolean removeAll(final Collection<? extends Float> otherCollection) {
        return getDecoratedCollection().removeAll(otherCollection);
    }

    @Override
    public boolean removeIf(final Predicate<? super Float> predicate) {
        return getDecoratedCollection().removeIf(predicate);
    }

    @Override
    public boolean retainAll(final Collection<? extends Float> otherCollection) {
        return getDecoratedCollection().retainAll(otherCollection);
    }
}
