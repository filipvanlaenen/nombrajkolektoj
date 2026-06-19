package net.filipvanlaenen.nombrajkolektoj.bytes;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.bytes.ByteCollection} class.
 */
public final class ByteCollectionTest extends ByteCollectionTestBase<ByteCollection> {
    /**
     * Collection with the bytes 1, 2 and 3.
     */
    private final NumericCollection<Byte> collection123 = createByteCollection((byte) 1, (byte) 2, (byte) 3);

    @Override
    protected ByteCollection createEmptyByteCollection() {
        return ByteCollection.empty();
    }

    @Override
    protected ByteCollection createByteCollection(final Byte... numbers) {
        return ByteCollection.of(numbers);
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
        assertTrue(createByteCollection((byte) 1, (byte) 2)
                .containsSame(ByteCollection.intersectionOf(createByteCollection((byte) 0, (byte) 1, (byte) 2), collection123)));
    }
}
