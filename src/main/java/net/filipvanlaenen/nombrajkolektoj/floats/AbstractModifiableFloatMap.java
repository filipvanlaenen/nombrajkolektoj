package net.filipvanlaenen.nombrajkolektoj.floats;

import net.filipvanlaenen.nombrajkolektoj.ModifiableNumericMap;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.ModifiableNumericMap} for Floats.
 *
 * @param <K> The key type.
 */
abstract class AbstractModifiableFloatMap<K> extends AbstractUpdatableFloatMap<K>
        implements ModifiableNumericMap<K, Float> {
}
