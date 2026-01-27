package net.filipvanlaenen.nombrajkolektoj.bytes;

import net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection} for bytes.
 */
abstract class AbstractModifiableByteCollection extends AbstractByteCollection
        implements ModifiableNumericCollection<Byte> {
    @Override
    public boolean augment(final Byte addend) {
        boolean result = false;
        for (Byte n : toArray()) {
            if (n != null && addend != (byte) 0) {
                remove(n);
                add((byte) (n + addend));
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean divide(final Byte divisor) {
        boolean result = false;
        for (Byte n : toArray()) {
            if (n != null && n != (byte) 0 && divisor != (byte) 1) {
                remove(n);
                add((byte) (n / divisor));
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean multiply(final Byte multiplicand) {
        boolean result = false;
        for (Byte n : toArray()) {
            if (n != null && n != (byte) 0 && multiplicand != (byte) 1) {
                remove(n);
                add((byte) (n * multiplicand));
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean negate() {
        boolean result = false;
        for (Byte n : toArray()) {
            if (n != null && n != (byte) 0) {
                remove(n);
                add((byte) (-n));
                result = true;
            }
        }
        return result;
    }
}
