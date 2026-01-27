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
    public boolean divide(final Float divisor) {
        boolean result = false;
        for (Float n : toArray()) {
            if (n != null && n != 0F && divisor != 1F) {
                remove(n);
                add(n / divisor);
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean multiply(final Float multiplicand) {
        boolean result = false;
        for (Float n : toArray()) {
            if (n != null && n != 0F && multiplicand != 1F) {
                remove(n);
                add(n * multiplicand);
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
