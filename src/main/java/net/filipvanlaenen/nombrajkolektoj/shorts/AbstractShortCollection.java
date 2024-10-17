package net.filipvanlaenen.nombrajkolektoj.shorts;

import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.NumericCollection} for shorts.
 */
abstract class AbstractShortCollection implements NumericCollection<Short> {
    @Override
    public Short max() throws IndexOutOfBoundsException {
        if (size() == 0) {
            throw new IndexOutOfBoundsException("Cannot return a maximum for an empty collection.");
        }
        Short max = null;
        for (Short n : this) {
            // EQMU: Changing the conditional boundary below produces an equivalent mutant.
            if (n != null && (max == null || n > max)) {
                max = n;
            }
        }
        return max;
    }

    @Override
    public Short min() throws IndexOutOfBoundsException {
        if (size() == 0) {
            throw new IndexOutOfBoundsException("Cannot return a minimum for an empty collection.");
        }
        Short min = null;
        for (Short n : this) {
            // EQMU: Changing the conditional boundary below produces an equivalent mutant.
            if (n != null && (min == null || n < min)) {
                min = n;
            }
        }
        return min;
    }

    @Override
    public Short product() {
        Short product = (short) 1;
        for (Short n : this) {
            if (n != null) {
                product = (short) (product * n);
            }
        }
        return product;
    }

    @Override
    public Short sum() {
        Short sum = (short) 0;
        for (Short n : this) {
            if (n != null) {
                sum = (short) (sum + n);
            }
        }
        return sum;
    }

    @Override
    public abstract Short[] toArray();
}
