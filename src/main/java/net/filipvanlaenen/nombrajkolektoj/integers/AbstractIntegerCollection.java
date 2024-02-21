package net.filipvanlaenen.nombrajkolektoj.integers;

import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

abstract class AbstractIntegerCollection implements NumericCollection<Integer> {
    @Override
    public Integer max() {
        if (size() == 0) {
            return null;
        }
        Integer max = get();
        for (Integer i : this) {
            if (i == null) {
                return null;
            }
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    @Override
    public Integer min() {
        if (size() == 0) {
            return null;
        }
        Integer min = get();
        for (Integer i : this) {
            if (i == null) {
                return null;
            }
            if (i < min) {
                min = i;
            }
        }
        return min;
    }

    @Override
    public Integer product() {
        Integer product = 1;
        for (Integer i : this) {
            if (i == null) {
                return null;
            }
            product *= i;
        }
        return product;
    }

    @Override
    public Integer sum() {
        Integer sum = 0;
        for (Integer i : this) {
            if (i == null) {
                return null;
            }
            sum += i;
        }
        return sum;
    }
}
