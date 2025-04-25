package net.filipvanlaenen.nombrajkolektoj.doubles;

import net.filipvanlaenen.nombrajkolektoj.ModifiableSortedNumericMap;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.ModifiableSortedNumericMap} for Doubles.
 *
 * @param <K> The key type.
 */
abstract class AbstractModifiableSortedDoubleMap<K> extends AbstractModifiableDoubleMap<K>
        implements ModifiableSortedNumericMap<K, Double> {
}
