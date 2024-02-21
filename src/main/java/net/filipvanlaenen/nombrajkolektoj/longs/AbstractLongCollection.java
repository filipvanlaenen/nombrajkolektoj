package net.filipvanlaenen.nombrajkolektoj.longs;

import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

abstract class AbstractLongCollection implements NumericCollection<Long> {
    @Override
    public Long max() {
        if (size() == 0) {
            return null;
        }
        Long max = get();
        for (Long i : this) {
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
    public Long min() {
        if (size() == 0) {
            return null;
        }
        Long min = get();
        for (Long i : this) {
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
    public Long product() {
        Long product = 1L;
        for (Long i : this) {
            if (i == null) {
                return null;
            }
            product *= i;
        }
        return product;
    }

    @Override
    public Long sum() {
        Long sum = 0L;
        for (Long i : this) {
            if (i == null) {
                return null;
            }
            sum += i;
        }
        return sum;
    }
}
