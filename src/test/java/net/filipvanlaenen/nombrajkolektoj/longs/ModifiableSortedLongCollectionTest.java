package net.filipvanlaenen.nombrajkolektoj.longs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.longs.ModifiableSortedLongCollection} class.
 */
public final class ModifiableSortedLongCollectionTest
        extends ModifiableLongCollectionTestBase<ModifiableSortedLongCollection> {
    /**
     * The long three.
     */
    private static final Long LONG_THREE = 3L;

    @Override
    protected ModifiableSortedLongCollection createLongCollection(final Collection<Long> source) {
        return new ModifiableSortedLongCollection.SortedTreeCollection(Comparator.naturalOrder(),
                LongCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.LONGS)));
    }

    @Override
    protected ModifiableSortedLongCollection createLongCollection(final Long... numbers) {
        return ModifiableSortedLongCollection.of(Comparator.naturalOrder(), numbers);
    }

    @Override
    protected ModifiableSortedLongCollection createLongCollection(final ElementCardinality elementCardinality,
            final Long... numbers) {
        return ModifiableSortedLongCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected ModifiableSortedLongCollection createEmptyLongCollection() {
        return ModifiableSortedLongCollection.empty(Comparator.naturalOrder());
    }

    /**
     * Creates a modifiable sorted longs collection containing the provided longs.
     *
     * @param numbers    The longs to be included in the modifiable sorted longs collection.
     * @param comparator The comparator for the longs.
     * @return An modifiable sorted longs collection containing the provided longs.
     */
    private ModifiableSortedLongCollection createSortedLongCollection(final Comparator<Long> comparator,
            final Long... numbers) {
        return ModifiableSortedLongCollection.of(comparator, numbers);
    }

    /**
     * Verifies that the <code>getComparator</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getComparatorShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableSortedLongCollection collection = createSortedLongCollection(Comparator.naturalOrder(), 1L, 2L);
        assertEquals(Comparator.naturalOrder(), collection.getComparator());
    }

    /**
     * Verifies that the <code>getGreaterThan</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreaterThanShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(LONG_THREE, createLongCollection(1L, 2L, LONG_THREE).getGreaterThan(2L));
    }

    /**
     * Verifies that the <code>getGreaterThanOrEqualTo</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreaterThanOrEqualToShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2L, createLongCollection(1L, 2L, LONG_THREE).getGreaterThanOrEqualTo(2L));
    }

    /**
     * Verifies that the <code>getLessThan</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLessThanShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(1L, createLongCollection(1L, 2L, LONG_THREE).getLessThan(2L));
    }

    /**
     * Verifies that the <code>getLessThanOrEqualTo</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLessThanOrEqualToShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2L, createLongCollection(1L, 2L, LONG_THREE).getLessThanOrEqualTo(2L));
    }
}
