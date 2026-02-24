package net.filipvanlaenen.nombrajkolektoj.doubles;

import net.filipvanlaenen.nombrajkolektoj.NumericCollection;
import net.filipvanlaenen.nombrajkolektoj.UpdatableNumericMap;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.UpdatableNumericMap} for Doubles.
 *
 * @param <K> The key type.
 */
abstract class AbstractUpdatableDoubleMap<K> extends AbstractDoubleMap<K> implements UpdatableNumericMap<K, Double> {
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
    public boolean divide(final Double divisor) throws IllegalArgumentException {
        boolean result = false;
        for (K key : getKeys()) {
            NumericCollection<Double> originalValues = getAll(key);
            ModifiableDoubleCollection dividedValues = ModifiableDoubleCollection.of(originalValues);
            if (dividedValues.divide(divisor)) {
                ModifiableDoubleCollection newValues = ModifiableDoubleCollection.of(dividedValues);
                newValues.removeAll(originalValues);
                ModifiableDoubleCollection removedValues = ModifiableDoubleCollection.of(originalValues);
                removedValues.removeAll(dividedValues);
                for (Double removedValue : removedValues) {
                    Double newValue = newValues.get();
                    update(key, removedValue, newValue);
                    newValues.remove(newValue);
                }
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
}
