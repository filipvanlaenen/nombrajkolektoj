package net.filipvanlaenen.nombrajkolektoj;

import net.filipvanlaenen.kolektoj.Collection;

/**
 * Interface defining the signature for all numeric collections.
 *
 * @param <E> The element type.
 */
public interface NumericCollection<E extends Number> extends Collection<E> {
    E max();
    E min();
    E product();
    E sum();
}
