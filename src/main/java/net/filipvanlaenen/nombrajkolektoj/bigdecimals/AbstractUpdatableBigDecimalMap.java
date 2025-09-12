package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import net.filipvanlaenen.nombrajkolektoj.UpdatableNumericMap;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.UpdatableNumericMap} for BigDecimals.
 *
 * @param <K> The key type.
 */
abstract class AbstractUpdatableBigDecimalMap<K> extends AbstractBigDecimalMap<K> implements UpdatableNumericMap<K, BigDecimal> {
    @Override
    public BigDecimal augment(final K key, final BigDecimal addend) {
        if (!containsKey(key)) {
            throw new IllegalArgumentException("Map doesn't contain an entry with the key " + key + ".");
        }
        BigDecimal oldValue = get(key);
        if (oldValue == null) {
            throw new IllegalArgumentException("The entry in the map with the key " + key + " contains null.");
        } else {
            return update(key, oldValue.add(addend));
        }
    }

    @Override
    public BigDecimal multiply(final K key, final BigDecimal multiplicand) {
        if (!containsKey(key)) {
            throw new IllegalArgumentException("Map doesn't contain an entry with the key " + key + ".");
        }
        BigDecimal oldValue = get(key);
        if (oldValue == null) {
            throw new IllegalArgumentException("The entry in the map with the key " + key + " contains null.");
        } else {
            return update(key, oldValue.multiply(multiplicand));
        }
    }

    @Override
    public BigDecimal negate(final K key) {
        if (!containsKey(key)) {
            throw new IllegalArgumentException("Map doesn't contain an entry with the key " + key + ".");
        }
        BigDecimal oldValue = get(key);
        if (oldValue == null) {
            throw new IllegalArgumentException("The entry in the map with the key " + key + " contains null.");
        } else {
            return update(key, oldValue.negate());
        }
    }
}
