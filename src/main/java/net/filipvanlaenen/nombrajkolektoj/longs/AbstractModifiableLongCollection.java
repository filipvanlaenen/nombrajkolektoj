package net.filipvanlaenen.nombrajkolektoj.longs;

import net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection} for longs.
 */
abstract class AbstractModifiableLongCollection extends AbstractLongCollection
        implements ModifiableNumericCollection<Long> {
    @Override
    public boolean augment(final Long addend) {
        boolean result = false;
        for (Long n : toArray()) {
            if (n != null && addend != 0L) {
                remove(n);
                add(n + addend);
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean multiply(final Long value) {
        boolean result = false;
        for (Long n : toArray()) {
            if (n != null && n != 0L && value != 1L) {
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
        for (Long n : toArray()) {
            if (n != null && n != 0L) {
                remove(n);
                add(-n);
                result = true;
            }
        }
        return result;
    }
}
