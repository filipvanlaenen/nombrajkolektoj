package net.filipvanlaenen.nombrajkolektoj.shorts;

import net.filipvanlaenen.nombrajkolektoj.UpdatableNumericMap;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.UpdatableNumericMap} for Shorts.
 *
 * @param <K> The key type.
 */
abstract class AbstractUpdatableShortMap<K> extends AbstractShortMap<K> implements UpdatableNumericMap<K, Short> {
    @Override
    public Short augment(final K key, final Short addend) {
        if (!containsKey(key)) {
            throw new IllegalArgumentException("Map doesn't contain an entry with the key " + key + ".");
        }
        Short oldValue = get(key);
        if (oldValue == null) {
            throw new IllegalArgumentException("The entry in the map with the key " + key + " contains null.");
        } else {
            return update(key, (short) (oldValue + addend));
        }
    }

    @Override
    public Short multiply(final K key, final Short multiplicand) {
        if (!containsKey(key)) {
            throw new IllegalArgumentException("Map doesn't contain an entry with the key " + key + ".");
        }
        Short oldValue = get(key);
        if (oldValue == null) {
            throw new IllegalArgumentException("The entry in the map with the key " + key + " contains null.");
        } else {
            return update(key, (short) (oldValue * multiplicand));
        }
    }

    @Override
    public Short negate(final K key) {
        if (!containsKey(key)) {
            throw new IllegalArgumentException("Map doesn't contain an entry with the key " + key + ".");
        }
        Short oldValue = get(key);
        if (oldValue == null) {
            throw new IllegalArgumentException("The entry in the map with the key " + key + " contains null.");
        } else {
            return update(key, (short) (-oldValue));
        }
    }
}
