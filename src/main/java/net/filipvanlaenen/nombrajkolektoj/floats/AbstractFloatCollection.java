package net.filipvanlaenen.nombrajkolektoj.floats;

import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.NumericCollection} for floats.
 */
abstract class AbstractFloatCollection implements NumericCollection<Float> {
    @Override
    public Float max() throws IndexOutOfBoundsException {
        if (size() == 0) {
            throw new IndexOutOfBoundsException("Cannot return a maximum for an empty collection.");
        }
        Float max = null;
        for (Float n : this) {
            // EQMU: Changing the conditional boundary below produces an equivalent mutant.
            if (n != null && (max == null || n > max)) {
                max = n;
            }
        }
        return max;
    }

    @Override
    public Float min() throws IndexOutOfBoundsException {
        if (size() == 0) {
            throw new IndexOutOfBoundsException("Cannot return a minimum for an empty collection.");
        }
        Float min = null;
        for (Float n : this) {
            // EQMU: Changing the conditional boundary below produces an equivalent mutant.
            if (n != null && (min == null || n < min)) {
                min = n;
            }
        }
        return min;
    }

    @Override
    public Float product() {
        Float product = 1F;
        for (Float n : this) {
            if (n != null) {
                product *= n;
            }
        }
        return product;
    }

    @Override
    public Float sum() {
        Float sum = 0F;
        for (Float n : this) {
            if (n != null) {
                sum += n;
            }
        }
        return sum;
    }

    @Override
    public abstract Float[] toArray();
}
