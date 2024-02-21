package net.filipvanlaenen.nombrajkolektoj.doubles;

import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

abstract class AbstractDoubleCollection implements NumericCollection<Double> {
    @Override
    public Double max() throws IndexOutOfBoundsException {
        if (size() == 0) {
            throw new IndexOutOfBoundsException("Cannot return a maximum from an empty collection.");
        }
        Double max = get();
        for (Double i : this) {
            if (i != null && (max == null || i > max)) {
                max = i;
            }
        }
        return max;
    }

    @Override
    public Double min() throws IndexOutOfBoundsException {
        if (size() == 0) {
            throw new IndexOutOfBoundsException("Cannot return a minimum from an empty collection.");
        }
        Double min = get();
        for (Double i : this) {
            if (i != null && (min == null || i < min)) {
                min = i;
            }
        }
        return min;
    }

    @Override
    public Double product() {
        Double product = 1D;
        for (Double i : this) {
            if (i != null) {
                product *= i;
            }
        }
        return product;
    }

    @Override
    public Double sum() {
        Double sum = 0D;
        for (Double i : this) {
            if (i != null) {
                sum += i;
            }
        }
        return sum;
    }
}
