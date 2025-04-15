package net.filipvanlaenen.nombrajkolektoj.bytes;

import net.filipvanlaenen.nombrajkolektoj.ModifiableNumericMap;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.ModifiableNumericMap} for Bytes.
 *
 * @param <K> The key type.
 */
abstract class AbstractModifiableByteMap<K> extends AbstractUpdatableByteMap<K>
        implements ModifiableNumericMap<K, Byte> {
}
