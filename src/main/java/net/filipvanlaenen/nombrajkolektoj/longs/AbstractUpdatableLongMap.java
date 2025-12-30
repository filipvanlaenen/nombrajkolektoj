package net.filipvanlaenen.nombrajkolektoj.longs;

import net.filipvanlaenen.nombrajkolektoj.UpdatableNumericMap;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.UpdatableNumericMap} for Longs.
 *
 * @param <K> The key type.
 */
abstract class AbstractUpdatableLongMap<K> extends AbstractLongMap<K> implements UpdatableNumericMap<K, Long> {
    @Override
    public Long augment(final K key, final Long addend) {
        if (!containsKey(key)) {
            throw new IllegalArgumentException("Map doesn't contain an entry with the key " + key + ".");
        }
        Long oldValue = get(key);
        if (oldValue == null) {
            throw new IllegalArgumentException("The entry in the map with the key " + key + " contains null.");
        } else {
            update(key, oldValue, oldValue + addend);
            return oldValue;
        }
    }

    @Override
    public Long multiply(final K key, final Long multiplicand) {
        if (!containsKey(key)) {
            throw new IllegalArgumentException("Map doesn't contain an entry with the key " + key + ".");
        }
        Long oldValue = get(key);
        if (oldValue == null) {
            throw new IllegalArgumentException("The entry in the map with the key " + key + " contains null.");
        } else {
            update(key, oldValue, oldValue * multiplicand);
            return oldValue;
        }
    }

    @Override
    public Long negate(final K key) {
        if (!containsKey(key)) {
            throw new IllegalArgumentException("Map doesn't contain an entry with the key " + key + ".");
        }
        Long oldValue = get(key);
        if (oldValue == null) {
            throw new IllegalArgumentException("The entry in the map with the key " + key + " contains null.");
        } else {
            update(key, oldValue, -oldValue);
            return oldValue;
        }
    }

    @Override
    public Long subtract(final K key, final Long subtrahend) {
        if (!containsKey(key)) {
            throw new IllegalArgumentException("Map doesn't contain an entry with the key " + key + ".");
        }
        Long oldValue = get(key);
        if (oldValue == null) {
            throw new IllegalArgumentException("The entry in the map with the key " + key + " contains null.");
        } else {
            update(key, oldValue, oldValue - subtrahend);
            return oldValue;
        }
    }
}
