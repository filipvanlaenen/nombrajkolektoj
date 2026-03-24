package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

import net.filipvanlaenen.nombrajkolektoj.NumericCollection;
import net.filipvanlaenen.nombrajkolektoj.UpdatableNumericMap;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.UpdatableNumericMap} for BigIntegers.
 *
 * @param <K> The key type.
 */
abstract class AbstractUpdatableBigIntegerMap<K> extends AbstractBigIntegerMap<K> implements UpdatableNumericMap<K, BigInteger> {
    @Override
    public boolean augment(final BigInteger addend) throws IllegalArgumentException {
        boolean result = false;
        for (K key : getKeys()) {
            NumericCollection<BigInteger> originalValues = getAll(key);
            ModifiableBigIntegerCollection newValues = ModifiableBigIntegerCollection.of(originalValues);
            if (newValues.augment(addend)) {
                updateValuesForKey(key, originalValues, newValues);
                result = true;
            }
        }
        return result;
    }

    @Override
    public BigInteger augment(final K key, final BigInteger addend) {
        if (!containsKey(key)) {
            throw new IllegalArgumentException("Map doesn't contain an entry with the key " + key + ".");
        }
        BigInteger oldValue = get(key);
        if (oldValue == null) {
            throw new IllegalArgumentException("The entry in the map with the key " + key + " contains null.");
        } else {
            update(key, oldValue, oldValue.add(addend));
            return oldValue;
        }
    }

    @Override
    public boolean divide(final BigInteger divisor) throws IllegalArgumentException {
        boolean result = false;
        for (K key : getKeys()) {
            NumericCollection<BigInteger> originalValues = getAll(key);
            ModifiableBigIntegerCollection newValues = ModifiableBigIntegerCollection.of(originalValues);
            if (newValues.divide(divisor)) {
                updateValuesForKey(key, originalValues, newValues);
                result = true;
            }
        }
        return result;
    }

    @Override
    public BigInteger divide(final K key, final BigInteger divisor) {
        if (!containsKey(key)) {
            throw new IllegalArgumentException("Map doesn't contain an entry with the key " + key + ".");
        }
        BigInteger oldValue = get(key);
        if (oldValue == null) {
            throw new IllegalArgumentException("The entry in the map with the key " + key + " contains null.");
        } else {
            update(key, oldValue, oldValue.divide(divisor));
            return oldValue;
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
            update(key, oldValue, oldValue.multiply(multiplicand));
            return oldValue;
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
            update(key, oldValue, oldValue.negate());
            return oldValue;
        }
    }

    @Override
    public BigInteger subtract(final K key, final BigInteger subtrahend) {
        if (!containsKey(key)) {
            throw new IllegalArgumentException("Map doesn't contain an entry with the key " + key + ".");
        }
        BigInteger oldValue = get(key);
        if (oldValue == null) {
            throw new IllegalArgumentException("The entry in the map with the key " + key + " contains null.");
        } else {
            update(key, oldValue, oldValue.subtract(subtrahend));
            return oldValue;
        }
    }

    /**
     * Updates the values for a key from the original values to the new values.
     *
     * @param key            The key for which the values should be updated.
     * @param originalValues The original values for the key.
     * @param dividedValues  The new values for the key.
     */
    private void updateValuesForKey(final K key, final NumericCollection<BigInteger> originalValues,
            final ModifiableBigIntegerCollection dividedValues) {
        ModifiableBigIntegerCollection changedNewValues = ModifiableBigIntegerCollection.of(dividedValues);
        changedNewValues.removeAll(originalValues);
        ModifiableBigIntegerCollection removedValues = ModifiableBigIntegerCollection.of(originalValues);
        removedValues.removeAll(dividedValues);
        for (BigInteger removedValue : removedValues) {
            BigInteger newValue = changedNewValues.get();
            update(key, removedValue, newValue);
            changedNewValues.remove(newValue);
        }
    }
}
