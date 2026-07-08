package net.filipvanlaenen.nombrajkolektoj;

import net.filipvanlaenen.kolektoj.OrderedCollection;

/**
 * An ordered numeric collection. It doesn't support any new functionality in addition to the functionality of ordered
 * collections in general and numeric collections.
 *
 * @param <N> The numeric element type.
 */
public interface OrderedNumericCollection<N extends Number> extends NumericCollection<N>, OrderedCollection<N> {
}
