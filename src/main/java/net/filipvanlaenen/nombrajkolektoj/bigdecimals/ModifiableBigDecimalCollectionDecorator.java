package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import java.util.function.Predicate;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.ModifiableCollection;

/**
 * An abstract decorator class providing implementations for the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.BigDecimals.ModifiableBigDecimalCollection} interface.
 */
abstract class ModifiableBigDecimalCollectionDecorator extends BigDecimalCollectionDecorator
        implements ModifiableBigDecimalCollection {
    @Override
    public boolean add(final BigDecimal element) {
        return getDecoratedCollection().add(element);
    }

    @Override
    public boolean addAll(final Collection<? extends BigDecimal> otherCollection) {
        return getDecoratedCollection().addAll(otherCollection);
    }

    @Override
    public boolean augment(final BigDecimal addend) throws IllegalArgumentException {
        int n = size();
        BigDecimal[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            BigDecimal originalValue = results[i];
            if (originalValue != null && addend != BigDecimal.ZERO) {
                results[i] = originalValue.add(addend);
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
    public boolean divide(final BigDecimal divisor) throws IllegalArgumentException {
        int n = size();
        BigDecimal[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            BigDecimal originalValue = results[i];
            if (originalValue != null && originalValue != BigDecimal.ZERO && divisor != BigDecimal.ONE) {
                results[i] = originalValue.divide(divisor);
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
    abstract ModifiableCollection<BigDecimal> getDecoratedCollection();

    @Override
    public boolean multiply(final BigDecimal multiplicand) throws IllegalArgumentException {
        int n = size();
        BigDecimal[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            BigDecimal originalValue = results[i];
            if (originalValue != null && originalValue != BigDecimal.ZERO && multiplicand != BigDecimal.ONE) {
                results[i] = originalValue.multiply(multiplicand);
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
        BigDecimal[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < size(); i++) {
            BigDecimal originalValue = results[i];
            if (originalValue != null && originalValue != BigDecimal.ZERO) {
                results[i] = originalValue.negate();
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
     * Puts the content of an array with BigDecimals into the BigDecimals collection.
     *
     * @param results      An array with BigDecimals that should be put into the BigDecimals collection.
     * @param errorMessage The message to be used as the message for the {@link IllegalArgumentException}
     * @throws IllegalArgumentException If the results can't be put into the collection.
     */
    protected void putResults(final BigDecimal[] results, final String errorMessage) throws IllegalArgumentException {
        clear();
        for (BigDecimal n : results) {
            if (!add(n)) {
                throw new IllegalArgumentException(errorMessage);
            }
        }
    }

    @Override
    public boolean remove(final BigDecimal element) {
        return getDecoratedCollection().remove(element);
    }

    @Override
    public boolean removeAll(final Collection<? extends BigDecimal> otherCollection) {
        return getDecoratedCollection().removeAll(otherCollection);
    }

    @Override
    public boolean removeIf(final Predicate<? super BigDecimal> predicate) {
        return getDecoratedCollection().removeIf(predicate);
    }

    @Override
    public boolean retainAll(final Collection<? extends BigDecimal> otherCollection) {
        return getDecoratedCollection().retainAll(otherCollection);
    }

    @Override
    public boolean subtract(final BigDecimal subtrahend) throws IllegalArgumentException {
        int n = size();
        BigDecimal[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            BigDecimal originalValue = results[i];
            if (originalValue != null && subtrahend != BigDecimal.ZERO) {
                results[i] = originalValue.subtract(subtrahend);
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
