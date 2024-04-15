package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import net.filipvanlaenen.nombrajkolektoj.UpdatableSortedNumericMap;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.UpdatableSortedNumericMap} for BigDecimals.
 *
 * @param <K> The key type.
 */
abstract class AbstractUpdatableSortedBigDecimalMap<K> extends AbstractBigDecimalMap<K>
        implements UpdatableSortedNumericMap<K, BigDecimal> {
    @Override
    public boolean augment(final BigDecimal addend) {
        // TODO: Auto-generated method stub
        return false;
    }

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
    public boolean multiply(final BigDecimal multiplicand) {
        // TODO: Auto-generated method stub
        return false;
    }

    @Override
    public BigDecimal multiply(final K key, final BigDecimal addend) {
        if (!containsKey(key)) {
            throw new IllegalArgumentException("Map doesn't contain an entry with the key " + key + ".");
        }
        BigDecimal oldValue = get(key);
        if (oldValue == null) {
            throw new IllegalArgumentException("The entry in the map with the key " + key + " contains null.");
        } else {
            return update(key, oldValue.multiply(addend));
        }
    }

    @Override
    public boolean negate() {
        // TODO: Auto-generated method stub
        return false;
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
