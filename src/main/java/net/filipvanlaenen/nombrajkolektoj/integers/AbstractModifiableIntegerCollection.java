package net.filipvanlaenen.nombrajkolektoj.integers;

import net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection} for integers.
 */
abstract class AbstractModifiableIntegerCollection extends AbstractIntegerCollection
        implements ModifiableNumericCollection<Integer> {
    @Override
    public boolean augment(final Integer addend) {
        boolean result = false;
        for (Integer n : toArray()) {
            if (n != null && addend != 0) {
                remove(n);
                add(n + addend);
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean divide(final Integer divisor) {
        boolean result = false;
        for (Integer n : toArray()) {
            if (n != null && n != 0 && divisor != 1) {
                remove(n);
                add(n / divisor);
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean multiply(final Integer multiplicand) {
        boolean result = false;
        for (Integer n : toArray()) {
            if (n != null && n != 0 && multiplicand != 1) {
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
        for (Integer n : toArray()) {
            if (n != null && n != 0) {
                remove(n);
                add(-n);
                result = true;
            }
        }
        return result;
    }
}
