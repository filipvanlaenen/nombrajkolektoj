package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

import net.filipvanlaenen.nombrajkolektoj.UpdatableNumericMap;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.UpdatableNumericMap} for BigIntegers.
 *
 * @param <K> The key type.
 */
abstract class AbstractUpdatableBigIntegerMap<K> extends AbstractBigIntegerMap<K> implements UpdatableNumericMap<K, BigInteger> {
    @Override
    public BigInteger augment(final K key, final BigInteger addend) {
        if (!containsKey(key)) {
            throw new IllegalArgumentException("Map doesn't contain an entry with the key " + key + ".");
        }
        BigInteger oldValue = get(key);
        if (oldValue == null) {
            throw new IllegalArgumentException("The entry in the map with the key " + key + " contains null.");
        } else {
            return update(key, oldValue.add(addend));
        }
    }

    @Override
    public BigInteger multiply(final K key, final BigInteger multiplicand) {
        if (!containsKey(key)) {
            throw new IllegalArgumentException("Map doesn't contain an entry with the key " + key + ".");
        }
        BigInteger oldValue = get(key);
        if (oldValue == null) {
            throw new IllegalArgumentException("The entry in the map with the key " + key + " contains null.");
        } else {
            return update(key, oldValue.multiply(multiplicand));
        }
    }

    @Override
    public BigInteger negate(final K key) {
        if (!containsKey(key)) {
            throw new IllegalArgumentException("Map doesn't contain an entry with the key " + key + ".");
        }
        BigInteger oldValue = get(key);
        if (oldValue == null) {
            throw new IllegalArgumentException("The entry in the map with the key " + key + " contains null.");
        } else {
            return update(key, oldValue.negate());
        }
    }
}
