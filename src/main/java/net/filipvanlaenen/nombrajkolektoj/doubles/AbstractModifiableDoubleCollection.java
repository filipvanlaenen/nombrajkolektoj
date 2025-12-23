package net.filipvanlaenen.nombrajkolektoj.doubles;

import net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection} for doubles.
 */
abstract class AbstractModifiableDoubleCollection extends AbstractDoubleCollection
        implements ModifiableNumericCollection<Double> {
    @Override
    public boolean augment(final Double addend) {
        boolean result = false;
        for (Double n : toArray()) {
            if (n != null && addend != 0D) {
                remove(n);
                add(n + addend);
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean multiply(final Double multiplicand) {
        boolean result = false;
        for (Double n : toArray()) {
            if (n != null && n != 0D && multiplicand != 1D) {
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
        for (Double n : toArray()) {
            if (n != null && n != 0D) {
                remove(n);
                add(-n);
                result = true;
            }
        }
        return result;
    }
}
