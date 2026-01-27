package net.filipvanlaenen.nombrajkolektoj.floats;

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
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.floats.ModifiableOrderedFloatCollection} class.
 */
public final class ModifiableOrderedFloatCollectionTest
        extends ModifiableFloatCollectionTestBase<ModifiableOrderedFloatCollection> {
    /**
     * The float three.
     */
    private static final Float FLOAT_THREE = 3F;

    @Override
    protected ModifiableOrderedFloatCollection createFloatCollection(final NumericCollection<Float> source) {
        return new ModifiableOrderedFloatCollection.ArrayCollection(
                OrderedFloatCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.FLOATS)));
    }

    @Override
    protected ModifiableOrderedFloatCollection createFloatCollection(final Float... numbers) {
        return ModifiableOrderedFloatCollection.of(numbers);
    }

    @Override
    protected ModifiableOrderedFloatCollection createFloatCollection(final ElementCardinality elementCardinality,
            final Float... numbers) {
        return ModifiableOrderedFloatCollection.of(elementCardinality, numbers);
    }

    @Override
    protected ModifiableOrderedFloatCollection createEmptyFloatCollection() {
        return ModifiableOrderedFloatCollection.empty();
    }

    /**
     * Verifies that the <code>addAllAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addAllAtShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableOrderedFloatCollection collection = createFloatCollection(DISTINCT_ELEMENTS, 1F, FLOAT_THREE);
        assertTrue(collection.addAllAt(1, createFloatCollection(2F)));
        assertFalse(collection.addAllAt(1, createFloatCollection(2F)));
        assertEquals(2F, collection.getAt(1));
    }

    /**
     * Verifies that the <code>addAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addAtShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableOrderedFloatCollection collection = createFloatCollection(DISTINCT_ELEMENTS, 1F, FLOAT_THREE);
        assertTrue(collection.addAt(1, 2F));
        assertFalse(collection.addAt(1, 2F));
        assertEquals(2F, collection.getAt(1));
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
     * Verifies that the <code>putAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void putAtShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableOrderedFloatCollection collection = createFloatCollection(DISTINCT_ELEMENTS, 1F, FLOAT_THREE);
        assertEquals(FLOAT_THREE, collection.putAt(1, 2F));
        assertEquals(2F, collection.getAt(1));
    }

    /**
     * Verifies that the <code>removeAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeAtShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2F, createFloatCollection(1F, 2F, FLOAT_THREE).removeAt(1));
    }
}
