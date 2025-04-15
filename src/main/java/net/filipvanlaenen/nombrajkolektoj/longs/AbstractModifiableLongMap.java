package net.filipvanlaenen.nombrajkolektoj.longs;

import net.filipvanlaenen.nombrajkolektoj.ModifiableNumericMap;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.ModifiableNumericMap} for Longs.
 *
 * @param <K> The key type.
 */
abstract class AbstractModifiableLongMap<K> extends AbstractUpdatableLongMap<K>
        implements ModifiableNumericMap<K, Long> {
}
