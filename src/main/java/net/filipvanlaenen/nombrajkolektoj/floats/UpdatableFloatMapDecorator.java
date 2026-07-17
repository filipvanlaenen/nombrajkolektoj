package net.filipvanlaenen.nombrajkolektoj.floats;

import net.filipvanlaenen.kolektoj.UpdatableMap;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * An abstract decorator class providing implementations for the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.floats.UpdatableFloatMap} interface.
 *
 * @param <K> The key type.
 */
abstract class UpdatableFloatMapDecorator<K> extends FloatMapDecorator<K> implements UpdatableFloatMap<K> {
    @Override
    public boolean augment(final Float addend) throws IllegalArgumentException {
        boolean result = false;
        for (K key : getKeys()) {
            NumericCollection<Float> originalValues = getAll(key);
            ModifiableFloatCollection newValues = ModifiableFloatCollection.of(originalValues);
            if (newValues.augment(addend)) {
                updateValuesForKey(key, originalValues, newValues);
                result = true;
            }
        }
        return result;
    }

    @Override
    public Float augment(final K key, final Float addend) {
        if (!containsKey(key)) {
            throw new IllegalArgumentException("Map doesn't contain an entry with the key " + key + ".");
        }
        Float oldValue = get(key);
        if (oldValue == null) {
            throw new IllegalArgumentException("The entry in the map with the key " + key + " contains null.");
        } else {
            update(key, oldValue, oldValue + addend);
            return oldValue;
        }
    }

    @Override
    public boolean divide(final Float divisor) throws IllegalArgumentException {
        boolean result = false;
        for (K key : getKeys()) {
            NumericCollection<Float> originalValues = getAll(key);
            ModifiableFloatCollection newValues = ModifiableFloatCollection.of(originalValues);
            if (newValues.divide(divisor)) {
                updateValuesForKey(key, originalValues, newValues);
                result = true;
            }
        }
        return result;
    }

    @Override
    public Float divide(final K key, final Float divisor) {
        if (!containsKey(key)) {
            throw new IllegalArgumentException("Map doesn't contain an entry with the key " + key + ".");
        }
        Float oldValue = get(key);
        if (oldValue == null) {
            throw new IllegalArgumentException("The entry in the map with the key " + key + " contains null.");
        } else {
            update(key, oldValue, oldValue / divisor);
            return oldValue;
        }
    }

    @Override
    abstract UpdatableMap<K, Float> getDecoratedMap();

    @Override
    public boolean multiply(final Float multiplicand) throws IllegalArgumentException {
        boolean result = false;
        for (K key : getKeys()) {
            NumericCollection<Float> originalValues = getAll(key);
            ModifiableFloatCollection newValues = ModifiableFloatCollection.of(originalValues);
            if (newValues.multiply(multiplicand)) {
                updateValuesForKey(key, originalValues, newValues);
                result = true;
            }
        }
        return result;
    }

    @Override
    public Float multiply(final K key, final Float multiplicand) {
        if (!containsKey(key)) {
            throw new IllegalArgumentException("Map doesn't contain an entry with the key " + key + ".");
        }
        Float oldValue = get(key);
        if (oldValue == null) {
            throw new IllegalArgumentException("The entry in the map with the key " + key + " contains null.");
        } else {
            update(key, oldValue, oldValue * multiplicand);
            return oldValue;
        }
    }

    @Override
    public boolean negate() throws IllegalArgumentException {
        boolean result = false;
        for (K key : getKeys()) {
            NumericCollection<Float> originalValues = getAll(key);
            ModifiableFloatCollection newValues = ModifiableFloatCollection.of(originalValues);
            if (newValues.negate()) {
                updateValuesForKey(key, originalValues, newValues);
                result = true;
            }
        }
        return result;
    }

    @Override
    public Float negate(final K key) {
        if (!containsKey(key)) {
            throw new IllegalArgumentException("Map doesn't contain an entry with the key " + key + ".");
        }
        Float oldValue = get(key);
        if (oldValue == null) {
            throw new IllegalArgumentException("The entry in the map with the key " + key + " contains null.");
        } else {
            update(key, oldValue, -oldValue);
            return oldValue;
        }
    }

    @Override
    public boolean subtract(final Float subtrahend) throws IllegalArgumentException {
        boolean result = false;
        for (K key : getKeys()) {
            NumericCollection<Float> originalValues = getAll(key);
            ModifiableFloatCollection newValues = ModifiableFloatCollection.of(originalValues);
            if (newValues.subtract(subtrahend)) {
                updateValuesForKey(key, originalValues, newValues);
                result = true;
            }
        }
        return result;
    }

    @Override
    public Float subtract(final K key, final Float subtrahend) {
        if (!containsKey(key)) {
            throw new IllegalArgumentException("Map doesn't contain an entry with the key " + key + ".");
        }
        Float oldValue = get(key);
        if (oldValue == null) {
            throw new IllegalArgumentException("The entry in the map with the key " + key + " contains null.");
        } else {
            update(key, oldValue, oldValue - subtrahend);
            return oldValue;
        }
    }

    @Override
    public Float update(final K key, final Float value) throws IllegalArgumentException {
        return getDecoratedMap().update(key, value);
    }

    @Override
    public boolean update(final K key, final Float oldValye, final Float newValue) {
        return getDecoratedMap().update(key, oldValye, newValue);
    }

    /**
     * Updates the values for a key from the original values to the new values.
     *
     * @param key            The key for which the values should be updated.
     * @param originalValues The original values for the key.
     * @param dividedValues  The new values for the key.
     */
    private void updateValuesForKey(final K key, final NumericCollection<Float> originalValues,
            final ModifiableFloatCollection dividedValues) {
        ModifiableFloatCollection changedNewValues = ModifiableFloatCollection.of(dividedValues);
        changedNewValues.removeAll(originalValues);
        ModifiableFloatCollection removedValues = ModifiableFloatCollection.of(originalValues);
        removedValues.removeAll(dividedValues);
        for (Float removedValue : removedValues) {
            Float newValue = changedNewValues.get();
            update(key, removedValue, newValue);
            changedNewValues.remove(newValue);
        }
    }
}
