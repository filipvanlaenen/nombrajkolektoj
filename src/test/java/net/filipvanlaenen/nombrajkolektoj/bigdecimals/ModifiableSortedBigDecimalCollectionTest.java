package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigDecimals.ModifiableSortedBigDecimalCollection} class.
 */
public final class ModifiableSortedBigDecimalCollectionTest
        extends ModifiableBigDecimalCollectionTestBase<ModifiableSortedBigDecimalCollection> {
    /**
     * The BigDecimal three.
     */
    private static final BigDecimal BIG_DECIMAL_THREE = BigDecimal.valueOf(3L);

    @Override
    protected ModifiableSortedBigDecimalCollection createBigDecimalCollection(final Collection<BigDecimal> source) {
        return new ModifiableSortedBigDecimalCollection.SortedTreeCollection(Comparator.naturalOrder(),
                BigDecimalCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.BIG_DECIMALS)));
    }

    @Override
    protected ModifiableSortedBigDecimalCollection createBigDecimalCollection(final BigDecimal... numbers) {
        return ModifiableSortedBigDecimalCollection.of(Comparator.naturalOrder(), numbers);
    }

    @Override
    protected ModifiableSortedBigDecimalCollection createBigDecimalCollection(final ElementCardinality elementCardinality,
            final BigDecimal... numbers) {
        return ModifiableSortedBigDecimalCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected ModifiableSortedBigDecimalCollection createEmptyBigDecimalCollection() {
        return ModifiableSortedBigDecimalCollection.empty(Comparator.naturalOrder());
    }

    /**
     * Creates a modifiable sorted BigDecimals collection containing the provided BigDecimals.
     *
     * @param numbers    The BigDecimals to be included in the modifiable sorted BigDecimals collection.
     * @param comparator The comparator for the BigDecimals.
     * @return An modifiable sorted BigDecimals collection containing the provided BigDecimals.
     */
    private ModifiableSortedBigDecimalCollection createSortedBigDecimalCollection(final Comparator<BigDecimal> comparator,
            final BigDecimal... numbers) {
        return ModifiableSortedBigDecimalCollection.of(comparator, numbers);
    }

    /**
     * Verifies that the <code>getComparator</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getComparatorShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableSortedBigDecimalCollection collection = createSortedBigDecimalCollection(Comparator.naturalOrder(), BigDecimal.ONE, BigDecimal.valueOf(2L));
        assertEquals(Comparator.naturalOrder(), collection.getComparator());
    }

    /**
     * Verifies that the <code>getGreaterThan</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreaterThanShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(BIG_DECIMAL_THREE, createBigDecimalCollection(BigDecimal.ONE, BigDecimal.valueOf(2L), BIG_DECIMAL_THREE).getGreaterThan(BigDecimal.valueOf(2L)));
    }

    /**
     * Verifies that the <code>getGreaterThanOrEqualTo</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreaterThanOrEqualToShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(BigDecimal.valueOf(2L), createBigDecimalCollection(BigDecimal.ONE, BigDecimal.valueOf(2L), BIG_DECIMAL_THREE).getGreaterThanOrEqualTo(BigDecimal.valueOf(2L)));
    }

    /**
     * Verifies that the <code>getLessThan</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLessThanShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(BigDecimal.ONE, createBigDecimalCollection(BigDecimal.ONE, BigDecimal.valueOf(2L), BIG_DECIMAL_THREE).getLessThan(BigDecimal.valueOf(2L)));
    }

    /**
     * Verifies that the <code>getLessThanOrEqualTo</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLessThanOrEqualToShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(BigDecimal.valueOf(2L), createBigDecimalCollection(BigDecimal.ONE, BigDecimal.valueOf(2L), BIG_DECIMAL_THREE).getLessThanOrEqualTo(BigDecimal.valueOf(2L)));
    }
}
