package net.filipvanlaenen.nombrajkolektoj;

import net.filipvanlaenen.kolektoj.OrderedCollection;

/**
 * Interface defining the signature for all ordered numeric collections.
 *
 * @param <N> The element type.
 */
public interface OrderedNumericCollection<N extends Number> extends NumericCollection<N>, OrderedCollection<N> {
}
