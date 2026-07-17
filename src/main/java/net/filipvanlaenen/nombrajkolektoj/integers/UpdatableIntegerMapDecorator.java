package net.filipvanlaenen.nombrajkolektoj.integers;

import net.filipvanlaenen.kolektoj.UpdatableMap;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * An abstract decorator class providing implementations for the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.integers.UpdatableIntegerMap} interface.
 *
 * @param <K> The key type.
 */
abstract class UpdatableIntegerMapDecorator<K> extends IntegerMapDecorator<K> implements UpdatableIntegerMap<K> {
    @Override
    public boolean augment(final Integer addend) throws IllegalArgumentException {
        boolean result = false;
        for (K key : getKeys()) {
            NumericCollection<Integer> originalValues = getAll(key);
            ModifiableIntegerCollection newValues = ModifiableIntegerCollection.of(originalValues);
            if (newValues.augment(addend)) {
                updateValuesForKey(key, originalValues, newValues);
                result = true;
            }
        }
        return result;
    }

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
    public boolean divide(final Integer divisor) throws IllegalArgumentException {
        boolean result = false;
        for (K key : getKeys()) {
            NumericCollection<Integer> originalValues = getAll(key);
            ModifiableIntegerCollection newValues = ModifiableIntegerCollection.of(originalValues);
            if (newValues.divide(divisor)) {
                updateValuesForKey(key, originalValues, newValues);
                result = true;
            }
        }
        return result;
    }

    @Override
    public Integer divide(final K key, final Integer divisor) {
        if (!containsKey(key)) {
            throw new IllegalArgumentException("Map doesn't contain an entry with the key " + key + ".");
        }
        Integer oldValue = get(key);
        if (oldValue == null) {
            throw new IllegalArgumentException("The entry in the map with the key " + key + " contains null.");
        } else {
            update(key, oldValue, oldValue / divisor);
            return oldValue;
        }
    }

    @Override
    abstract UpdatableMap<K, Integer> getDecoratedMap();

    @Override
    public boolean multiply(final Integer multiplicand) throws IllegalArgumentException {
        boolean result = false;
        for (K key : getKeys()) {
            NumericCollection<Integer> originalValues = getAll(key);
            ModifiableIntegerCollection newValues = ModifiableIntegerCollection.of(originalValues);
            if (newValues.multiply(multiplicand)) {
                updateValuesForKey(key, originalValues, newValues);
                result = true;
            }
        }
        return result;
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
    public boolean negate() throws IllegalArgumentException {
        boolean result = false;
        for (K key : getKeys()) {
            NumericCollection<Integer> originalValues = getAll(key);
            ModifiableIntegerCollection newValues = ModifiableIntegerCollection.of(originalValues);
            if (newValues.negate()) {
                updateValuesForKey(key, originalValues, newValues);
                result = true;
            }
        }
        return result;
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
    public boolean subtract(final Integer subtrahend) throws IllegalArgumentException {
        boolean result = false;
        for (K key : getKeys()) {
            NumericCollection<Integer> originalValues = getAll(key);
            ModifiableIntegerCollection newValues = ModifiableIntegerCollection.of(originalValues);
            if (newValues.subtract(subtrahend)) {
                updateValuesForKey(key, originalValues, newValues);
                result = true;
            }
        }
        return result;
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

    @Override
    public Integer update(final K key, final Integer value) throws IllegalArgumentException {
        return getDecoratedMap().update(key, value);
    }

    @Override
    public boolean update(final K key, final Integer oldValye, final Integer newValue) {
        return getDecoratedMap().update(key, oldValye, newValue);
    }

    /**
     * Updates the values for a key from the original values to the new values.
     *
     * @param key            The key for which the values should be updated.
     * @param originalValues The original values for the key.
     * @param dividedValues  The new values for the key.
     */
    private void updateValuesForKey(final K key, final NumericCollection<Integer> originalValues,
            final ModifiableIntegerCollection dividedValues) {
        ModifiableIntegerCollection changedNewValues = ModifiableIntegerCollection.of(dividedValues);
        changedNewValues.removeAll(originalValues);
        ModifiableIntegerCollection removedValues = ModifiableIntegerCollection.of(originalValues);
        removedValues.removeAll(dividedValues);
        for (Integer removedValue : removedValues) {
            Integer newValue = changedNewValues.get();
            update(key, removedValue, newValue);
            changedNewValues.remove(newValue);
        }
    }
}
