package net.filipvanlaenen.nombrajkolektoj.integers;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DUPLICATE_ELEMENTS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.integers.ModifiableOrderedIntegerCollection} class.
 */
public final class ModifiableOrderedIntegerCollectionTest
        extends ModifiableIntegerCollectionTestBase<ModifiableOrderedIntegerCollection> {
    /**
     * The int three.
     */
    private static final Integer INTEGER_THREE = 3;

    @Override
    protected ModifiableOrderedIntegerCollection createIntegerCollection(final NumericCollection<Integer> source) {
        return new ModifiableOrderedIntegerCollection.ArrayCollection(
                OrderedIntegerCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.INTEGERS)));
    }

    @Override
    protected ModifiableOrderedIntegerCollection createIntegerCollection(final Integer... numbers) {
        return ModifiableOrderedIntegerCollection.of(numbers);
    }

    @Override
    protected ModifiableOrderedIntegerCollection createIntegerCollection(final ElementCardinality elementCardinality,
            final Integer... numbers) {
        return ModifiableOrderedIntegerCollection.of(elementCardinality, numbers);
    }

    @Override
    protected ModifiableOrderedIntegerCollection createEmptyIntegerCollection() {
        return ModifiableOrderedIntegerCollection.empty();
    }

    /**
     * Verifies that the <code>addAllAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addAllAtShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableOrderedIntegerCollection collection = createIntegerCollection(DISTINCT_ELEMENTS, 1, INTEGER_THREE);
        assertTrue(collection.addAllAt(1, createIntegerCollection(2)));
        assertFalse(collection.addAllAt(1, createIntegerCollection(2)));
        assertEquals(2, collection.getAt(1));
    }

    /**
     * Verifies that the <code>addAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addAtShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableOrderedIntegerCollection collection = createIntegerCollection(DISTINCT_ELEMENTS, 1, INTEGER_THREE);
        assertTrue(collection.addAt(1, 2));
        assertFalse(collection.addAt(1, 2));
        assertEquals(2, collection.getAt(1));
    }

    /**
     * Verifies that the <code>firstIndexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void firstIndexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(1, createIntegerCollection(DUPLICATE_ELEMENTS, 1, 2, 2, INTEGER_THREE).firstIndexOf(2));
    }

    /**
     * Verifies that the <code>getAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getAtShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2, createIntegerCollection(1, 2, INTEGER_THREE).getAt(1));
    }

    /**
     * Verifies that the <code>indexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void indexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(1, createIntegerCollection(1, 2, INTEGER_THREE).indexOf(2));
    }

    /**
     * Verifies that the <code>lastIndexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void lastIndexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2, createIntegerCollection(DUPLICATE_ELEMENTS, 1, 2, 2, INTEGER_THREE).lastIndexOf(2));
    }

    /**
     * Verifies that the <code>putAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void putAtShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableOrderedIntegerCollection collection = createIntegerCollection(DISTINCT_ELEMENTS, 1, INTEGER_THREE);
        assertEquals(INTEGER_THREE, collection.putAt(1, 2));
        assertEquals(2, collection.getAt(1));
    }

    /**
     * Verifies that the <code>removeAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeAtShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2, createIntegerCollection(1, 2, INTEGER_THREE).removeAt(1));
    }
}
