package net.filipvanlaenen.nombrajkolektoj.integers;

import net.filipvanlaenen.nombrajkolektoj.ModifiableNumericMap;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.ModifiableNumericMap} for Integers.
 *
 * @param <K> The key type.
 */
abstract class AbstractModifiableIntegerMap<K> extends AbstractUpdatableIntegerMap<K>
        implements ModifiableNumericMap<K, Integer> {
}
