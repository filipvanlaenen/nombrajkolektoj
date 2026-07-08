package net.filipvanlaenen.nombrajkolektoj.bytes;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DUPLICATE_ELEMENTS;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.kolektoj.EmptyArrays;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.bytes.ModifiableOrderedByteCollection} class.
 */
public final class ModifiableOrderedByteCollectionTest
        extends ModifiableByteCollectionTestBase<ModifiableOrderedByteCollection> {
    /**
     * The byte three.
     */
    private static final Byte BYTE_THREE = (byte) 3;
    /**
     * The byte four.
     */
    private static final Byte BYTE_FOUR = (byte) 4;
    /**
     * The magic number three.
     */
    private static final int THREE = 3;
    /**
     * Array with the bytes one, two and three.
     */
    private static final Byte[] BYTES123 = new Byte[] {(byte) 1, (byte) 2, (byte) 3};
    /**
     * Collection with the bytes 0, 1 and 2.
     */
    private final ModifiableOrderedByteCollection collection012 = createByteCollection((byte) 0, (byte) 1, (byte) 2);
    /**
     * Collection with the bytes 1, 2 and 3.
     */
    private final ModifiableOrderedByteCollection collection123 = createByteCollection((byte) 1, (byte) 2, (byte) 3);

    @Override
    protected ModifiableOrderedByteCollection createByteCollection(final ModifiableOrderedByteCollection source) {
        return ModifiableOrderedByteCollection
                .of(OrderedByteCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.BYTES)));
    }

    protected ModifiableOrderedByteCollection createByteCollection(final Byte... numbers) {
        return ModifiableOrderedByteCollection.of(numbers);
    }

    @Override
    protected ModifiableOrderedByteCollection createByteCollection(final ElementCardinality elementCardinality,
            final Byte... numbers) {
        return ModifiableOrderedByteCollection.of(elementCardinality, numbers);
    }

    @Override
    protected ModifiableOrderedByteCollection createByteCollection(final ElementCardinality elementCardinality,
            final ModifiableOrderedByteCollection source) {
        return ModifiableOrderedByteCollection.of(elementCardinality,
                OrderedByteCollection.of(source.toArray(EmptyArrays.BYTES)));
    }

    /**
     * Verifies that the <code>addAllAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addAllAtShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableOrderedByteCollection collection = createByteCollection(DISTINCT_ELEMENTS, (byte) 1, BYTE_THREE);
        assertTrue(collection.addAllAt(1, createByteCollection((byte) 2)));
        assertFalse(collection.addAllAt(1, createByteCollection((byte) 2)));
        assertEquals((byte) 2, collection.getAt(1));
    }

    /**
     * Verifies that the <code>addAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addAtShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableOrderedByteCollection collection = createByteCollection(DISTINCT_ELEMENTS, (byte) 1, BYTE_THREE);
        assertTrue(collection.addAt(1, (byte) 2));
        assertFalse(collection.addAt(1, (byte) 2));
        assertEquals((byte) 2, collection.getAt(1));
    }

    /**
     * Verifies that the <code>firstIndexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void firstIndexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(1, createByteCollection(DUPLICATE_ELEMENTS, (byte) 1, (byte) 2, (byte) 2, BYTE_THREE).firstIndexOf((byte) 2));
    }

    /**
     * Verifies that the <code>getAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getAtShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals((byte) 2, createByteCollection((byte) 1, (byte) 2, BYTE_THREE).getAt(1));
    }

    /**
     * Verifies that the <code>indexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void indexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(1, createByteCollection((byte) 1, (byte) 2, BYTE_THREE).indexOf((byte) 2));
    }

    /**
     * Verifies that the <code>lastIndexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void lastIndexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2, createByteCollection(DUPLICATE_ELEMENTS, (byte) 1, (byte) 2, (byte) 2, BYTE_THREE).lastIndexOf((byte) 2));
    }

    /**
     * Verifies that an ordered bytes collection created as a slice from another ordered collection has the same
     * element cardinality and the correct bytes in the same order.
     */
    @Test
    public void ofWithCollectionShouldReturnTheCorrectSlice() {
        ModifiableOrderedByteCollection source =
                ModifiableOrderedByteCollection.of(DISTINCT_ELEMENTS, (byte) 1, (byte) 2, BYTE_THREE, BYTE_FOUR);
        ModifiableOrderedByteCollection actual = ModifiableOrderedByteCollection.of(source, 1, THREE);
        assertEquals(DISTINCT_ELEMENTS, actual.getElementCardinality());
        assertArrayEquals(new Byte[] {(byte) 2, BYTE_THREE}, actual.toArray());
    }

    /**
     * Verifies that the <code>putAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void putAtShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableOrderedByteCollection collection = createByteCollection(DISTINCT_ELEMENTS, (byte) 1, BYTE_THREE);
        assertEquals(BYTE_THREE, collection.putAt(1, (byte) 2));
        assertEquals((byte) 2, collection.getAt(1));
    }

    /**
     * Verifies that the <code>removeAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeAtShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals((byte) 2, createByteCollection((byte) 1, (byte) 2, BYTE_THREE).removeAt(1));
    }

    /**
     * Verifies that the union of no collections is an empty collection.
     */
    @Test
    public void unionOfNoCollectionsShouldBeEmpty() {
        assertTrue(ModifiableOrderedByteCollection.unionOf().isEmpty());
    }

    /**
     * Verifies that the union of no collections is an empty collection.
     */
    @Test
    public void unionOfNoCollectionsWithElementCardinalityShouldBeEmpty() {
        assertTrue(ModifiableOrderedByteCollection.unionOf(DISTINCT_ELEMENTS).isEmpty());
    }

    /**
     * Verifies that the union of one collections is the collection itself.
     */
    @Test
    public void unionOfOneCollectionsShouldBeItself() {
        assertArrayEquals(BYTES123, ModifiableOrderedByteCollection.unionOf(collection123).toArray());
    }

    /**
     * Verifies that the union of one collections is the collection itself.
     */
    @Test
    public void unionOfOneCollectionsWithElementCardinalityShouldBeItself() {
        assertArrayEquals(BYTES123,
                ModifiableOrderedByteCollection.unionOf(DISTINCT_ELEMENTS, collection123).toArray());
    }

    /**
     * Verifies that the union of two collections is a collection with all elements.
     */
    @Test
    public void unionOfTwoCollectionsShouldContainAllElements() {
        assertArrayEquals(new Byte[] {(byte) 0, (byte) 1, (byte) 2, (byte) 1, (byte) 2, BYTE_THREE},
                ModifiableOrderedByteCollection.unionOf(collection012, collection123).toArray());
    }

    /**
     * Verifies that the union of two collections is a collection with all distinct elements.
     */
    @Test
    public void unionOfTwoCollectionsWithElementCardinalityShouldContainAllDistinctElements() {
        assertArrayEquals(new Byte[] {(byte) 0, (byte) 1, (byte) 2, BYTE_THREE},
                ModifiableOrderedByteCollection.unionOf(DISTINCT_ELEMENTS, collection012, collection123).toArray());
    }

}
