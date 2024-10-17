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
            if (n != null && addend != 0L) {
                remove(n);
                add((byte) (n + addend));
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean multiply(final Byte value) {
        boolean result = false;
        for (Byte n : toArray()) {
            if (n != null && n != 0L && value != (byte) 1) {
                remove(n);
                add((byte) (n * value));
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
