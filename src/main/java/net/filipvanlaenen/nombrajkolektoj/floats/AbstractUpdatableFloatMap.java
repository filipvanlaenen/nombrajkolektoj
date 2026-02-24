package net.filipvanlaenen.nombrajkolektoj.floats;

import net.filipvanlaenen.nombrajkolektoj.NumericCollection;
import net.filipvanlaenen.nombrajkolektoj.UpdatableNumericMap;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.UpdatableNumericMap} for Floats.
 *
 * @param <K> The key type.
 */
abstract class AbstractUpdatableFloatMap<K> extends AbstractFloatMap<K> implements UpdatableNumericMap<K, Float> {
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
    public boolean divide(final Float divisor) throws IllegalArgumentException {
        boolean result = false;
        for (K key : getKeys()) {
            NumericCollection<Float> originalValues = getAll(key);
            ModifiableFloatCollection dividedValues = ModifiableFloatCollection.of(originalValues);
            if (dividedValues.divide(divisor)) {
                ModifiableFloatCollection newValues = ModifiableFloatCollection.of(dividedValues);
                newValues.removeAll(originalValues);
                ModifiableFloatCollection removedValues = ModifiableFloatCollection.of(originalValues);
                removedValues.removeAll(dividedValues);
                for (Float removedValue : removedValues) {
                    Float newValue = newValues.get();
                    update(key, removedValue, newValue);
                    newValues.remove(newValue);
                }
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
}
