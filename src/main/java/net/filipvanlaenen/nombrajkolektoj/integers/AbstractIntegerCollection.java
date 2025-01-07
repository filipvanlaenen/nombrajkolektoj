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
        for (Integer n : this) {
            // EQMU: Changing the conditional boundary below produces an equivalent mutant.
            if (n != null && (max == null || n > max)) {
                max = n;
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
        for (Integer n : this) {
            // EQMU: Changing the conditional boundary below produces an equivalent mutant.
            if (n != null && (min == null || n < min)) {
                min = n;
            }
        }
        return min;
    }

    @Override
    public Integer product() {
        Integer product = 1;
        for (Integer n : this) {
            if (n != null) {
                product *= n;
            }
        }
        return product;
    }

    @Override
    public Integer sum() {
        Integer sum = 0;
        for (Integer n : this) {
            if (n != null) {
                sum += n;
            }
        }
        return sum;
    }

    @Override
    public abstract Integer[] toArray();
}
