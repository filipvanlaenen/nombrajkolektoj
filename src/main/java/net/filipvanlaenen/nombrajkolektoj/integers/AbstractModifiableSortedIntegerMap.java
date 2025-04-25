package net.filipvanlaenen.nombrajkolektoj.integers;

import net.filipvanlaenen.nombrajkolektoj.ModifiableSortedNumericMap;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.ModifiableSortedNumericMap} for Integers.
 *
 * @param <K> The key type.
 */
abstract class AbstractModifiableSortedIntegerMap<K> extends AbstractModifiableIntegerMap<K>
        implements ModifiableSortedNumericMap<K, Integer> {
}
