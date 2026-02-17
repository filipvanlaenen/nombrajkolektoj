package net.filipvanlaenen.nombrajkolektoj.bytes;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Objects;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;
import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.bytes.OrderedByteCollection} class.
 */
public final class OrderedByteCollectionTest extends OrderedByteCollectionTestBase<OrderedByteCollection> {
    /**
     * The byte three.
     */
    private static final Byte BYTE_THREE = (byte) 3;
    /**
     * The byte four.
     */
    private static final Byte BYTE_FOUR = (byte) 4;
    /**
     * The byte sixe.
     */
    private static final Byte BYTE_SIX = (byte) 6;

    @Override
    protected OrderedByteCollection createEmptyByteCollection() {
        return OrderedByteCollection.empty();
    }

    @Override
    protected OrderedByteCollection createByteCollection(final NumericCollection<Byte> source) {
        return OrderedByteCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.BYTES));
    }

    @Override
    protected OrderedByteCollection createByteCollection(final ElementCardinality elementCardinality,
            final Byte... numbers) {
        return OrderedByteCollection.of(elementCardinality, numbers);
    }

    @Override
    protected OrderedByteCollection createByteCollection(final Byte... numbers) {
        return OrderedByteCollection.of(numbers);
    }

    @Override
    protected OrderedByteCollection createOrderedByteCollection(final Byte... numbers) {
        return OrderedByteCollection.of(numbers);
    }

    @Override
    protected OrderedByteCollection createOrderedByteCollection(final ElementCardinality elementCardinality,
            final Byte... numbers) {
        return OrderedByteCollection.of(elementCardinality, numbers);
    }

    @Override
    protected OrderedByteCollection createOrderedByteCollection(OrderedNumericCollection<Byte> source) {
        return OrderedByteCollection.of(source);
    }

    /**
     * Verifies that the matrix direct product factory method produces a correct ordered bytes collection.
     */
    @Test
    public void ofMatrixDirectProductShouldProduceACorrectOrderedCollection() {
        OrderedByteCollection collectionA = createOrderedByteCollection((byte) 1, (byte) 2);
        OrderedByteCollection collectionB = createOrderedByteCollection((byte) 1, (byte) 2, BYTE_THREE);
        OrderedByteCollection actual = OrderedByteCollection.ofMatrixDirectProduct(collectionA, collectionB);
        assertArrayEquals(new Byte[] {(byte) 1, (byte) 2, BYTE_THREE, (byte) 2, BYTE_FOUR, BYTE_SIX}, actual.toArray());
    }

    /**
     * Verifies that <code>ofMatrixDirectProduct</code> throws an exception when called with a collection containing
     * <code>null</code>.
     */
    @Test
    public void ofMatrixDirectProductShouldThrowExceptionWhenCollectionContainsNull() {
        OrderedByteCollection collectionA = createOrderedByteCollection((byte) 1, (byte) 2);
        OrderedByteCollection collectionB = createOrderedByteCollection((byte) 1, null, BYTE_THREE);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> OrderedByteCollection.ofMatrixDirectProduct(collectionA, collectionB));
        assertEquals("Cannot produce a matrix direct product when one of the collections contains null.",
                exception.getMessage());
        exception = assertThrows(IllegalArgumentException.class,
                () -> OrderedByteCollection.ofMatrixDirectProduct(collectionB, collectionA));
        assertEquals("Cannot produce a matrix direct product when one of the collections contains null.",
                exception.getMessage());
    }

    /**
     * Verifies that <code>createSequence</code> with first element, generator and number of elements creates an empty
     * collection when the number of elements is less than one.
     */
    @Test
    public void createSequenceShouldProduceAnEmptyCollectionWhenTheNumberOfElementsIsLessThanOne() {
        OrderedByteCollection actual = OrderedByteCollection.createSequence((byte) 0, n -> n, 0);
        assertTrue(actual.isEmpty());
    }

    /**
     * Verifies that <code>createSequence</code> with first element, generator and number of elements creates a
     * collection with one element.
     */
    @Test
    public void createSequenceShouldProduceACollectionWithOneElement() {
        OrderedByteCollection actual = OrderedByteCollection.createSequence((byte) 0, n -> n, 1);
        assertArrayEquals(new Byte[] {(byte) 0}, actual.toArray());
    }

    /**
     * Verifies that <code>createSequence</code> with first element, generator and number of elements creates a
     * collection with two elements.
     */
    @Test
    public void createSequenceShouldProduceACollectionWithTwoElements() {
        OrderedByteCollection actual = OrderedByteCollection.createSequence((byte) 0, n -> n, 2);
        assertArrayEquals(new Byte[] {(byte) 0, (byte) 0}, actual.toArray());
    }

    /**
     * Verifies that <code>createSequence</code> with first element, generator and while condition creates an empty
     * collection when the predicate is always false.
     */
    @Test
    public void createSequenceWithWhileConditionShouldProduceAnEmptyCollectionWhenTheNumberOfElementsIsLessThanOne() {
        OrderedByteCollection actual = OrderedByteCollection.createSequence((byte) 0, n -> n, n -> false);
        assertTrue(actual.isEmpty());
    }

    /**
     * Verifies that <code>createSequence</code> with first element, generator and while condition creates a collection
     * with one element.
     */
    @Test
    public void createSequenceWithWhileConditionShouldProduceACollectionWithOneElement() {
        OrderedByteCollection actual =
                OrderedByteCollection.createSequence((byte) 0, n -> (byte) (n + 1), n -> !Objects.equals(n, (byte) 1));
        assertArrayEquals(new Byte[] {(byte) 0}, actual.toArray());
    }

    /**
     * Verifies that <code>createSequence</code> with first element, generator and while condition ccreates a collection
     * with two elements.
     */
    @Test
    public void createSequenceWithWhileConditionShouldProduceACollectionWithTwoElements() {
        OrderedByteCollection actual =
                OrderedByteCollection.createSequence((byte) 0, n -> (byte) (n + 1), n -> !Objects.equals(n, (byte) 2));
        assertArrayEquals(new Byte[] {(byte) 0, (byte) 1}, actual.toArray());
    }
}
