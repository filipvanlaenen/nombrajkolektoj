package net.filipvanlaenen.nombrajkolektoj.doubles;

import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.NumericCollection} for doubles.
 */
abstract class AbstractDoubleCollection implements NumericCollection<Double> {
    @Override
    public Double max() throws IndexOutOfBoundsException {
        if (size() == 0) {
            throw new IndexOutOfBoundsException("Cannot return a maximum for an empty collection.");
        }
        Double max = null;
        for (Double n : this) {
            // EQMU: Changing the conditional boundary below produces an equivalent mutant.
            if (n != null && (max == null || n > max)) {
                max = n;
            }
        }
        return max;
    }

    @Override
    public Double min() throws IndexOutOfBoundsException {
        if (size() == 0) {
            throw new IndexOutOfBoundsException("Cannot return a minimum for an empty collection.");
        }
        Double min = null;
        for (Double n : this) {
            // EQMU: Changing the conditional boundary below produces an equivalent mutant.
            if (n != null && (min == null || n < min)) {
                min = n;
            }
        }
        return min;
    }

    @Override
    public Double product() {
        Double product = 1D;
        for (Double n : this) {
            if (n != null) {
                product *= n;
            }
        }
        return product;
    }

    @Override
    public Double sum() {
        Double sum = 0D;
        for (Double n : this) {
            if (n != null) {
                sum += n;
            }
        }
        return sum;
    }

    @Override
    public abstract Double[] toArray();
}
