package net.filipvanlaenen.nombrajkolektoj.integers;

import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

abstract class AbstractIntegerCollection implements NumericCollection<Integer> {
    @Override
    public Integer max() throws IndexOutOfBoundsException {
        if (size() == 0) {
            throw new IndexOutOfBoundsException("Cannot return a maximum from an empty collection.");
        }
        Integer max = get();
        for (Integer i : this) {
            if (i != null && (max == null || i > max)) {
                max = i;
            }
        }
        return max;
    }

    @Override
    public Integer min() throws IndexOutOfBoundsException {
        if (size() == 0) {
            throw new IndexOutOfBoundsException("Cannot return a minimum from an empty collection.");
        }
        Integer min = get();
        for (Integer i : this) {
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
}
