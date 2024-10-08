package net.filipvanlaenen.nombrajkolektoj.longs;

import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.NumericCollection} for longs.
 */
abstract class AbstractLongCollection implements NumericCollection<Long> {
    @Override
    public Long max() throws IndexOutOfBoundsException {
        if (size() == 0) {
            throw new IndexOutOfBoundsException("Cannot return a maximum for an empty collection.");
        }
        Long max = null;
        for (Long n : this) {
            // EQMU: Changing the conditional boundary below produces an equivalent mutant.
            if (n != null && (max == null || n > max)) {
                max = n;
            }
        }
        return max;
    }

    @Override
    public Long min() throws IndexOutOfBoundsException {
        if (size() == 0) {
            throw new IndexOutOfBoundsException("Cannot return a minimum for an empty collection.");
        }
        Long min = null;
        for (Long n : this) {
            // EQMU: Changing the conditional boundary below produces an equivalent mutant.
            if (n != null && (min == null || n < min)) {
                min = n;
            }
        }
        return min;
    }

    @Override
    public Long product() {
        Long product = 1L;
        for (Long n : this) {
            if (n != null) {
                product *= n;
            }
        }
        return product;
    }

    @Override
    public Long sum() {
        Long sum = 0L;
        for (Long n : this) {
            if (n != null) {
                sum += n;
            }
        }
        return sum;
    }

    @Override
    public abstract Long[] toArray();
}
