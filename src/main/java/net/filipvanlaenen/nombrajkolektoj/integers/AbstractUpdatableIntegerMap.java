package net.filipvanlaenen.nombrajkolektoj.integers;

import net.filipvanlaenen.nombrajkolektoj.NumericCollection;
import net.filipvanlaenen.nombrajkolektoj.UpdatableNumericMap;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.UpdatableNumericMap} for Integers.
 *
 * @param <K> The key type.
 */
abstract class AbstractUpdatableIntegerMap<K> extends AbstractIntegerMap<K> implements UpdatableNumericMap<K, Integer> {
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
    public boolean divide(final Integer divisor) throws IllegalArgumentException {
        boolean result = false;
        for (K key : getKeys()) {
            NumericCollection<Integer> originalValues = getAll(key);
            ModifiableIntegerCollection dividedValues = ModifiableIntegerCollection.of(originalValues);
            if (dividedValues.divide(divisor)) {
                ModifiableIntegerCollection newValues = ModifiableIntegerCollection.of(dividedValues);
                newValues.removeAll(originalValues);
                ModifiableIntegerCollection removedValues = ModifiableIntegerCollection.of(originalValues);
                removedValues.removeAll(dividedValues);
                for (Integer removedValue : removedValues) {
                    Integer newValue = newValues.get();
                    update(key, removedValue, newValue);
                    newValues.remove(newValue);
                }
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
}
