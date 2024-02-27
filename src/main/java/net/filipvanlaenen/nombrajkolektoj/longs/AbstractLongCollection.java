package net.filipvanlaenen.nombrajkolektoj.longs;

import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.NumericCollection} for longs.
 */
abstract class AbstractLongCollection implements NumericCollection<Long> {
    @Override
    public Long max() {
        if (size() == 0) {
            throw new IndexOutOfBoundsException("Cannot return a maximum for an empty collection.");
        }
        Long max = null;
        for (Long l : this) {
            // EQMU: Changing the conditional boundary below produces an equivalent mutant.
            if (l != null && (max == null || l > max)) {
                max = l;
            }
        }
        return max;
    }

    @Override
    public Long min() {
        if (size() == 0) {
            throw new IndexOutOfBoundsException("Cannot return a minimum for an empty collection.");
        }
        Long min = get();
        for (Long l : this) {
            // EQMU: Changing the conditional boundary below produces an equivalent mutant.
            if (l != null && (min == null || l < min)) {
                min = l;
            }
        }
        return min;
    }

    @Override
    public Long product() {
        Long product = 1L;
        for (Long l : this) {
            if (l != null) {
                product *= l;
            }
        }
        return product;
    }

    @Override
    public Long sum() {
        Long sum = 0L;
        for (Long l : this) {
            if (l != null) {
                sum += l;
            }
        }
        return sum;
    }
}
