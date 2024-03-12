package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import net.filipvanlaenen.nombrajkolektoj.UpdatableSortedNumericMap;

abstract class AbstractUpdatableSortedBigDecimalMap<K> implements UpdatableSortedNumericMap<K, BigDecimal> {
    @Override
    public boolean augment(BigDecimal addend) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public BigDecimal augment(K key, BigDecimal addend) {
        if (!containsKey(key)) {
            throw new IllegalArgumentException("Map doesn't contain an entry with the key " + key + ".");
        }
        BigDecimal oldValue = get(key);
        if (oldValue == null) {
            throw new IllegalArgumentException("The entry in the map with the key " + key + " contains null.");
        } else {
            return update(key, oldValue.add(addend));
        }
    }

    @Override
    public BigDecimal max() throws IndexOutOfBoundsException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public BigDecimal min() throws IndexOutOfBoundsException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean multiply(BigDecimal multiplicand) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public BigDecimal multiply(K key, BigDecimal addend) {
        if (!containsKey(key)) {
            throw new IllegalArgumentException("Map doesn't contain an entry with the key " + key + ".");
        }
        BigDecimal oldValue = get(key);
        if (oldValue == null) {
            throw new IllegalArgumentException("The entry in the map with the key " + key + " contains null.");
        } else {
            return update(key, oldValue.multiply(addend));
        }
    }

    @Override
    public boolean negate() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public BigDecimal negate(K key) {
        if (!containsKey(key)) {
            throw new IllegalArgumentException("Map doesn't contain an entry with the key " + key + ".");
        }
        BigDecimal oldValue = get(key);
        if (oldValue == null) {
            throw new IllegalArgumentException("The entry in the map with the key " + key + " contains null.");
        } else {
            return update(key, oldValue.negate());
        }
    }

    @Override
    public BigDecimal product() {
        BigDecimal product = BigDecimal.ONE;
        for (BigDecimal bd : getValues()) {
            if (bd != null) {
                product.multiply(bd);
            }
        }
        return product;
    }

    @Override
    public BigDecimal sum() {
        BigDecimal sum = BigDecimal.ZERO;
        for (BigDecimal bd : getValues()) {
            if (bd != null) {
                sum.add(bd);
            }
        }
        return sum;
    }
}
