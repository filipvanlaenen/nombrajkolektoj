package net.filipvanlaenen.nombrajkolektoj.integers;

import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.NumericCollection} for integers.
 */
abstract class AbstractIntegerCollection implements NumericCollection<Integer> {
    @Override
    public Integer max() throws IndexOutOfBoundsException {
        if (size() == 0) {
            throw new IndexOutOfBoundsException("Cannot return a maximum for an empty collection.");
        }
        Integer max = null;
        for (Integer i : this) {
            // EQMU: Changing the conditional boundary below produces an equivalent mutant.
            if (i != null && (max == null || i > max)) {
                max = i;
            }
        }
        return max;
    }

    @Override
    public Integer min() throws IndexOutOfBoundsException {
        if (size() == 0) {
            throw new IndexOutOfBoundsException("Cannot return a minimum for an empty collection.");
        }
        Integer min = null;
        for (Integer i : this) {
            // EQMU: Changing the conditional boundary below produces an equivalent mutant.
            if (i != null && (min == null || i < min)) {
                min = i;
            }
        }
        return min;
    }

    @Override
    public Integer product() {
        Integer product = 1;
        for (Integer i : this) {
            if (i != null) {
                product *= i;
            }
        }
        return product;
    }

    @Override
    public Integer sum() {
        Integer sum = 0;
        for (Integer i : this) {
            if (i != null) {
                sum += i;
            }
        }
        return sum;
    }

    @Override
    public abstract Integer[] toArray();
}
