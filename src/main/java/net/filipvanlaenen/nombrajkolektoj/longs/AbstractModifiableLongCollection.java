package net.filipvanlaenen.nombrajkolektoj.longs;

import net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection;

abstract class AbstractModifiableLongCollection extends AbstractLongCollection
        implements ModifiableNumericCollection<Long> {
    @Override
    public boolean augment(final Long addend) {
        boolean result = false;
        for (Long i : toArray()) {
            if (i != null && i != i + addend) {
                remove(i);
                add(i + addend);
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean multiply(final Long value) {
        boolean result = false;
        for (Long i : toArray()) {
            if (i != null && i != i * value) {
                remove(i);
                add(i * value);
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean negate() {
        boolean result = false;
        for (Long i : toArray()) {
            if (i != null && i != 0) {
                remove(i);
                add(-i);
                result = true;
            }
        }
        return result;
    }
}
