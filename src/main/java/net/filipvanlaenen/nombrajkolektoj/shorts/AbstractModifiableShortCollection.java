package net.filipvanlaenen.nombrajkolektoj.shorts;

import net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection} for shorts.
 */
abstract class AbstractModifiableShortCollection extends AbstractShortCollection
        implements ModifiableNumericCollection<Short> {
    @Override
    public boolean augment(final Short addend) {
        boolean result = false;
        for (Short n : toArray()) {
            if (n != null && addend != (short) 0) {
                remove(n);
                add((short) (n + addend));
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean multiply(final Short value) {
        boolean result = false;
        for (Short n : toArray()) {
            if (n != null && n != (short) 0 && value != (short) 1) {
                remove(n);
                add((short) (n * value));
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean negate() {
        boolean result = false;
        for (Short n : toArray()) {
            if (n != null && n != (short) 0) {
                remove(n);
                add((short) (-n));
                result = true;
            }
        }
        return result;
    }
}
