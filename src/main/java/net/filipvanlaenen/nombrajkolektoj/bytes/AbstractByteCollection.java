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
        for (Byte n : this) {
            // EQMU: Changing the conditional boundary below produces an equivalent mutant.
            if (n != null && (max == null || n > max)) {
                max = n;
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
        for (Byte n : this) {
            // EQMU: Changing the conditional boundary below produces an equivalent mutant.
            if (n != null && (min == null || n < min)) {
                min = n;
            }
        }
        return min;
    }

    @Override
    public Byte product() {
        Byte product = (byte) 1;
        for (Byte n : this) {
            if (n != null) {
                product = (byte) (product * n);
            }
        }
        return product;
    }

    @Override
    public Byte sum() {
        Byte sum = (byte) 0;
        for (Byte n : this) {
            if (n != null) {
                sum = (byte) (sum + n);
            }
        }
        return sum;
    }

    @Override
    public abstract Byte[] toArray();
}
