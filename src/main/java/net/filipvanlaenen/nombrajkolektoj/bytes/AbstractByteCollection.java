package net.filipvanlaenen.nombrajkolektoj.bytes;

import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.NumericCollection} for bytes.
 */
abstract class AbstractByteCollection implements NumericCollection<Byte> {
    @Override
    public Byte max() throws IndexOutOfBoundsException {
        if (size() == 0) {
            throw new IndexOutOfBoundsException("Cannot return a maximum for an empty collection.");
        }
        Byte max = null;
        for (Byte b : this) {
            // EQMU: Changing the conditional boundary below produces an equivalent mutant.
            if (b != null && (max == null || b > max)) {
                max = b;
            }
        }
        return max;
    }

    @Override
    public Byte min() throws IndexOutOfBoundsException {
        if (size() == 0) {
            throw new IndexOutOfBoundsException("Cannot return a minimum for an empty collection.");
        }
        Byte min = null;
        for (Byte b : this) {
            // EQMU: Changing the conditional boundary below produces an equivalent mutant.
            if (b != null && (min == null || b < min)) {
                min = b;
            }
        }
        return min;
    }

    @Override
    public Byte product() {
        Byte product = 1;
        for (Byte b : this) {
            if (b != null) {
                product = (byte) (product * b);
            }
        }
        return product;
    }

    @Override
    public Byte sum() {
        Byte sum = 0;
        for (Byte b : this) {
            if (b != null) {
                sum = (byte) (sum + b);
            }
        }
        return sum;
    }
}
