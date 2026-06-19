package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigDecimals.BigDecimalCollection} class.
 */
public final class BigDecimalCollectionTest extends BigDecimalCollectionTestBase<BigDecimalCollection> {
    /**
     * Collection with the BigDecimals 1, 2 and 3.
     */
    private final NumericCollection<BigDecimal> collection123 = createBigDecimalCollection(BigDecimal.ONE, BigDecimal.valueOf(2L), BigDecimal.valueOf(3L));

    @Override
    protected BigDecimalCollection createEmptyBigDecimalCollection() {
        return BigDecimalCollection.empty();
    }

    @Override
    protected BigDecimalCollection createBigDecimalCollection(final BigDecimal... numbers) {
        return BigDecimalCollection.of(numbers);
    }

    @Override
    protected BigDecimalCollection createBigDecimalCollection(final ElementCardinality elementCardinality,
            final BigDecimal... numbers) {
        return BigDecimalCollection.of(elementCardinality, numbers);
    }

    @Override
    protected BigDecimalCollection createBigDecimalCollection(final ElementCardinality elementCardinality,
            final NumericCollection<BigDecimal> source) {
        return BigDecimalCollection.of(elementCardinality, source);
    }

    @Override
    protected BigDecimalCollection createBigDecimalCollection(final NumericCollection<BigDecimal> source) {
        return BigDecimalCollection.of(source);
    }

    /**
     * Verifies that the intersection of no collections is an empty collection.
     */
    @Test
    public void intersectionOfNoCollectionsShouldBeEmpty() {
        assertTrue(BigDecimalCollection.intersectionOf().isEmpty());
    }

    /**
     * Verifies that the intersection of one collections is the collection itself.
     */
    @Test
    public void intersectionOfOneCollectionsShouldBeItself() {
        assertTrue(collection123.containsSame(BigDecimalCollection.intersectionOf(collection123)));
    }

    /**
     * Verifies that the intersection of two collections is a collection with the common elements.
     */
    @Test
    public void intersectionOfTwoCollectionsShouldContainCommonElements() {
        assertTrue(createBigDecimalCollection(BigDecimal.ONE, BigDecimal.valueOf(2L))
                .containsSame(BigDecimalCollection.intersectionOf(createBigDecimalCollection(BigDecimal.ZERO, BigDecimal.ONE, BigDecimal.valueOf(2L)), collection123)));
    }
}
