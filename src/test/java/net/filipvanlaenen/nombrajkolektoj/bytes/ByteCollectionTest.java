package net.filipvanlaenen.nombrajkolektoj.bytes;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.bytes.ByteCollection} class.
 */
public final class ByteCollectionTest extends ByteCollectionTestBase<ByteCollection> {
    /**
     * The byte three.
     */
    private static final Byte BYTE_THREE = (byte) 3;
    /**
     * Collection with the bytes 0, 1 and 2.
     */
    private final NumericCollection<Byte> collection012 = ByteCollection.of((byte) 0, (byte) 1, (byte) 2);
    /**
     * Collection with the bytes 1, 2 and 3.
     */
    private final NumericCollection<Byte> collection123 = ByteCollection.of((byte) 1, (byte) 2, (byte) 3);

    /**
     * Verifies that the constructor of the ArrayCollection class creates a byte collection.
     */
    @Test
    public void constructorOfArrayCollectionShouldCreateAByteCollection() {
        assertTrue(new ByteCollection.ArrayCollection((byte) 1, (byte) 2, BYTE_THREE).containsAll(collection123));
    }

    /**
     * Verifies that the constructor of the HashCollection class creates a byte collection.
     */
    @Test
    public void constructorOfHashCollectionShouldCreateAByteCollection() {
        assertTrue(new ByteCollection.HashCollection((byte) 1, (byte) 2, BYTE_THREE).containsAll(collection123));
    }

    @Override
    protected ByteCollection createByteCollection(final ElementCardinality elementCardinality,
            final Byte... numbers) {
        return ByteCollection.of(elementCardinality, numbers);
    }

    @Override
    protected ByteCollection createByteCollection(final ElementCardinality elementCardinality,
            final NumericCollection<Byte> source) {
        return ByteCollection.of(elementCardinality, source);
    }

    @Override
    protected ByteCollection createByteCollection(final NumericCollection<Byte> source) {
        return ByteCollection.of(source);
    }

    /**
     * Verifies that the intersection of no collections is an empty collection.
     */
    @Test
    public void intersectionOfNoCollectionsShouldBeEmpty() {
        assertTrue(ByteCollection.intersectionOf().isEmpty());
    }

    /**
     * Verifies that the intersection of one collections is the collection itself.
     */
    @Test
    public void intersectionOfOneCollectionsShouldBeItself() {
        assertTrue(collection123.containsSame(ByteCollection.intersectionOf(collection123)));
    }

    /**
     * Verifies that the intersection of two collections is a collection with the common elements.
     */
    @Test
    public void intersectionOfTwoCollectionsShouldContainCommonElements() {
        assertTrue(ByteCollection.of((byte) 1, (byte) 2)
                .containsSame(ByteCollection.intersectionOf(collection012, collection123)));
    }

    /**
     * Verifies that the union of no collections is an empty collection.
     */
    @Test
    public void unionOfNoCollectionsShouldBeEmpty() {
        assertTrue(ByteCollection.unionOf().isEmpty());
    }

    /**
     * Verifies that the union of no collections is an empty collection.
     */
    @Test
    public void unionOfNoCollectionsWithElementCardinalityShouldBeEmpty() {
        assertTrue(ByteCollection.unionOf(DISTINCT_ELEMENTS).isEmpty());
    }

    /**
     * Verifies that the union of one collections is the collection itself.
     */
    @Test
    public void unionOfOneCollectionsShouldBeItself() {
        assertTrue(collection123.containsSame(ByteCollection.unionOf(collection123)));
    }

    /**
     * Verifies that the union of one collections is the collection itself.
     */
    @Test
    public void unionOfOneCollectionsWithElementCardinalityShouldBeItself() {
        assertTrue(collection123.containsSame(ByteCollection.unionOf(DISTINCT_ELEMENTS, collection123)));
    }

    /**
     * Verifies that the union of two collections is a collection with all elements.
     */
    @Test
    public void unionOfTwoCollectionsShouldContainAllElements() {
        assertTrue(ByteCollection.of((byte) 0, (byte) 1, (byte) 2, (byte) 1, (byte) 2, BYTE_THREE)
                .containsSame(ByteCollection.unionOf(collection012, collection123)));
    }

    /**
     * Verifies that the union of two collections is a collection with all distinct elements.
     */
    @Test
    public void unionOfTwoCollectionsWithElementCardinalityShouldContainAllDistinctElements() {
        assertTrue(ByteCollection.of((byte) 0, (byte) 1, (byte) 2, BYTE_THREE)
                .containsSame(ByteCollection.unionOf(DISTINCT_ELEMENTS, collection012, collection123)));
    }
}
