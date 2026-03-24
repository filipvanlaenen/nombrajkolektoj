package net.filipvanlaenen.nombrajkolektoj.bytes;

import net.filipvanlaenen.nombrajkolektoj.NumericCollection;
import net.filipvanlaenen.nombrajkolektoj.UpdatableNumericMap;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.UpdatableNumericMap} for Bytes.
 *
 * @param <K> The key type.
 */
abstract class AbstractUpdatableByteMap<K> extends AbstractByteMap<K> implements UpdatableNumericMap<K, Byte> {
    @Override
    public boolean augment(final Byte addend) throws IllegalArgumentException {
        boolean result = false;
        for (K key : getKeys()) {
            NumericCollection<Byte> originalValues = getAll(key);
            ModifiableByteCollection newValues = ModifiableByteCollection.of(originalValues);
            if (newValues.augment(addend)) {
                updateValuesForKey(key, originalValues, newValues);
                result = true;
            }
        }
        return result;
    }

    @Override
    public Byte augment(final K key, final Byte addend) {
        if (!containsKey(key)) {
            throw new IllegalArgumentException("Map doesn't contain an entry with the key " + key + ".");
        }
        Byte oldValue = get(key);
        if (oldValue == null) {
            throw new IllegalArgumentException("The entry in the map with the key " + key + " contains null.");
        } else {
            update(key, oldValue, (byte) (oldValue + addend));
            return oldValue;
        }
    }

    @Override
    public boolean divide(final Byte divisor) throws IllegalArgumentException {
        boolean result = false;
        for (K key : getKeys()) {
            NumericCollection<Byte> originalValues = getAll(key);
            ModifiableByteCollection newValues = ModifiableByteCollection.of(originalValues);
            if (newValues.divide(divisor)) {
                updateValuesForKey(key, originalValues, newValues);
                result = true;
            }
        }
        return result;
    }

    @Override
    public Byte divide(final K key, final Byte divisor) {
        if (!containsKey(key)) {
            throw new IllegalArgumentException("Map doesn't contain an entry with the key " + key + ".");
        }
        Byte oldValue = get(key);
        if (oldValue == null) {
            throw new IllegalArgumentException("The entry in the map with the key " + key + " contains null.");
        } else {
            update(key, oldValue, (byte) (oldValue / divisor));
            return oldValue;
        }
    }

    @Override
    public Byte multiply(final K key, final Byte multiplicand) {
        if (!containsKey(key)) {
            throw new IllegalArgumentException("Map doesn't contain an entry with the key " + key + ".");
        }
        Byte oldValue = get(key);
        if (oldValue == null) {
            throw new IllegalArgumentException("The entry in the map with the key " + key + " contains null.");
        } else {
            update(key, oldValue, (byte) (oldValue * multiplicand));
            return oldValue;
        }
    }

    @Override
    public Byte negate(final K key) {
        if (!containsKey(key)) {
            throw new IllegalArgumentException("Map doesn't contain an entry with the key " + key + ".");
        }
        Byte oldValue = get(key);
        if (oldValue == null) {
            throw new IllegalArgumentException("The entry in the map with the key " + key + " contains null.");
        } else {
            update(key, oldValue, (byte) (-oldValue));
            return oldValue;
        }
    }

    @Override
    public Byte subtract(final K key, final Byte subtrahend) {
        if (!containsKey(key)) {
            throw new IllegalArgumentException("Map doesn't contain an entry with the key " + key + ".");
        }
        Byte oldValue = get(key);
        if (oldValue == null) {
            throw new IllegalArgumentException("The entry in the map with the key " + key + " contains null.");
        } else {
            update(key, oldValue, (byte) (oldValue - subtrahend));
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
    private void updateValuesForKey(final K key, final NumericCollection<Byte> originalValues,
            final ModifiableByteCollection dividedValues) {
        ModifiableByteCollection changedNewValues = ModifiableByteCollection.of(dividedValues);
        changedNewValues.removeAll(originalValues);
        ModifiableByteCollection removedValues = ModifiableByteCollection.of(originalValues);
        removedValues.removeAll(dividedValues);
        for (Byte removedValue : removedValues) {
            Byte newValue = changedNewValues.get();
            update(key, removedValue, newValue);
            changedNewValues.remove(newValue);
        }
    }
}
