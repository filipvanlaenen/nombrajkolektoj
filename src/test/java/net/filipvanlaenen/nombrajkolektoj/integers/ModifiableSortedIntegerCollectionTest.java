package net.filipvanlaenen.nombrajkolektoj.integers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.integers.ModifiableSortedIntegerCollection} class.
 */
public final class ModifiableSortedIntegerCollectionTest
        extends ModifiableIntegerCollectionTestBase<ModifiableSortedIntegerCollection> {
    /**
     * The int three.
     */
    private static final Integer INTEGER_THREE = 3;

    @Override
    protected ModifiableSortedIntegerCollection createIntegerCollection(final Collection<Integer> source) {
        return new ModifiableSortedIntegerCollection.SortedTreeCollection(Comparator.naturalOrder(),
                IntegerCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.INTEGERS)));
    }

    @Override
    protected ModifiableSortedIntegerCollection createIntegerCollection(final Integer... numbers) {
        return ModifiableSortedIntegerCollection.of(Comparator.naturalOrder(), numbers);
    }

    @Override
    protected ModifiableSortedIntegerCollection createIntegerCollection(final ElementCardinality elementCardinality,
            final Integer... numbers) {
        return ModifiableSortedIntegerCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected ModifiableSortedIntegerCollection createEmptyIntegerCollection() {
        return ModifiableSortedIntegerCollection.empty(Comparator.naturalOrder());
    }

    /**
     * Creates a modifiable sorted integers collection containing the provided integers.
     *
     * @param numbers    The integers to be included in the modifiable sorted integers collection.
     * @param comparator The comparator for the integers.
     * @return An modifiable sorted integers collection containing the provided integers.
     */
    private ModifiableSortedIntegerCollection createSortedIntegerCollection(final Comparator<Integer> comparator,
            final Integer... numbers) {
        return ModifiableSortedIntegerCollection.of(comparator, numbers);
    }

    /**
     * Verifies that the <code>getComparator</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getComparatorShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableSortedIntegerCollection collection = createSortedIntegerCollection(Comparator.naturalOrder(), 1, 2);
        assertEquals(Comparator.naturalOrder(), collection.getComparator());
    }

    /**
     * Verifies that the <code>getGreaterThan</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreaterThanShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(INTEGER_THREE, createIntegerCollection(1, 2, INTEGER_THREE).getGreaterThan(2));
    }

    /**
     * Verifies that the <code>getGreaterThanOrEqualTo</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreaterThanOrEqualToShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2, createIntegerCollection(1, 2, INTEGER_THREE).getGreaterThanOrEqualTo(2));
    }

    /**
     * Verifies that the <code>getLessThan</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLessThanShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(1, createIntegerCollection(1, 2, INTEGER_THREE).getLessThan(2));
    }

    /**
     * Verifies that the <code>getLessThanOrEqualTo</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLessThanOrEqualToShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2, createIntegerCollection(1, 2, INTEGER_THREE).getLessThanOrEqualTo(2));
    }
}
