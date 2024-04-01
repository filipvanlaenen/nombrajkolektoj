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
        for (Double d : this) {
            // EQMU: Changing the conditional boundary below produces an equivalent mutant.
            if (d != null && (max == null || d > max)) {
                max = d;
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
        for (Double d : this) {
            // EQMU: Changing the conditional boundary below produces an equivalent mutant.
            if (d != null && (min == null || d < min)) {
                min = d;
            }
        }
        return min;
    }

    @Override
    public Double product() {
        Double product = 1D;
        for (Double d : this) {
            if (d != null) {
                product *= d;
            }
        }
        return product;
    }

    @Override
    public Double sum() {
        Double sum = 0D;
        for (Double d : this) {
            if (d != null) {
                sum += d;
            }
        }
        return sum;
    }
}
