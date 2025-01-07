package net.filipvanlaenen.nombrajkolektoj;

import net.filipvanlaenen.kolektoj.SortedCollection;

/**
 * Interface defining the signature for all sorted numeric collections.
 *
 * @param <N> The element type.
 */
public interface SortedNumericCollection<N extends Number> extends OrderedNumericCollection<N>, SortedCollection<N> {
}
