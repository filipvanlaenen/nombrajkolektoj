package net.filipvanlaenen.nombrajkolektoj.longs;

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
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.longs.OrderedLongCollection} class.
 */
public final class OrderedLongCollectionTest extends OrderedLongCollectionTestBase<OrderedLongCollection> {
    /**
     * The long three.
     */
    private static final Long LONG_THREE = 3L;
    /**
     * The long four.
     */
    private static final Long LONG_FOUR = 4L;
    /**
     * The long sixe.
     */
    private static final Long LONG_SIX = 6L;
    private static final Long[] LONGS = new Long[] {0L, 1L, 2L};

    @Override
    protected OrderedLongCollection createEmptyLongCollection() {
        return OrderedLongCollection.empty();
    }

    @Override
    protected OrderedLongCollection createLongCollection(final NumericCollection<Long> source) {
        return OrderedLongCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.LONGS));
    }

    @Override
    protected OrderedLongCollection createLongCollection(final ElementCardinality elementCardinality,
            final Long... numbers) {
        return OrderedLongCollection.of(elementCardinality, numbers);
    }

    @Override
    protected OrderedLongCollection createLongCollection(final Long... numbers) {
        return OrderedLongCollection.of(numbers);
    }

    @Override
    protected OrderedLongCollection createOrderedLongCollection(final Long... numbers) {
        return OrderedLongCollection.of(numbers);
    }

    @Override
    protected OrderedLongCollection createOrderedLongCollection(final ElementCardinality elementCardinality,
            final Long... numbers) {
        return OrderedLongCollection.of(elementCardinality, numbers);
    }

    @Override
    protected OrderedLongCollection createOrderedLongCollection(OrderedNumericCollection<Long> source) {
        return OrderedLongCollection.of(source);
    }

    /**
     * Verifies that the matrix direct product factory method produces a correct ordered longs collection.
     */
    @Test
    public void ofMatrixDirectProductShouldProduceACorrectOrderedCollection() {
        OrderedLongCollection collectionA = createOrderedLongCollection(1L, 2L);
        OrderedLongCollection collectionB = createOrderedLongCollection(1L, 2L, LONG_THREE);
        OrderedLongCollection actual = OrderedLongCollection.ofMatrixDirectProduct(collectionA, collectionB);
        assertArrayEquals(new Long[] {1L, 2L, LONG_THREE, 2L, LONG_FOUR, LONG_SIX}, actual.toArray());
    }

    /**
     * Verifies that <code>ofMatrixDirectProduct</code> throws an exception when called with a collection containing
     * <code>null</code>.
     */
    @Test
    public void ofMatrixDirectProductShouldThrowExceptionWhenCollectionContainsNull() {
        OrderedLongCollection collectionA = createOrderedLongCollection(1L, 2L);
        OrderedLongCollection collectionB = createOrderedLongCollection(1L, null, LONG_THREE);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> OrderedLongCollection.ofMatrixDirectProduct(collectionA, collectionB));
        assertEquals("Cannot produce a matrix direct product when one of the collections contains null.",
                exception.getMessage());
        exception = assertThrows(IllegalArgumentException.class,
                () -> OrderedLongCollection.ofMatrixDirectProduct(collectionB, collectionA));
        assertEquals("Cannot produce a matrix direct product when one of the collections contains null.",
                exception.getMessage());
    }

    /**
     * Verifies that <code>createSequence</code> with first element, generator and number of elements creates an empty
     * collection when the number of elements is less than one.
     */
    @Test
    public void createSequenceShouldProduceAnEmptyCollectionWhenTheNumberOfElementsIsLessThanOne() {
        OrderedLongCollection actual = OrderedLongCollection.createSequence(0L, n -> n, 0);
        assertTrue(actual.isEmpty());
    }

    /**
     * Verifies that <code>createSequence</code> with first element, generator and number of elements creates a
     * collection with one element.
     */
    @Test
    public void createSequenceShouldProduceACollectionWithOneElement() {
        OrderedLongCollection actual = OrderedLongCollection.createSequence(0L, n -> n, 1);
        assertArrayEquals(new Long[] {0L}, actual.toArray());
    }

    /**
     * Verifies that <code>createSequence</code> with first element, generator and number of elements creates a
     * collection with two elements.
     */
    @Test
    public void createSequenceShouldProduceACollectionWithTwoElements() {
        OrderedLongCollection actual = OrderedLongCollection.createSequence(0L, n -> n, 2);
        assertArrayEquals(new Long[] {0L, 0L}, actual.toArray());
    }

    /**
     * Verifies that <code>createSequence</code> with first element, generator and while condition creates an empty
     * collection when the predicate is always false.
     */
    @Test
    public void createSequenceWithWhileConditionShouldProduceAnEmptyCollectionWhenTheNumberOfElementsIsLessThanOne() {
        OrderedLongCollection actual = OrderedLongCollection.createSequence(0L, n -> n, n -> false);
        assertTrue(actual.isEmpty());
    }

    /**
     * Verifies that <code>createSequence</code> with first element, generator and while condition creates a collection
     * with one element.
     */
    @Test
    public void createSequenceWithWhileConditionShouldProduceACollectionWithOneElement() {
        OrderedLongCollection actual =
                OrderedLongCollection.createSequence(0L, n -> n + 1L, n -> !Objects.equals(n, 1L));
        assertArrayEquals(new Long[] {0L}, actual.toArray());
    }

    /**
     * Verifies that <code>createSequence</code> with first element, generator and while condition ccreates a collection
     * with two elements.
     */
    @Test
    public void createSequenceWithWhileConditionShouldProduceACollectionWithTwoElements() {
        OrderedLongCollection actual =
                OrderedLongCollection.createSequence(0L, n -> n + 1L, n -> !Objects.equals(n, 2L));
        assertArrayEquals(new Long[] {0L, 1L}, actual.toArray());
    }

    /**
     * Verifies that <code>createSequence</code> with generator and number of elements creates an empty collection when
     * the number of elements is less than one.
     */
    @Test
    public void createSequenceWithIndexShouldProduceAnEmptyCollectionWhenTheNumberOfElementsIsLessThanOne() {
        OrderedLongCollection actual = OrderedLongCollection.createSequence(i -> LONGS[i], 0);
        assertTrue(actual.isEmpty());
    }

    /**
     * Verifies that <code>createSequence</code> with generator and number of elements creates a collection with one
     * element.
     */
    @Test
    public void createSequenceWithIndexShouldProduceACollectionWithOneElement() {
        OrderedLongCollection actual = OrderedLongCollection.createSequence(i -> LONGS[i], 1);
        assertArrayEquals(new Long[] {0L}, actual.toArray());
    }

    /**
     * Verifies that <code>createSequence</code> with generator and number of elements creates a collection with two
     * elements.
     */
    @Test
    public void createSequenceWithIndexShouldProduceACollectionWithTwoElements() {
        OrderedLongCollection actual = OrderedLongCollection.createSequence(i -> LONGS[i], 2);
        assertArrayEquals(new Long[] {0L, 1L}, actual.toArray());
    }

    /**
     * Verifies that <code>createSequence</code> with generator and while condition creates an empty collection when the
     * number of elements is less than one.
     */
    @Test
    public void createSequenceWithGeneratorAndWhileConditionIndexShouldProduceAnEmptyCollection() {
        OrderedLongCollection actual = OrderedLongCollection.createSequence(i -> LONGS[i], n -> false);
        assertTrue(actual.isEmpty());
    }

    /**
     * Verifies that <code>createSequence</code> with generator and while condition creates a collection with one
     * element.
     */
    @Test
    public void createSequenceWithGeneratorAndWhileConditionShouldProduceACollectionWithOneElement() {
        OrderedLongCollection actual =
                OrderedLongCollection.createSequence(i -> LONGS[i], n -> !Objects.equals(n, 1L));
        assertArrayEquals(new Long[] {0L}, actual.toArray());
    }

    /**
     * Verifies that <code>createSequence</code> with generator and while condition creates a collection with two
     * elements.
     */
    @Test
    public void createSequenceWithGeneratorAndWhileConditionShouldProduceACollectionWithTwoElements() {
        OrderedLongCollection actual =
                OrderedLongCollection.createSequence(i -> LONGS[i], n -> !Objects.equals(n, 2L));
        assertArrayEquals(new Long[] {0L, 1L}, actual.toArray());
    }
}
