package net.filipvanlaenen.nombrajkolektoj.doubles;

import net.filipvanlaenen.kolektoj.UpdatableMap;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * An abstract decorator class providing implementations for the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.doubles.UpdatableDoubleMap} interface.
 *
 * @param <K> The key type.
 */
abstract class UpdatableDoubleMapDecorator<K> extends DoubleMapDecorator<K> implements UpdatableDoubleMap<K> {
    @Override
    public boolean augment(final Double addend) throws IllegalArgumentException {
        boolean result = false;
        for (K key : getKeys()) {
            NumericCollection<Double> originalValues = getAll(key);
            ModifiableDoubleCollection newValues = ModifiableDoubleCollection.of(originalValues);
            if (newValues.augment(addend)) {
                updateValuesForKey(key, originalValues, newValues);
                result = true;
            }
        }
        return result;
    }

    @Override
    public Double augment(final K key, final Double addend) {
        if (!containsKey(key)) {
            throw new IllegalArgumentException("Map doesn't contain an entry with the key " + key + ".");
        }
        Double oldValue = get(key);
        if (oldValue == null) {
            throw new IllegalArgumentException("The entry in the map with the key " + key + " contains null.");
        } else {
            update(key, oldValue, oldValue + addend);
            return oldValue;
        }
    }

    @Override
    public boolean divide(final Double divisor) throws IllegalArgumentException {
        boolean result = false;
        for (K key : getKeys()) {
            NumericCollection<Double> originalValues = getAll(key);
            ModifiableDoubleCollection newValues = ModifiableDoubleCollection.of(originalValues);
            if (newValues.divide(divisor)) {
                updateValuesForKey(key, originalValues, newValues);
                result = true;
            }
        }
        return result;
    }

    @Override
    public Double divide(final K key, final Double divisor) {
        if (!containsKey(key)) {
            throw new IllegalArgumentException("Map doesn't contain an entry with the key " + key + ".");
        }
        Double oldValue = get(key);
        if (oldValue == null) {
            throw new IllegalArgumentException("The entry in the map with the key " + key + " contains null.");
        } else {
            update(key, oldValue, oldValue / divisor);
            return oldValue;
        }
    }

    @Override
    abstract UpdatableMap<K, Double> getDecoratedMap();

    @Override
    public boolean multiply(final Double multiplicand) throws IllegalArgumentException {
        boolean result = false;
        for (K key : getKeys()) {
            NumericCollection<Double> originalValues = getAll(key);
            ModifiableDoubleCollection newValues = ModifiableDoubleCollection.of(originalValues);
            if (newValues.multiply(multiplicand)) {
                updateValuesForKey(key, originalValues, newValues);
                result = true;
            }
        }
        return result;
    }

    @Override
    public Double multiply(final K key, final Double multiplicand) {
        if (!containsKey(key)) {
            throw new IllegalArgumentException("Map doesn't contain an entry with the key " + key + ".");
        }
        Double oldValue = get(key);
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
            NumericCollection<Double> originalValues = getAll(key);
            ModifiableDoubleCollection newValues = ModifiableDoubleCollection.of(originalValues);
            if (newValues.negate()) {
                updateValuesForKey(key, originalValues, newValues);
                result = true;
            }
        }
        return result;
    }

    @Override
    public Double negate(final K key) {
        if (!containsKey(key)) {
            throw new IllegalArgumentException("Map doesn't contain an entry with the key " + key + ".");
        }
        Double oldValue = get(key);
        if (oldValue == null) {
            throw new IllegalArgumentException("The entry in the map with the key " + key + " contains null.");
        } else {
            update(key, oldValue, -oldValue);
            return oldValue;
        }
    }

    @Override
    public boolean subtract(final Double subtrahend) throws IllegalArgumentException {
        boolean result = false;
        for (K key : getKeys()) {
            NumericCollection<Double> originalValues = getAll(key);
            ModifiableDoubleCollection newValues = ModifiableDoubleCollection.of(originalValues);
            if (newValues.subtract(subtrahend)) {
                updateValuesForKey(key, originalValues, newValues);
                result = true;
            }
        }
        return result;
    }

    @Override
    public Double subtract(final K key, final Double subtrahend) {
        if (!containsKey(key)) {
            throw new IllegalArgumentException("Map doesn't contain an entry with the key " + key + ".");
        }
        Double oldValue = get(key);
        if (oldValue == null) {
            throw new IllegalArgumentException("The entry in the map with the key " + key + " contains null.");
        } else {
            update(key, oldValue, oldValue - subtrahend);
            return oldValue;
        }
    }

    @Override
    public Double update(final K key, final Double value) throws IllegalArgumentException {
        return getDecoratedMap().update(key, value);
    }

    @Override
    public boolean update(final K key, final Double oldValye, final Double newValue) {
        return getDecoratedMap().update(key, oldValye, newValue);
    }

    /**
     * Updates the values for a key from the original values to the new values.
     *
     * @param key            The key for which the values should be updated.
     * @param originalValues The original values for the key.
     * @param dividedValues  The new values for the key.
     */
    private void updateValuesForKey(final K key, final NumericCollection<Double> originalValues,
            final ModifiableDoubleCollection dividedValues) {
        ModifiableDoubleCollection changedNewValues = ModifiableDoubleCollection.of(dividedValues);
        changedNewValues.removeAll(originalValues);
        ModifiableDoubleCollection removedValues = ModifiableDoubleCollection.of(originalValues);
        removedValues.removeAll(dividedValues);
        for (Double removedValue : removedValues) {
            Double newValue = changedNewValues.get();
            update(key, removedValue, newValue);
            changedNewValues.remove(newValue);
        }
    }
}
