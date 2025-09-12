package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

import net.filipvanlaenen.nombrajkolektoj.UpdatableSortedNumericMap;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.UpdatableSortedNumericMap} for BigIntegers.
 *
 * @param <K> The key type.
 */
abstract class AbstractUpdatableSortedBigIntegerMap<K> extends AbstractUpdatableBigIntegerMap<K>
        implements UpdatableSortedNumericMap<K, BigInteger> {
}
