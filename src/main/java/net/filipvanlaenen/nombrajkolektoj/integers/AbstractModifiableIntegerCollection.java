package net.filipvanlaenen.nombrajkolektoj.integers;

import net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection;

abstract class AbstractModifiableIntegerCollection extends AbstractIntegerCollection
        implements ModifiableNumericCollection<Integer> {
    @Override
    public boolean multiply(final Integer value) {
        boolean result = false;
        for (Integer i : toArray()) {
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
