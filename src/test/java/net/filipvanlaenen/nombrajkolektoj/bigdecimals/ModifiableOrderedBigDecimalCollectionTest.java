package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DUPLICATE_ELEMENTS;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.kolektoj.EmptyArrays;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigDecimals.ModifiableOrderedBigDecimalCollection} class.
 */
public final class ModifiableOrderedBigDecimalCollectionTest
        extends ModifiableBigDecimalCollectionTestBase<ModifiableOrderedBigDecimalCollection> {
    /**
     * The BigDecimal three.
     */
    private static final BigDecimal BIG_DECIMAL_THREE = BigDecimal.valueOf(3L);

    @Override
    protected ModifiableOrderedBigDecimalCollection createBigDecimalCollection(final Collection<BigDecimal> source) {
        return new ModifiableOrderedBigDecimalCollection.ArrayCollection(
                OrderedBigDecimalCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.BIG_DECIMALS)));
    }

    @Override
    protected ModifiableOrderedBigDecimalCollection createBigDecimalCollection(final BigDecimal... numbers) {
        return ModifiableOrderedBigDecimalCollection.of(numbers);
    }

    @Override
    protected ModifiableOrderedBigDecimalCollection createBigDecimalCollection(final ElementCardinality elementCardinality,
            final BigDecimal... numbers) {
        return ModifiableOrderedBigDecimalCollection.of(elementCardinality, numbers);
    }

    @Override
    protected ModifiableOrderedBigDecimalCollection createEmptyBigDecimalCollection() {
        return ModifiableOrderedBigDecimalCollection.empty();
    }

    /**
     * Verifies that the <code>firstIndexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void firstIndexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(1, createBigDecimalCollection(DUPLICATE_ELEMENTS, BigDecimal.ONE, BigDecimal.valueOf(2L), BigDecimal.valueOf(2L), BIG_DECIMAL_THREE).firstIndexOf(BigDecimal.valueOf(2L)));
    }

    /**
     * Verifies that the <code>getAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getAtShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(BigDecimal.valueOf(2L), createBigDecimalCollection(BigDecimal.ONE, BigDecimal.valueOf(2L), BIG_DECIMAL_THREE).getAt(1));
    }

    /**
     * Verifies that the <code>indexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void indexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(1, createBigDecimalCollection(BigDecimal.ONE, BigDecimal.valueOf(2L), BIG_DECIMAL_THREE).indexOf(BigDecimal.valueOf(2L)));
    }

    /**
     * Verifies that the <code>lastIndexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void lastIndexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2, createBigDecimalCollection(DUPLICATE_ELEMENTS, BigDecimal.ONE, BigDecimal.valueOf(2L), BigDecimal.valueOf(2L), BIG_DECIMAL_THREE).lastIndexOf(BigDecimal.valueOf(2L)));
    }

    /**
     * Verifies that the <code>removeAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeAtShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(BigDecimal.valueOf(2L), createBigDecimalCollection(BigDecimal.ONE, BigDecimal.valueOf(2L), BIG_DECIMAL_THREE).removeAt(1));
    }
}
