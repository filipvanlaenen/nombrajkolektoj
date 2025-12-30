package net.filipvanlaenen.nombrajkolektoj.bytes;

import net.filipvanlaenen.nombrajkolektoj.UpdatableNumericMap;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.UpdatableNumericMap} for Bytes.
 *
 * @param <K> The key type.
 */
abstract class AbstractUpdatableByteMap<K> extends AbstractByteMap<K> implements UpdatableNumericMap<K, Byte> {
    @Override
    public Byte augment(final K key, final Byte addend) {
        if (!containsKey(key)) {
            throw new IllegalArgumentException("Map doesn't contain an entry with the key " + key + ".");
        }
        Byte oldValue = get(key);
        if (oldValue == null) {
            throw new IllegalArgumentException("The entry in the map with the key " + key + " contains null.");
        } else {
            update(key, oldValue, (byte) (oldValue + addend));
            return oldValue;
        }
    }

    @Override
    public Byte multiply(final K key, final Byte multiplicand) {
        if (!containsKey(key)) {
            throw new IllegalArgumentException("Map doesn't contain an entry with the key " + key + ".");
        }
        Byte oldValue = get(key);
        if (oldValue == null) {
            throw new IllegalArgumentException("The entry in the map with the key " + key + " contains null.");
        } else {
            update(key, oldValue, (byte) (oldValue * multiplicand));
            return oldValue;
        }
    }

    @Override
    public Byte negate(final K key) {
        if (!containsKey(key)) {
            throw new IllegalArgumentException("Map doesn't contain an entry with the key " + key + ".");
        }
        Byte oldValue = get(key);
        if (oldValue == null) {
            throw new IllegalArgumentException("The entry in the map with the key " + key + " contains null.");
        } else {
            update(key, oldValue, (byte) (-oldValue));
            return oldValue;
        }
    }

    @Override
    public Byte subtract(final K key, final Byte subtrahend) {
        if (!containsKey(key)) {
            throw new IllegalArgumentException("Map doesn't contain an entry with the key " + key + ".");
        }
        Byte oldValue = get(key);
        if (oldValue == null) {
            throw new IllegalArgumentException("The entry in the map with the key " + key + " contains null.");
        } else {
            update(key, oldValue, (byte) (oldValue - subtrahend));
            return oldValue;
        }
    }
}
