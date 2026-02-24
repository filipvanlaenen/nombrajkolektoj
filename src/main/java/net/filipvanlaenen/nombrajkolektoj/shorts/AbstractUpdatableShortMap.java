package net.filipvanlaenen.nombrajkolektoj.shorts;

import net.filipvanlaenen.nombrajkolektoj.NumericCollection;
import net.filipvanlaenen.nombrajkolektoj.UpdatableNumericMap;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.UpdatableNumericMap} for Shorts.
 *
 * @param <K> The key type.
 */
abstract class AbstractUpdatableShortMap<K> extends AbstractShortMap<K> implements UpdatableNumericMap<K, Short> {
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
    public boolean divide(final Short divisor) throws IllegalArgumentException {
        boolean result = false;
        for (K key : getKeys()) {
            NumericCollection<Short> originalValues = getAll(key);
            ModifiableShortCollection dividedValues = ModifiableShortCollection.of(originalValues);
            if (dividedValues.divide(divisor)) {
                ModifiableShortCollection newValues = ModifiableShortCollection.of(dividedValues);
                newValues.removeAll(originalValues);
                ModifiableShortCollection removedValues = ModifiableShortCollection.of(originalValues);
                removedValues.removeAll(dividedValues);
                for (Short removedValue : removedValues) {
                    Short newValue = newValues.get();
                    update(key, removedValue, newValue);
                    newValues.remove(newValue);
                }
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
}
