package net.filipvanlaenen.nombrajkolektoj.floats;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DUPLICATE_ELEMENTS;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.floats.ModifiableSortedFloatCollection} class.
 */
public final class ModifiableSortedFloatCollectionTest
        extends ModifiableFloatCollectionTestBase<ModifiableSortedFloatCollection> {
    /**
     * The float three.
     */
    private static final Float FLOAT_THREE = 3F;

    @Override
    protected ModifiableSortedFloatCollection createFloatCollection(final NumericCollection<Float> source) {
        return new ModifiableSortedFloatCollection.SortedTreeCollection(Comparator.naturalOrder(),
                FloatCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.FLOATS)));
    }

    @Override
    protected ModifiableSortedFloatCollection createFloatCollection(final Float... numbers) {
        return ModifiableSortedFloatCollection.of(Comparator.naturalOrder(), numbers);
    }

    @Override
    protected ModifiableSortedFloatCollection createFloatCollection(final ElementCardinality elementCardinality,
            final Float... numbers) {
        return ModifiableSortedFloatCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected ModifiableSortedFloatCollection createEmptyFloatCollection() {
        return ModifiableSortedFloatCollection.empty(Comparator.naturalOrder());
    }

    /**
     * Creates a modifiable sorted floats collection containing the provided floats.
     *
     * @param numbers    The floats to be included in the modifiable sorted floats collection.
     * @param comparator The comparator for the floats.
     * @return An modifiable sorted floats collection containing the provided floats.
     */
    private ModifiableSortedFloatCollection createSortedFloatCollection(final Comparator<Float> comparator,
            final Float... numbers) {
        return ModifiableSortedFloatCollection.of(comparator, numbers);
    }

    /**
     * Verifies that the <code>getComparator</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getComparatorShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableSortedFloatCollection collection = createSortedFloatCollection(Comparator.naturalOrder(), 1F, 2F);
        assertEquals(Comparator.naturalOrder(), collection.getComparator());
    }

    /**
     * Verifies that the <code>getGreaterThan</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreaterThanShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(FLOAT_THREE, createFloatCollection(1F, 2F, FLOAT_THREE).getGreaterThan(2F));
    }

    /**
     * Verifies that the <code>getGreaterThanOrEqualTo</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreaterThanOrEqualToShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2F, createFloatCollection(1F, 2F, FLOAT_THREE).getGreaterThanOrEqualTo(2F));
    }

    /**
     * Verifies that the <code>getLessThan</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLessThanShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(1F, createFloatCollection(1F, 2F, FLOAT_THREE).getLessThan(2F));
    }

    /**
     * Verifies that the <code>getLessThanOrEqualTo</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLessThanOrEqualToShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2F, createFloatCollection(1F, 2F, FLOAT_THREE).getLessThanOrEqualTo(2F));
    }

    /**
     * Verifies that the <code>firstIndexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void firstIndexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(1, createFloatCollection(DUPLICATE_ELEMENTS, 1F, 2F, 2F, FLOAT_THREE).firstIndexOf(2F));
    }

    /**
     * Verifies that the <code>getAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getAtShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2F, createFloatCollection(1F, 2F, FLOAT_THREE).getAt(1));
    }

    /**
     * Verifies that the <code>indexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void indexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(1, createFloatCollection(1F, 2F, FLOAT_THREE).indexOf(2F));
    }

    /**
     * Verifies that the <code>lastIndexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void lastIndexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2, createFloatCollection(DUPLICATE_ELEMENTS, 1F, 2F, 2F, FLOAT_THREE).lastIndexOf(2F));
    }

    /**
     * Verifies that the <code>removeAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeAtShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2F, createFloatCollection(1F, 2F, FLOAT_THREE).removeAt(1));
    }
}
