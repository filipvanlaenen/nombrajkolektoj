package net.filipvanlaenen.nombrajkolektoj.floats;

import net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection} for floats.
 */
abstract class AbstractModifiableFloatCollection extends AbstractFloatCollection
        implements ModifiableNumericCollection<Float> {
    @Override
    public boolean augment(final Float addend) {
        boolean result = false;
        for (Float n : toArray()) {
            if (n != null && addend != 0F) {
                remove(n);
                add(n + addend);
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean multiply(final Float value) {
        boolean result = false;
        for (Float n : toArray()) {
            if (n != null && n != 0L && value != 1F) {
                remove(n);
                add(n * value);
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean negate() {
        boolean result = false;
        for (Float n : toArray()) {
            if (n != null && n != 0F) {
                remove(n);
                add(-n);
                result = true;
            }
        }
        return result;
    }
}
