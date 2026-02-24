package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import net.filipvanlaenen.nombrajkolektoj.NumericCollection;
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
            update(key, oldValue, oldValue.add(addend));
            return oldValue;
        }
    }

    @Override
    public BigDecimal divide(final K key, final BigDecimal divisor) {
        if (!containsKey(key)) {
            throw new IllegalArgumentException("Map doesn't contain an entry with the key " + key + ".");
        }
        BigDecimal oldValue = get(key);
        if (oldValue == null) {
            throw new IllegalArgumentException("The entry in the map with the key " + key + " contains null.");
        } else {
            update(key, oldValue, oldValue.divide(divisor));
            return oldValue;
        }
    }

    @Override
    public boolean divide(final BigDecimal divisor) throws IllegalArgumentException {
        boolean result = false;
        for (K key : getKeys()) {
            NumericCollection<BigDecimal> originalValues = getAll(key);
            ModifiableBigDecimalCollection dividedValues = ModifiableBigDecimalCollection.of(originalValues);
            if (dividedValues.divide(divisor)) {
                ModifiableBigDecimalCollection newValues = ModifiableBigDecimalCollection.of(dividedValues);
                newValues.removeAll(originalValues);
                ModifiableBigDecimalCollection removedValues = ModifiableBigDecimalCollection.of(originalValues);
                removedValues.removeAll(dividedValues);
                for (BigDecimal removedValue : removedValues) {
                    BigDecimal newValue = newValues.get();
                    update(key, removedValue, newValue);
                    newValues.remove(newValue);
                }
                result = true;
            }
        }
        return result;
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
            update(key, oldValue, oldValue.multiply(multiplicand));
            return oldValue;
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
            update(key, oldValue, oldValue.negate());
            return oldValue;
        }
    }

    @Override
    public BigDecimal subtract(final K key, final BigDecimal subtrahend) {
        if (!containsKey(key)) {
            throw new IllegalArgumentException("Map doesn't contain an entry with the key " + key + ".");
        }
        BigDecimal oldValue = get(key);
        if (oldValue == null) {
            throw new IllegalArgumentException("The entry in the map with the key " + key + " contains null.");
        } else {
            update(key, oldValue, oldValue.subtract(subtrahend));
            return oldValue;
        }
    }
}
