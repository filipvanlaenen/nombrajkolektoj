package net.filipvanlaenen.nombrajkolektoj.bytes;

import net.filipvanlaenen.kolektoj.UpdatableMap;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * An abstract decorator class providing implementations for the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.bytes.UpdatableByteMap} interface.
 *
 * @param <K> The key type.
 */
abstract class UpdatableByteMapDecorator<K> extends ByteMapDecorator<K> implements UpdatableByteMap<K> {
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
    abstract UpdatableMap<K, Byte> getDecoratedMap();

    @Override
    public boolean multiply(final Byte multiplicand) throws IllegalArgumentException {
        boolean result = false;
        for (K key : getKeys()) {
            NumericCollection<Byte> originalValues = getAll(key);
            ModifiableByteCollection newValues = ModifiableByteCollection.of(originalValues);
            if (newValues.multiply(multiplicand)) {
                updateValuesForKey(key, originalValues, newValues);
                result = true;
            }
        }
        return result;
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
    public boolean negate() throws IllegalArgumentException {
        boolean result = false;
        for (K key : getKeys()) {
            NumericCollection<Byte> originalValues = getAll(key);
            ModifiableByteCollection newValues = ModifiableByteCollection.of(originalValues);
            if (newValues.negate()) {
                updateValuesForKey(key, originalValues, newValues);
                result = true;
            }
        }
        return result;
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
    public boolean subtract(final Byte subtrahend) throws IllegalArgumentException {
        boolean result = false;
        for (K key : getKeys()) {
            NumericCollection<Byte> originalValues = getAll(key);
            ModifiableByteCollection newValues = ModifiableByteCollection.of(originalValues);
            if (newValues.subtract(subtrahend)) {
                updateValuesForKey(key, originalValues, newValues);
                result = true;
            }
        }
        return result;
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

    @Override
    public Byte update(final K key, final Byte value) throws IllegalArgumentException {
        return getDecoratedMap().update(key, value);
    }

    @Override
    public boolean update(final K key, final Byte oldValye, final Byte newValue) {
        return getDecoratedMap().update(key, oldValye, newValue);
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
