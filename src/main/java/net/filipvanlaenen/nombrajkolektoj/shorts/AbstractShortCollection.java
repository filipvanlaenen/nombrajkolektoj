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
        for (Short s : this) {
            // EQMU: Changing the conditional boundary below produces an equivalent mutant.
            if (s != null && (max == null || s > max)) {
                max = s;
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
        for (Short s : this) {
            // EQMU: Changing the conditional boundary below produces an equivalent mutant.
            if (s != null && (min == null || s < min)) {
                min = s;
            }
        }
        return min;
    }

    @Override
    public Short product() {
        Short product = 1;
        for (Short s : this) {
            if (s != null) {
                product = (short) (product * s);
            }
        }
        return product;
    }

    @Override
    public Short sum() {
        Short sum = 0;
        for (Short s : this) {
            if (s != null) {
                sum = (short) (sum + s);
            }
        }
        return sum;
    }
}
