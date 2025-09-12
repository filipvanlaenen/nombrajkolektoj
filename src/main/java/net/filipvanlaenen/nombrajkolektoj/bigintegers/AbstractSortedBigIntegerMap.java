package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

import net.filipvanlaenen.nombrajkolektoj.SortedNumericMap;

/**
 * An abstract class implementing the methods defined in the {@link net.filipvanlaenen.nombrajkolektoj.SortedNumericMap}
 * for BigIntegers.
 *
 * @param <K> The key type.
 */
abstract class AbstractSortedBigIntegerMap<K> extends AbstractBigIntegerMap<K> implements SortedNumericMap<K, BigInteger> {
}
