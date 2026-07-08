package net.filipvanlaenen.nombrajkolektoj.bytes;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.bytes.ModifiableByteCollection} class.
 */
public final class ModifiableByteCollectionTest
        extends ModifiableByteCollectionTestBase<ModifiableByteCollection> {
    /**
     * The byte three.
     */
    private static final Byte BYTE_THREE = (byte) 3;
    /**
     * Collection with the bytes 0, 1 and 2.
     */
    private final ModifiableByteCollection collection012 = ModifiableByteCollection.of((byte) 0, (byte) 1, (byte) 2);
    /**
     * Collection with the bytes 1, 2 and 3.
     */
    private final ModifiableByteCollection collection123 = ModifiableByteCollection.of((byte) 1, (byte) 2, (byte) 3);

    /**
     * Verifies that the constructor of the ArrayCollection class creates a byte collection.
     */
    @Test
    public void constructorOfArrayCollectionShouldCreateAByteCollection() {
        assertTrue(new ModifiableByteCollection.ArrayCollection((byte) 1, (byte) 2, BYTE_THREE).containsAll(collection123));
    }

    /**
     * Verifies that the constructor of the HashCollection class creates a byte collection.
     */
    @Test
    public void constructorOfHashCollectionShouldCreateAByteCollection() {
        assertTrue(new ModifiableByteCollection.HashCollection((byte) 1, (byte) 2, BYTE_THREE).containsAll(collection123));
    }

    /**
     * Verifies that the constructor of the LinkedListCollection class creates a byte collection.
     */
    @Test
    public void constructorOfLinkedListCollectionShouldCreateAByteCollection() {
        assertTrue(
                new ModifiableByteCollection.LinkedListCollection((byte) 1, (byte) 2, BYTE_THREE).containsAll(collection123));
    }

    @Override
    protected ModifiableByteCollection createByteCollection(final ElementCardinality elementCardinality,
            final Byte... numbers) {
        return ModifiableByteCollection.of(elementCardinality, numbers);
    }

    @Override
    protected ModifiableByteCollection createByteCollection(final ElementCardinality elementCardinality,
            final ModifiableByteCollection source) {
        return ModifiableByteCollection.of(elementCardinality, source);
    }

    @Override
    protected ModifiableByteCollection createByteCollection(final ModifiableByteCollection source) {
        return ModifiableByteCollection.of(source);
    }

    /**
     * Verifies that the intersection of no collections is an empty collection.
     */
    @Test
    public void intersectionOfNoCollectionsShouldBeEmpty() {
        assertTrue(ModifiableByteCollection.intersectionOf().isEmpty());
    }

    /**
     * Verifies that the intersection of one collections is the collection itself.
     */
    @Test
    public void intersectionOfOneCollectionsShouldBeItself() {
        assertTrue(collection123.containsSame(ModifiableByteCollection.intersectionOf(collection123)));
    }

    /**
     * Verifies that the intersection of two collections is a collection with the common elements.
     */
    @Test
    public void intersectionOfTwoCollectionsShouldContainCommonElements() {
        assertTrue(ModifiableByteCollection.of((byte) 1, (byte) 2)
                .containsSame(ModifiableByteCollection.intersectionOf(collection012, collection123)));
    }

    /**
     * Verifies that the union of no collections is an empty collection.
     */
    @Test
    public void unionOfNoCollectionsShouldBeEmpty() {
        assertTrue(ModifiableByteCollection.unionOf().isEmpty());
    }

    /**
     * Verifies that the union of no collections is an empty collection.
     */
    @Test
    public void unionOfNoCollectionsWithElementCardinalityShouldBeEmpty() {
        assertTrue(ModifiableByteCollection.unionOf(DISTINCT_ELEMENTS).isEmpty());
    }

    /**
     * Verifies that the union of one collections is the collection itself.
     */
    @Test
    public void unionOfOneCollectionsShouldBeItself() {
        assertTrue(collection123.containsSame(ModifiableByteCollection.unionOf(collection123)));
    }

    /**
     * Verifies that the union of one collections is the collection itself.
     */
    @Test
    public void unionOfOneCollectionsWithElementCardinalityShouldBeItself() {
        assertTrue(collection123.containsSame(ModifiableByteCollection.unionOf(DISTINCT_ELEMENTS, collection123)));
    }

    /**
     * Verifies that the union of two collections is a collection with all elements.
     */
    @Test
    public void unionOfTwoCollectionsShouldContainAllElements() {
        assertTrue(ModifiableByteCollection.of((byte) 0, (byte) 1, (byte) 2, (byte) 1, (byte) 2, BYTE_THREE)
                .containsSame(ModifiableByteCollection.unionOf(collection012, collection123)));
    }

    /**
     * Verifies that the union of two collections is a collection with all distinct elements.
     */
    @Test
    public void unionOfTwoCollectionsWithElementCardinalityShouldContainAllDistinctElements() {
        assertTrue(ModifiableByteCollection.of((byte) 0, (byte) 1, (byte) 2, BYTE_THREE)
                .containsSame(ModifiableByteCollection.unionOf(DISTINCT_ELEMENTS, collection012, collection123)));
    }

}
