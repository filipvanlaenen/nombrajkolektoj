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
        for (Integer i : toArray()) {
            if (i != null && addend != 0) {
                remove(i);
                add(i + addend);
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean multiply(final Integer multiplicand) {
        boolean result = false;
        for (Integer i : toArray()) {
            if (i != null && i != i * multiplicand) {
                remove(i);
                add(i * multiplicand);
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean negate() {
        boolean result = false;
        for (Integer i : toArray()) {
            if (i != null && i != 0) {
                remove(i);
                add(-i);
                result = true;
            }
        }
        return result;
    }
}
