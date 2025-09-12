package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import net.filipvanlaenen.nombrajkolektoj.SortedNumericMap;

/**
 * An abstract class implementing the methods defined in the {@link net.filipvanlaenen.nombrajkolektoj.SortedNumericMap}
 * for BigDecimals.
 *
 * @param <K> The key type.
 */
abstract class AbstractSortedBigDecimalMap<K> extends AbstractBigDecimalMap<K> implements SortedNumericMap<K, BigDecimal> {
}
