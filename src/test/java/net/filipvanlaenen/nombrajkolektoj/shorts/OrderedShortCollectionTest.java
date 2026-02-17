package net.filipvanlaenen.nombrajkolektoj.shorts;

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
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.shorts.OrderedShortCollection} class.
 */
public final class OrderedShortCollectionTest extends OrderedShortCollectionTestBase<OrderedShortCollection> {
    /**
     * The short three.
     */
    private static final Short SHORT_THREE = (short) 3;
    /**
     * The short four.
     */
    private static final Short SHORT_FOUR = (short) 4;
    /**
     * The short sixe.
     */
    private static final Short SHORT_SIX = (short) 6;

    @Override
    protected OrderedShortCollection createEmptyShortCollection() {
        return OrderedShortCollection.empty();
    }

    @Override
    protected OrderedShortCollection createShortCollection(final NumericCollection<Short> source) {
        return OrderedShortCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.SHORTS));
    }

    @Override
    protected OrderedShortCollection createShortCollection(final ElementCardinality elementCardinality,
            final Short... numbers) {
        return OrderedShortCollection.of(elementCardinality, numbers);
    }

    @Override
    protected OrderedShortCollection createShortCollection(final Short... numbers) {
        return OrderedShortCollection.of(numbers);
    }

    @Override
    protected OrderedShortCollection createOrderedShortCollection(final Short... numbers) {
        return OrderedShortCollection.of(numbers);
    }

    @Override
    protected OrderedShortCollection createOrderedShortCollection(final ElementCardinality elementCardinality,
            final Short... numbers) {
        return OrderedShortCollection.of(elementCardinality, numbers);
    }

    @Override
    protected OrderedShortCollection createOrderedShortCollection(OrderedNumericCollection<Short> source) {
        return OrderedShortCollection.of(source);
    }

    /**
     * Verifies that the matrix direct product factory method produces a correct ordered shorts collection.
     */
    @Test
    public void ofMatrixDirectProductShouldProduceACorrectOrderedCollection() {
        OrderedShortCollection collectionA = createOrderedShortCollection((short) 1, (short) 2);
        OrderedShortCollection collectionB = createOrderedShortCollection((short) 1, (short) 2, SHORT_THREE);
        OrderedShortCollection actual = OrderedShortCollection.ofMatrixDirectProduct(collectionA, collectionB);
        assertArrayEquals(new Short[] {(short) 1, (short) 2, SHORT_THREE, (short) 2, SHORT_FOUR, SHORT_SIX}, actual.toArray());
    }

    /**
     * Verifies that <code>ofMatrixDirectProduct</code> throws an exception when called with a collection containing
     * <code>null</code>.
     */
    @Test
    public void ofMatrixDirectProductShouldThrowExceptionWhenCollectionContainsNull() {
        OrderedShortCollection collectionA = createOrderedShortCollection((short) 1, (short) 2);
        OrderedShortCollection collectionB = createOrderedShortCollection((short) 1, null, SHORT_THREE);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> OrderedShortCollection.ofMatrixDirectProduct(collectionA, collectionB));
        assertEquals("Cannot produce a matrix direct product when one of the collections contains null.",
                exception.getMessage());
        exception = assertThrows(IllegalArgumentException.class,
                () -> OrderedShortCollection.ofMatrixDirectProduct(collectionB, collectionA));
        assertEquals("Cannot produce a matrix direct product when one of the collections contains null.",
                exception.getMessage());
    }

    /**
     * Verifies that <code>createSequence</code> with first element, generator and number of elements creates an empty
     * collection when the number of elements is less than one.
     */
    @Test
    public void createSequenceShouldProduceAnEmptyCollectionWhenTheNumberOfElementsIsLessThanOne() {
        OrderedShortCollection actual = OrderedShortCollection.createSequence((short) 0, n -> n, 0);
        assertTrue(actual.isEmpty());
    }

    /**
     * Verifies that <code>createSequence</code> with first element, generator and number of elements creates a
     * collection with one element.
     */
    @Test
    public void createSequenceShouldProduceACollectionWithOneElement() {
        OrderedShortCollection actual = OrderedShortCollection.createSequence((short) 0, n -> n, 1);
        assertArrayEquals(new Short[] {(short) 0}, actual.toArray());
    }

    /**
     * Verifies that <code>createSequence</code> with first element, generator and number of elements creates a
     * collection with two elements.
     */
    @Test
    public void createSequenceShouldProduceACollectionWithTwoElements() {
        OrderedShortCollection actual = OrderedShortCollection.createSequence((short) 0, n -> n, 2);
        assertArrayEquals(new Short[] {(short) 0, (short) 0}, actual.toArray());
    }

    /**
     * Verifies that <code>createSequence</code> with first element, generator and while condition creates an empty
     * collection when the predicate is always false.
     */
    @Test
    public void createSequenceWithWhileConditionShouldProduceAnEmptyCollectionWhenTheNumberOfElementsIsLessThanOne() {
        OrderedShortCollection actual = OrderedShortCollection.createSequence((short) 0, n -> n, n -> false);
        assertTrue(actual.isEmpty());
    }

    /**
     * Verifies that <code>createSequence</code> with first element, generator and while condition creates a collection
     * with one element.
     */
    @Test
    public void createSequenceWithWhileConditionShouldProduceACollectionWithOneElement() {
        OrderedShortCollection actual =
                OrderedShortCollection.createSequence((short) 0, n -> (short) (n + 1), n -> !Objects.equals(n, (short) 1));
        assertArrayEquals(new Short[] {(short) 0}, actual.toArray());
    }

    /**
     * Verifies that <code>createSequence</code> with first element, generator and while condition ccreates a collection
     * with two elements.
     */
    @Test
    public void createSequenceWithWhileConditionShouldProduceACollectionWithTwoElements() {
        OrderedShortCollection actual =
                OrderedShortCollection.createSequence((short) 0, n -> (short) (n + 1), n -> !Objects.equals(n, (short) 2));
        assertArrayEquals(new Short[] {(short) 0, (short) 1}, actual.toArray());
    }
}
