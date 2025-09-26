package net.filipvanlaenen.nombrajkolektoj.shorts;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DUPLICATE_ELEMENTS;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.shorts.ModifiableSortedShortCollection} class.
 */
public final class ModifiableSortedShortCollectionTest
        extends ModifiableShortCollectionTestBase<ModifiableSortedShortCollection> {
    /**
     * The short three.
     */
    private static final Short SHORT_THREE = (short) 3;

    @Override
    protected ModifiableSortedShortCollection createShortCollection(final Collection<Short> source) {
        return new ModifiableSortedShortCollection.SortedTreeCollection(Comparator.naturalOrder(),
                ShortCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.SHORTS)));
    }

    @Override
    protected ModifiableSortedShortCollection createShortCollection(final Short... numbers) {
        return ModifiableSortedShortCollection.of(Comparator.naturalOrder(), numbers);
    }

    @Override
    protected ModifiableSortedShortCollection createShortCollection(final ElementCardinality elementCardinality,
            final Short... numbers) {
        return ModifiableSortedShortCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected ModifiableSortedShortCollection createEmptyShortCollection() {
        return ModifiableSortedShortCollection.empty(Comparator.naturalOrder());
    }

    /**
     * Creates a modifiable sorted shorts collection containing the provided shorts.
     *
     * @param numbers    The shorts to be included in the modifiable sorted shorts collection.
     * @param comparator The comparator for the shorts.
     * @return An modifiable sorted shorts collection containing the provided shorts.
     */
    private ModifiableSortedShortCollection createSortedShortCollection(final Comparator<Short> comparator,
            final Short... numbers) {
        return ModifiableSortedShortCollection.of(comparator, numbers);
    }

    /**
     * Verifies that the <code>getComparator</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getComparatorShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableSortedShortCollection collection = createSortedShortCollection(Comparator.naturalOrder(), (short) 1, (short) 2);
        assertEquals(Comparator.naturalOrder(), collection.getComparator());
    }

    /**
     * Verifies that the <code>getGreaterThan</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreaterThanShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(SHORT_THREE, createShortCollection((short) 1, (short) 2, SHORT_THREE).getGreaterThan((short) 2));
    }

    /**
     * Verifies that the <code>getGreaterThanOrEqualTo</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreaterThanOrEqualToShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals((short) 2, createShortCollection((short) 1, (short) 2, SHORT_THREE).getGreaterThanOrEqualTo((short) 2));
    }

    /**
     * Verifies that the <code>getLessThan</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLessThanShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals((short) 1, createShortCollection((short) 1, (short) 2, SHORT_THREE).getLessThan((short) 2));
    }

    /**
     * Verifies that the <code>getLessThanOrEqualTo</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLessThanOrEqualToShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals((short) 2, createShortCollection((short) 1, (short) 2, SHORT_THREE).getLessThanOrEqualTo((short) 2));
    }

    /**
     * Verifies that the <code>firstIndexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void firstIndexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(1, createShortCollection(DUPLICATE_ELEMENTS, (short) 1, (short) 2, (short) 2, SHORT_THREE).firstIndexOf((short) 2));
    }

    /**
     * Verifies that the <code>getAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getAtShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals((short) 2, createShortCollection((short) 1, (short) 2, SHORT_THREE).getAt(1));
    }

    /**
     * Verifies that the <code>indexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void indexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(1, createShortCollection((short) 1, (short) 2, SHORT_THREE).indexOf((short) 2));
    }

    /**
     * Verifies that the <code>lastIndexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void lastIndexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2, createShortCollection(DUPLICATE_ELEMENTS, (short) 1, (short) 2, (short) 2, SHORT_THREE).lastIndexOf((short) 2));
    }

    /**
     * Verifies that the <code>removeAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeAtShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals((short) 2, createShortCollection((short) 1, (short) 2, SHORT_THREE).removeAt(1));
    }
}
