package net.filipvanlaenen.nombrajkolektoj.shorts;

import java.util.function.Predicate;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.ModifiableCollection;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection} for shorts.
 */
abstract class ModifiableShortCollectionDecorator extends ShortCollectionDecorator
        implements ModifiableShortCollection {
    @Override
    public boolean augment(final Short addend) throws IllegalArgumentException {
        int n = size();
        Short[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            Short originalValue = results[i];
            if (originalValue != null && addend != (short) 0) {
                results[i] = (short) (originalValue + addend);
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
    public boolean divide(final Short divisor) throws IllegalArgumentException {
        int n = size();
        Short[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            Short originalValue = results[i];
            if (originalValue != null && originalValue != (short) 0 && divisor != (short) 1) {
                results[i] = (short) (originalValue / divisor);
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
    public boolean multiply(final Short multiplicand) throws IllegalArgumentException {
        int n = size();
        Short[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            Short originalValue = results[i];
            if (originalValue != null && originalValue != (short) 0 && multiplicand != (short) 1) {
                results[i] = (short) (originalValue * multiplicand);
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
        Short[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < size(); i++) {
            Short originalValue = results[i];
            if (originalValue != null && originalValue != (short) 0) {
                results[i] = (short) (-originalValue);
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
     * Puts the content of an array with shorts into the shorts collection.
     *
     * @param results      An array with shorts that should be put into the shorts collection.
     * @param errorMessage The message to be used as the message for the {@link IllegalArgumentException}
     * @throws IllegalArgumentException If the results can't be put into the collection.
     */
    protected void putResults(final Short[] results, final String errorMessage) throws IllegalArgumentException {
        clear();
        for (Short n : results) {
            if (!add(n)) {
                throw new IllegalArgumentException(errorMessage);
            }
        }
    }

    @Override
    public boolean subtract(final Short subtrahend) throws IllegalArgumentException {
        int n = size();
        Short[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            Short originalValue = results[i];
            if (originalValue != null && subtrahend != (short) 0) {
                results[i] = (short) (originalValue - subtrahend);
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
    abstract ModifiableCollection<Short> getDecoratedCollection();

    @Override
    public boolean add(final Short element) {
        return getDecoratedCollection().add(element);
    }

    @Override
    public boolean addAll(final Collection<? extends Short> otherCollection) {
        return getDecoratedCollection().addAll(otherCollection);
    }

    @Override
    public void clear() {
        getDecoratedCollection().clear();
    }

    @Override
    public boolean remove(final Short element) {
        return getDecoratedCollection().remove(element);
    }

    @Override
    public boolean removeAll(final Collection<? extends Short> otherCollection) {
        return getDecoratedCollection().removeAll(otherCollection);
    }

    @Override
    public boolean removeIf(final Predicate<? super Short> predicate) {
        return getDecoratedCollection().removeIf(predicate);
    }

    @Override
    public boolean retainAll(final Collection<? extends Short> otherCollection) {
        return getDecoratedCollection().retainAll(otherCollection);
    }
}
