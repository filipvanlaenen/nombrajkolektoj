package net.filipvanlaenen.nombrajkolektoj.doubles;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.doubles.ModifiableSortedDoubleCollection} class.
 */
public final class ModifiableSortedDoubleCollectionTest
        extends ModifiableDoubleCollectionTestBase<ModifiableSortedDoubleCollection> {
    /**
     * The double three.
     */
    private static final Double DOUBLE_THREE = 3D;

    @Override
    protected ModifiableSortedDoubleCollection createDoubleCollection(final Collection<Double> source) {
        return new ModifiableSortedDoubleCollection.SortedTreeCollection(Comparator.naturalOrder(),
                DoubleCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.DOUBLES)));
    }

    @Override
    protected ModifiableSortedDoubleCollection createDoubleCollection(final Double... numbers) {
        return ModifiableSortedDoubleCollection.of(Comparator.naturalOrder(), numbers);
    }

    @Override
    protected ModifiableSortedDoubleCollection createDoubleCollection(final ElementCardinality elementCardinality,
            final Double... numbers) {
        return ModifiableSortedDoubleCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected ModifiableSortedDoubleCollection createEmptyDoubleCollection() {
        return ModifiableSortedDoubleCollection.empty(Comparator.naturalOrder());
    }

    /**
     * Creates a modifiable sorted doubles collection containing the provided doubles.
     *
     * @param numbers    The doubles to be included in the modifiable sorted doubles collection.
     * @param comparator The comparator for the doubles.
     * @return An modifiable sorted doubles collection containing the provided doubles.
     */
    private ModifiableSortedDoubleCollection createSortedDoubleCollection(final Comparator<Double> comparator,
            final Double... numbers) {
        return ModifiableSortedDoubleCollection.of(comparator, numbers);
    }

    /**
     * Verifies that the <code>getComparator</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getComparatorShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableSortedDoubleCollection collection = createSortedDoubleCollection(Comparator.naturalOrder(), 1D, 2D);
        assertEquals(Comparator.naturalOrder(), collection.getComparator());
    }

    /**
     * Verifies that the <code>getGreaterThan</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreaterThanShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(DOUBLE_THREE, createDoubleCollection(1D, 2D, DOUBLE_THREE).getGreaterThan(2D));
    }

    /**
     * Verifies that the <code>getGreaterThanOrEqualTo</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreaterThanOrEqualToShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2D, createDoubleCollection(1D, 2D, DOUBLE_THREE).getGreaterThanOrEqualTo(2D));
    }

    /**
     * Verifies that the <code>getLessThan</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLessThanShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(1D, createDoubleCollection(1D, 2D, DOUBLE_THREE).getLessThan(2D));
    }

    /**
     * Verifies that the <code>getLessThanOrEqualTo</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLessThanOrEqualToShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2D, createDoubleCollection(1D, 2D, DOUBLE_THREE).getLessThanOrEqualTo(2D));
    }
}
