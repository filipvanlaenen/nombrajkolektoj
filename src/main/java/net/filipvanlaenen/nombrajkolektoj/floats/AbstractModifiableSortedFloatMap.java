package net.filipvanlaenen.nombrajkolektoj.floats;

import net.filipvanlaenen.nombrajkolektoj.ModifiableSortedNumericMap;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.ModifiableSortedNumericMap} for Floats.
 *
 * @param <K> The key type.
 */
abstract class AbstractModifiableSortedFloatMap<K> extends AbstractModifiableFloatMap<K>
        implements ModifiableSortedNumericMap<K, Float> {
}
