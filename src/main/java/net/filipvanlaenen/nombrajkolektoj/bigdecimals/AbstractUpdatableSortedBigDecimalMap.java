package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import net.filipvanlaenen.nombrajkolektoj.UpdatableSortedNumericMap;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.UpdatableSortedNumericMap} for BigDecimals.
 *
 * @param <K> The key type.
 */
abstract class AbstractUpdatableSortedBigDecimalMap<K> extends AbstractUpdatableBigDecimalMap<K>
        implements UpdatableSortedNumericMap<K, BigDecimal> {
}
