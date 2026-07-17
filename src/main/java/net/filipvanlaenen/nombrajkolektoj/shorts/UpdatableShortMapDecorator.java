package net.filipvanlaenen.nombrajkolektoj.shorts;

import net.filipvanlaenen.kolektoj.UpdatableMap;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * An abstract decorator class providing implementations for the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.shorts.UpdatableShortMap} interface.
 *
 * @param <K> The key type.
 */
abstract class UpdatableShortMapDecorator<K> extends ShortMapDecorator<K> implements UpdatableShortMap<K> {
    @Override
    public boolean augment(final Short addend) throws IllegalArgumentException {
        boolean result = false;
        for (K key : getKeys()) {
            NumericCollection<Short> originalValues = getAll(key);
            ModifiableShortCollection newValues = ModifiableShortCollection.of(originalValues);
            if (newValues.augment(addend)) {
                updateValuesForKey(key, originalValues, newValues);
                result = true;
            }
        }
        return result;
    }

    @Override
    public Short augment(final K key, final Short addend) {
        if (!containsKey(key)) {
            throw new IllegalArgumentException("Map doesn't contain an entry with the key " + key + ".");
        }
        Short oldValue = get(key);
        if (oldValue == null) {
            throw new IllegalArgumentException("The entry in the map with the key " + key + " contains null.");
        } else {
            update(key, oldValue, (short) (oldValue + addend));
            return oldValue;
        }
    }

    @Override
    public boolean divide(final Short divisor) throws IllegalArgumentException {
        boolean result = false;
        for (K key : getKeys()) {
            NumericCollection<Short> originalValues = getAll(key);
            ModifiableShortCollection newValues = ModifiableShortCollection.of(originalValues);
            if (newValues.divide(divisor)) {
                updateValuesForKey(key, originalValues, newValues);
                result = true;
            }
        }
        return result;
    }

    @Override
    public Short divide(final K key, final Short divisor) {
        if (!containsKey(key)) {
            throw new IllegalArgumentException("Map doesn't contain an entry with the key " + key + ".");
        }
        Short oldValue = get(key);
        if (oldValue == null) {
            throw new IllegalArgumentException("The entry in the map with the key " + key + " contains null.");
        } else {
            update(key, oldValue, (short) (oldValue / divisor));
            return oldValue;
        }
    }

    @Override
    abstract UpdatableMap<K, Short> getDecoratedMap();

    @Override
    public boolean multiply(final Short multiplicand) throws IllegalArgumentException {
        boolean result = false;
        for (K key : getKeys()) {
            NumericCollection<Short> originalValues = getAll(key);
            ModifiableShortCollection newValues = ModifiableShortCollection.of(originalValues);
            if (newValues.multiply(multiplicand)) {
                updateValuesForKey(key, originalValues, newValues);
                result = true;
            }
        }
        return result;
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
            update(key, oldValue, (short) (oldValue * multiplicand));
            return oldValue;
        }
    }

    @Override
    public boolean negate() throws IllegalArgumentException {
        boolean result = false;
        for (K key : getKeys()) {
            NumericCollection<Short> originalValues = getAll(key);
            ModifiableShortCollection newValues = ModifiableShortCollection.of(originalValues);
            if (newValues.negate()) {
                updateValuesForKey(key, originalValues, newValues);
                result = true;
            }
        }
        return result;
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
            update(key, oldValue, (short) (-oldValue));
            return oldValue;
        }
    }

    @Override
    public boolean subtract(final Short subtrahend) throws IllegalArgumentException {
        boolean result = false;
        for (K key : getKeys()) {
            NumericCollection<Short> originalValues = getAll(key);
            ModifiableShortCollection newValues = ModifiableShortCollection.of(originalValues);
            if (newValues.subtract(subtrahend)) {
                updateValuesForKey(key, originalValues, newValues);
                result = true;
            }
        }
        return result;
    }

    @Override
    public Short subtract(final K key, final Short subtrahend) {
        if (!containsKey(key)) {
            throw new IllegalArgumentException("Map doesn't contain an entry with the key " + key + ".");
        }
        Short oldValue = get(key);
        if (oldValue == null) {
            throw new IllegalArgumentException("The entry in the map with the key " + key + " contains null.");
        } else {
            update(key, oldValue, (short) (oldValue - subtrahend));
            return oldValue;
        }
    }

    @Override
    public Short update(final K key, final Short value) throws IllegalArgumentException {
        return getDecoratedMap().update(key, value);
    }

    @Override
    public boolean update(final K key, final Short oldValye, final Short newValue) {
        return getDecoratedMap().update(key, oldValye, newValue);
    }

    /**
     * Updates the values for a key from the original values to the new values.
     *
     * @param key            The key for which the values should be updated.
     * @param originalValues The original values for the key.
     * @param dividedValues  The new values for the key.
     */
    private void updateValuesForKey(final K key, final NumericCollection<Short> originalValues,
            final ModifiableShortCollection dividedValues) {
        ModifiableShortCollection changedNewValues = ModifiableShortCollection.of(dividedValues);
        changedNewValues.removeAll(originalValues);
        ModifiableShortCollection removedValues = ModifiableShortCollection.of(originalValues);
        removedValues.removeAll(dividedValues);
        for (Short removedValue : removedValues) {
            Short newValue = changedNewValues.get();
            update(key, removedValue, newValue);
            changedNewValues.remove(newValue);
        }
    }
}
