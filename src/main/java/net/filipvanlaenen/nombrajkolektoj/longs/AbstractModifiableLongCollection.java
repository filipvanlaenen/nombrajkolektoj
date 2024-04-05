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
        for (Long l : toArray()) {
            if (l != null && addend != 0L) {
                remove(l);
                add(l + addend);
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean multiply(final Long value) {
        boolean result = false;
        for (Long l : toArray()) {
            if (l != null && l != 0L && value != 1L) {
                remove(l);
                add(l * value);
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean negate() {
        boolean result = false;
        for (Long l : toArray()) {
            if (l != null && l != 0L) {
                remove(l);
                add(-l);
                result = true;
            }
        }
        return result;
    }
}
