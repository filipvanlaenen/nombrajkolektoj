package net.filipvanlaenen.nombrajkolektoj.integers;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Objects;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.kolektoj.EmptyArrays;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.integers.OrderedIntegerCollection} class.
 */
public final class OrderedIntegerCollectionTest extends OrderedIntegerCollectionTestBase<OrderedIntegerCollection> {
    /**
     * The int three.
     */
    private static final Integer INTEGER_THREE = 3;
    /**
     * The int four.
     */
    private static final Integer INTEGER_FOUR = 4;
    /**
     * The int six.
     */
    private static final Integer INTEGER_SIX = 6;
    /**
     * Array with the integers zero, one and two.
     */
    private static final Integer[] INTEGERS012 = new Integer[] {0, 1, 2};
    /**
     * Array with the integers one, two and three.
     */
    private static final Integer[] INTEGERS123 = new Integer[] {1, 2, 3};
    /**
     * Collection with the integers 0, 1 and 2.
     */
    private final OrderedIntegerCollection collection012 = createIntegerCollection(0, 1, 2);
    /**
     * Collection with the integers 1, 2 and 3.
     */
    private final OrderedIntegerCollection collection123 = createIntegerCollection(1, 2, 3);

    protected OrderedIntegerCollection createIntegerCollection(final Integer... numbers) {
        return OrderedIntegerCollection.of(numbers);
    }

    @Override
    protected OrderedIntegerCollection createIntegerCollection(final ElementCardinality elementCardinality,
            final Integer... numbers) {
        return OrderedIntegerCollection.of(elementCardinality, numbers);
    }

    @Override
    protected OrderedIntegerCollection createIntegerCollection(final ElementCardinality elementCardinality,
            final OrderedIntegerCollection source) {
        return OrderedIntegerCollection.of(elementCardinality,
                OrderedIntegerCollection.of(source.toArray(EmptyArrays.INTEGERS)));
    }

    @Override
    protected OrderedIntegerCollection createIntegerCollection(final OrderedIntegerCollection source) {
        return OrderedIntegerCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.INTEGERS));
    }

    @Override
    protected OrderedIntegerCollection createOrderedIntegerCollection(final ElementCardinality elementCardinality,
            final Integer... numbers) {
        return OrderedIntegerCollection.of(elementCardinality, numbers);
    }

    @Override
    protected OrderedIntegerCollection createOrderedIntegerCollection(final OrderedIntegerCollection source) {
        return OrderedIntegerCollection.of(source);
    }

    @Override
    protected OrderedIntegerCollection createOrderedIntegerCollection(final OrderedIntegerCollection source,
            final int fromIndex, final int toIndex) {
        return OrderedIntegerCollection.of(source, fromIndex, toIndex);
    }

    /**
     * Verifies that the matrix direct product factory method produces a correct ordered integers collection.
     */
    @Test
    public void ofMatrixDirectProductShouldProduceACorrectOrderedCollection() {
        OrderedIntegerCollection collectionA = OrderedIntegerCollection.of(1, 2);
        OrderedIntegerCollection collectionB = OrderedIntegerCollection.of(1, 2, INTEGER_THREE);
        OrderedIntegerCollection actual = OrderedIntegerCollection.matrixDirectProductOf(collectionA, collectionB);
        assertArrayEquals(new Integer[] {1, 2, INTEGER_THREE, 2, INTEGER_FOUR, INTEGER_SIX}, actual.toArray());
    }

    /**
     * Verifies that <code>ofMatrixDirectProduct</code> throws an exception when called with a collection containing
     * <code>null</code>.
     */
    @Test
    public void ofMatrixDirectProductShouldThrowExceptionWhenCollectionContainsNull() {
        OrderedIntegerCollection collectionA = OrderedIntegerCollection.of(1, 2);
        OrderedIntegerCollection collectionB = OrderedIntegerCollection.of(1, null, INTEGER_THREE);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> OrderedIntegerCollection.matrixDirectProductOf(collectionA, collectionB));
        assertEquals("Cannot produce a matrix direct product when one of the collections contains null.",
                exception.getMessage());
        exception = assertThrows(IllegalArgumentException.class,
                () -> OrderedIntegerCollection.matrixDirectProductOf(collectionB, collectionA));
        assertEquals("Cannot produce a matrix direct product when one of the collections contains null.",
                exception.getMessage());
    }

    /**
     * Verifies that <code>createSequence</code> with first element, generator and number of elements creates an empty
     * collection when the number of elements is less than one.
     */
    @Test
    public void createSequenceShouldProduceAnEmptyCollectionWhenTheNumberOfElementsIsLessThanOne() {
        OrderedIntegerCollection actual = OrderedIntegerCollection.createSequence(0, n -> n, 0);
        assertTrue(actual.isEmpty());
    }

    /**
     * Verifies that <code>createSequence</code> with first element, generator and number of elements creates a
     * collection with one element.
     */
    @Test
    public void createSequenceShouldProduceACollectionWithOneElement() {
        OrderedIntegerCollection actual = OrderedIntegerCollection.createSequence(0, n -> n, 1);
        assertArrayEquals(new Integer[] {0}, actual.toArray());
    }

    /**
     * Verifies that <code>createSequence</code> with first element, generator and number of elements creates a
     * collection with two elements.
     */
    @Test
    public void createSequenceShouldProduceACollectionWithTwoElements() {
        OrderedIntegerCollection actual = OrderedIntegerCollection.createSequence(0, n -> n, 2);
        assertArrayEquals(new Integer[] {0, 0}, actual.toArray());
    }

    /**
     * Verifies that <code>createSequence</code> with first element, generator and while condition creates an empty
     * collection when the predicate is always false.
     */
    @Test
    public void createSequenceWithWhileConditionShouldProduceAnEmptyCollectionWhenTheNumberOfElementsIsLessThanOne() {
        OrderedIntegerCollection actual = OrderedIntegerCollection.createSequence(0, n -> n, n -> false);
        assertTrue(actual.isEmpty());
    }

    /**
     * Verifies that <code>createSequence</code> with first element, generator and while condition creates a collection
     * with one element.
     */
    @Test
    public void createSequenceWithWhileConditionShouldProduceACollectionWithOneElement() {
        OrderedIntegerCollection actual =
                OrderedIntegerCollection.createSequence(0, n -> n + 1, n -> !Objects.equals(n, 1));
        assertArrayEquals(new Integer[] {0}, actual.toArray());
    }

    /**
     * Verifies that <code>createSequence</code> with first element, generator and while condition ccreates a collection
     * with two elements.
     */
    @Test
    public void createSequenceWithWhileConditionShouldProduceACollectionWithTwoElements() {
        OrderedIntegerCollection actual =
                OrderedIntegerCollection.createSequence(0, n -> n + 1, n -> !Objects.equals(n, 2));
        assertArrayEquals(new Integer[] {0, 1}, actual.toArray());
    }

    /**
     * Verifies that <code>createSequence</code> with generator and number of elements creates an empty collection when
     * the number of elements is less than one.
     */
    @Test
    public void createSequenceWithIndexShouldProduceAnEmptyCollectionWhenTheNumberOfElementsIsLessThanOne() {
        OrderedIntegerCollection actual = OrderedIntegerCollection.createSequence(i -> INTEGERS012[i], 0);
        assertTrue(actual.isEmpty());
    }

    /**
     * Verifies that <code>createSequence</code> with generator and number of elements creates a collection with one
     * element.
     */
    @Test
    public void createSequenceWithIndexShouldProduceACollectionWithOneElement() {
        OrderedIntegerCollection actual = OrderedIntegerCollection.createSequence(i -> INTEGERS012[i], 1);
        assertArrayEquals(new Integer[] {0}, actual.toArray());
    }

    /**
     * Verifies that <code>createSequence</code> with generator and number of elements creates a collection with two
     * elements.
     */
    @Test
    public void createSequenceWithIndexShouldProduceACollectionWithTwoElements() {
        OrderedIntegerCollection actual = OrderedIntegerCollection.createSequence(i -> INTEGERS012[i], 2);
        assertArrayEquals(new Integer[] {0, 1}, actual.toArray());
    }

    /**
     * Verifies that <code>createSequence</code> with generator and while condition creates an empty collection when the
     * number of elements is less than one.
     */
    @Test
    public void createSequenceWithGeneratorAndWhileConditionIndexShouldProduceAnEmptyCollection() {
        OrderedIntegerCollection actual = OrderedIntegerCollection.createSequence(i -> INTEGERS012[i], n -> false);
        assertTrue(actual.isEmpty());
    }

    /**
     * Verifies that <code>createSequence</code> with generator and while condition creates a collection with one
     * element.
     */
    @Test
    public void createSequenceWithGeneratorAndWhileConditionShouldProduceACollectionWithOneElement() {
        OrderedIntegerCollection actual =
                OrderedIntegerCollection.createSequence(i -> INTEGERS012[i], n -> !Objects.equals(n, 1));
        assertArrayEquals(new Integer[] {0}, actual.toArray());
    }

    /**
     * Verifies that <code>createSequence</code> with generator and while condition creates a collection with two
     * elements.
     */
    @Test
    public void createSequenceWithGeneratorAndWhileConditionShouldProduceACollectionWithTwoElements() {
        OrderedIntegerCollection actual =
                OrderedIntegerCollection.createSequence(i -> INTEGERS012[i], n -> !Objects.equals(n, 2));
        assertArrayEquals(new Integer[] {0, 1}, actual.toArray());
    }

    /**
     * Verifies that the union of no collections is an empty collection.
     */
    @Test
    public void unionOfNoCollectionsShouldBeEmpty() {
        assertTrue(OrderedIntegerCollection.unionOf().isEmpty());
    }

    /**
     * Verifies that the union of no collections is an empty collection.
     */
    @Test
    public void unionOfNoCollectionsWithElementCardinalityShouldBeEmpty() {
        assertTrue(OrderedIntegerCollection.unionOf(DISTINCT_ELEMENTS).isEmpty());
    }

    /**
     * Verifies that the union of one collections is the collection itself.
     */
    @Test
    public void unionOfOneCollectionsShouldBeItself() {
        assertArrayEquals(INTEGERS123, OrderedIntegerCollection.unionOf(collection123).toArray());
    }

    /**
     * Verifies that the union of one collections is the collection itself.
     */
    @Test
    public void unionOfOneCollectionsWithElementCardinalityShouldBeItself() {
        assertArrayEquals(INTEGERS123, OrderedIntegerCollection.unionOf(DISTINCT_ELEMENTS, collection123).toArray());
    }

    /**
     * Verifies that the union of two collections is a collection with all elements.
     */
    @Test
    public void unionOfTwoCollectionsShouldContainAllElements() {
        assertArrayEquals(new Integer[] {0, 1, 2, 1, 2, INTEGER_THREE},
                OrderedIntegerCollection.unionOf(collection012, collection123).toArray());
    }

    /**
     * Verifies that the union of two collections is a collection with all distinct elements.
     */
    @Test
    public void unionOfTwoCollectionsWithElementCardinalityShouldContainAllDistinctElements() {
        assertArrayEquals(new Integer[] {0, 1, 2, INTEGER_THREE},
                OrderedIntegerCollection.unionOf(DISTINCT_ELEMENTS, collection012, collection123).toArray());
    }
}
