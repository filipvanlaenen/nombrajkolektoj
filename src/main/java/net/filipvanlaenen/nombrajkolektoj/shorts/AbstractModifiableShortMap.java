package net.filipvanlaenen.nombrajkolektoj.shorts;

import net.filipvanlaenen.nombrajkolektoj.ModifiableNumericMap;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.ModifiableNumericMap} for Shorts.
 *
 * @param <K> The key type.
 */
abstract class AbstractModifiableShortMap<K> extends AbstractUpdatableShortMap<K>
        implements ModifiableNumericMap<K, Short> {
}
