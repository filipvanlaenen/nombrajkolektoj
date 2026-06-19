package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigDecimals.ModifiableBigDecimalCollection} class.
 */
public final class ModifiableBigDecimalCollectionTest
        extends ModifiableBigDecimalCollectionTestBase<ModifiableBigDecimalCollection> {
    /**
     * Collection with the BigDecimals 1, 2 and 3.
     */
    private final NumericCollection<BigDecimal> collection123 = createBigDecimalCollection(BigDecimal.ONE, BigDecimal.valueOf(2L), BigDecimal.valueOf(3L));

    @Override
    protected ModifiableBigDecimalCollection createEmptyBigDecimalCollection() {
        return ModifiableBigDecimalCollection.empty();
    }

    @Override
    protected ModifiableBigDecimalCollection createBigDecimalCollection(final BigDecimal... numbers) {
        return ModifiableBigDecimalCollection.of(numbers);
    }

    @Override
    protected ModifiableBigDecimalCollection createBigDecimalCollection(final ElementCardinality elementCardinality,
            final BigDecimal... numbers) {
        return ModifiableBigDecimalCollection.of(elementCardinality, numbers);
    }

    @Override
    protected ModifiableBigDecimalCollection createBigDecimalCollection(final ElementCardinality elementCardinality,
            final NumericCollection<BigDecimal> source) {
        return ModifiableBigDecimalCollection.of(elementCardinality, source);
    }

    @Override
    protected ModifiableBigDecimalCollection createBigDecimalCollection(final NumericCollection<BigDecimal> source) {
        return ModifiableBigDecimalCollection.of(source);
    }

    /**
     * Verifies that the intersection of no collections is an empty collection.
     */
    @Test
    public void intersectionOfNoCollectionsShouldBeEmpty() {
        assertTrue(ModifiableBigDecimalCollection.intersectionOf().isEmpty());
    }

    /**
     * Verifies that the intersection of one collections is the collection itself.
     */
    @Test
    public void intersectionOfOneCollectionsShouldBeItself() {
        assertTrue(collection123.containsSame(ModifiableBigDecimalCollection.intersectionOf(collection123)));
    }

    /**
     * Verifies that the intersection of two collections is a collection with the common elements.
     */
    @Test
    public void intersectionOfTwoCollectionsShouldContainCommonElements() {
        assertTrue(createBigDecimalCollection(BigDecimal.ONE, BigDecimal.valueOf(2L)).containsSame(
                ModifiableBigDecimalCollection.intersectionOf(createBigDecimalCollection(BigDecimal.ZERO, BigDecimal.ONE, BigDecimal.valueOf(2L)), collection123)));
    }
}
