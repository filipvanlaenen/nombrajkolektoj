package net.filipvanlaenen.nombrajkolektoj;

import net.filipvanlaenen.kolektoj.ModifiableCollection;

public interface ModifiableNumericCollection<E extends Number> extends NumericCollection<E>, ModifiableCollection<E> {
    boolean multiply(E value);

    boolean negate();
}
