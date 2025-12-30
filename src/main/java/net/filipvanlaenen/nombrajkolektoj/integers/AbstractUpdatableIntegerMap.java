package net.filipvanlaenen.nombrajkolektoj.integers;

import net.filipvanlaenen.nombrajkolektoj.UpdatableNumericMap;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.UpdatableNumericMap} for Integers.
 *
 * @param <K> The key type.
 */
abstract class AbstractUpdatableIntegerMap<K> extends AbstractIntegerMap<K> implements UpdatableNumericMap<K, Integer> {
    @Override
    public Integer augment(final K key, final Integer addend) {
        if (!containsKey(key)) {
            throw new IllegalArgumentException("Map doesn't contain an entry with the key " + key + ".");
        }
        Integer oldValue = get(key);
        if (oldValue == null) {
            throw new IllegalArgumentException("The entry in the map with the key " + key + " contains null.");
        } else {
            update(key, oldValue, oldValue + addend);
            return oldValue;
        }
    }

    @Override
    public Integer multiply(final K key, final Integer multiplicand) {
        if (!containsKey(key)) {
            throw new IllegalArgumentException("Map doesn't contain an entry with the key " + key + ".");
        }
        Integer oldValue = get(key);
        if (oldValue == null) {
            throw new IllegalArgumentException("The entry in the map with the key " + key + " contains null.");
        } else {
            update(key, oldValue, oldValue * multiplicand);
            return oldValue;
        }
    }

    @Override
    public Integer negate(final K key) {
        if (!containsKey(key)) {
            throw new IllegalArgumentException("Map doesn't contain an entry with the key " + key + ".");
        }
        Integer oldValue = get(key);
        if (oldValue == null) {
            throw new IllegalArgumentException("The entry in the map with the key " + key + " contains null.");
        } else {
            update(key, oldValue, -oldValue);
            return oldValue;
        }
    }

    @Override
    public Integer subtract(final K key, final Integer subtrahend) {
        if (!containsKey(key)) {
            throw new IllegalArgumentException("Map doesn't contain an entry with the key " + key + ".");
        }
        Integer oldValue = get(key);
        if (oldValue == null) {
            throw new IllegalArgumentException("The entry in the map with the key " + key + " contains null.");
        } else {
            update(key, oldValue, oldValue - subtrahend);
            return oldValue;
        }
    }
}
