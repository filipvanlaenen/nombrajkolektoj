package net.filipvanlaenen.nombrajkolektoj;

import net.filipvanlaenen.kolektoj.ModifiableSortedCollection;

/**
 * Interface defining the signature for all modifiable sorted numeric collections.
 *
 * @param <N> The element type.
 */
public interface ModifiableSortedNumericCollection<N extends Number>
        extends ModifiableNumericCollection<N>, SortedNumericCollection<N>, ModifiableSortedCollection<N> {
}
