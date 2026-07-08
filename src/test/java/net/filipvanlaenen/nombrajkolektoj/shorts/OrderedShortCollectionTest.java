package net.filipvanlaenen.nombrajkolektoj.shorts;

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
     * The short six.
     */
    private static final Short SHORT_SIX = (short) 6;
    /**
     * Array with the shorts zero, one and two.
     */
    private static final Short[] SHORTS012 = new Short[] {(short) 0, (short) 1, (short) 2};
    /**
     * Array with the shorts one, two and three.
     */
    private static final Short[] SHORTS123 = new Short[] {(short) 1, (short) 2, (short) 3};
    /**
     * Collection with the shorts 0, 1 and 2.
     */
    private final OrderedShortCollection collection012 = createShortCollection((short) 0, (short) 1, (short) 2);
    /**
     * Collection with the shorts 1, 2 and 3.
     */
    private final OrderedShortCollection collection123 = createShortCollection((short) 1, (short) 2, (short) 3);

    protected OrderedShortCollection createShortCollection(final Short... numbers) {
        return OrderedShortCollection.of(numbers);
    }

    @Override
    protected OrderedShortCollection createShortCollection(final ElementCardinality elementCardinality,
            final Short... numbers) {
        return OrderedShortCollection.of(elementCardinality, numbers);
    }

    @Override
    protected OrderedShortCollection createShortCollection(final ElementCardinality elementCardinality,
            final OrderedShortCollection source) {
        return OrderedShortCollection.of(elementCardinality,
                OrderedShortCollection.of(source.toArray(EmptyArrays.SHORTS)));
    }

    @Override
    protected OrderedShortCollection createShortCollection(final OrderedShortCollection source) {
        return OrderedShortCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.SHORTS));
    }

    @Override
    protected OrderedShortCollection createOrderedShortCollection(final ElementCardinality elementCardinality,
            final Short... numbers) {
        return OrderedShortCollection.of(elementCardinality, numbers);
    }

    @Override
    protected OrderedShortCollection createOrderedShortCollection(final OrderedShortCollection source) {
        return OrderedShortCollection.of(source);
    }

    @Override
    protected OrderedShortCollection createOrderedShortCollection(final OrderedShortCollection source,
            final int fromIndex, final int toIndex) {
        return OrderedShortCollection.of(source, fromIndex, toIndex);
    }

    /**
     * Verifies that the matrix direct product factory method produces a correct ordered shorts collection.
     */
    @Test
    public void ofMatrixDirectProductShouldProduceACorrectOrderedCollection() {
        OrderedShortCollection collectionA = OrderedShortCollection.of((short) 1, (short) 2);
        OrderedShortCollection collectionB = OrderedShortCollection.of((short) 1, (short) 2, SHORT_THREE);
        OrderedShortCollection actual = OrderedShortCollection.matrixDirectProductOf(collectionA, collectionB);
        assertArrayEquals(new Short[] {(short) 1, (short) 2, SHORT_THREE, (short) 2, SHORT_FOUR, SHORT_SIX}, actual.toArray());
    }

    /**
     * Verifies that <code>ofMatrixDirectProduct</code> throws an exception when called with a collection containing
     * <code>null</code>.
     */
    @Test
    public void ofMatrixDirectProductShouldThrowExceptionWhenCollectionContainsNull() {
        OrderedShortCollection collectionA = OrderedShortCollection.of((short) 1, (short) 2);
        OrderedShortCollection collectionB = OrderedShortCollection.of((short) 1, null, SHORT_THREE);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> OrderedShortCollection.matrixDirectProductOf(collectionA, collectionB));
        assertEquals("Cannot produce a matrix direct product when one of the collections contains null.",
                exception.getMessage());
        exception = assertThrows(IllegalArgumentException.class,
                () -> OrderedShortCollection.matrixDirectProductOf(collectionB, collectionA));
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

    /**
     * Verifies that <code>createSequence</code> with generator and number of elements creates an empty collection when
     * the number of elements is less than one.
     */
    @Test
    public void createSequenceWithIndexShouldProduceAnEmptyCollectionWhenTheNumberOfElementsIsLessThanOne() {
        OrderedShortCollection actual = OrderedShortCollection.createSequence(i -> SHORTS012[i], 0);
        assertTrue(actual.isEmpty());
    }

    /**
     * Verifies that <code>createSequence</code> with generator and number of elements creates a collection with one
     * element.
     */
    @Test
    public void createSequenceWithIndexShouldProduceACollectionWithOneElement() {
        OrderedShortCollection actual = OrderedShortCollection.createSequence(i -> SHORTS012[i], 1);
        assertArrayEquals(new Short[] {(short) 0}, actual.toArray());
    }

    /**
     * Verifies that <code>createSequence</code> with generator and number of elements creates a collection with two
     * elements.
     */
    @Test
    public void createSequenceWithIndexShouldProduceACollectionWithTwoElements() {
        OrderedShortCollection actual = OrderedShortCollection.createSequence(i -> SHORTS012[i], 2);
        assertArrayEquals(new Short[] {(short) 0, (short) 1}, actual.toArray());
    }

    /**
     * Verifies that <code>createSequence</code> with generator and while condition creates an empty collection when the
     * number of elements is less than one.
     */
    @Test
    public void createSequenceWithGeneratorAndWhileConditionIndexShouldProduceAnEmptyCollection() {
        OrderedShortCollection actual = OrderedShortCollection.createSequence(i -> SHORTS012[i], n -> false);
        assertTrue(actual.isEmpty());
    }

    /**
     * Verifies that <code>createSequence</code> with generator and while condition creates a collection with one
     * element.
     */
    @Test
    public void createSequenceWithGeneratorAndWhileConditionShouldProduceACollectionWithOneElement() {
        OrderedShortCollection actual =
                OrderedShortCollection.createSequence(i -> SHORTS012[i], n -> !Objects.equals(n, (short) 1));
        assertArrayEquals(new Short[] {(short) 0}, actual.toArray());
    }

    /**
     * Verifies that <code>createSequence</code> with generator and while condition creates a collection with two
     * elements.
     */
    @Test
    public void createSequenceWithGeneratorAndWhileConditionShouldProduceACollectionWithTwoElements() {
        OrderedShortCollection actual =
                OrderedShortCollection.createSequence(i -> SHORTS012[i], n -> !Objects.equals(n, (short) 2));
        assertArrayEquals(new Short[] {(short) 0, (short) 1}, actual.toArray());
    }

    /**
     * Verifies that the union of no collections is an empty collection.
     */
    @Test
    public void unionOfNoCollectionsShouldBeEmpty() {
        assertTrue(OrderedShortCollection.unionOf().isEmpty());
    }

    /**
     * Verifies that the union of no collections is an empty collection.
     */
    @Test
    public void unionOfNoCollectionsWithElementCardinalityShouldBeEmpty() {
        assertTrue(OrderedShortCollection.unionOf(DISTINCT_ELEMENTS).isEmpty());
    }

    /**
     * Verifies that the union of one collections is the collection itself.
     */
    @Test
    public void unionOfOneCollectionsShouldBeItself() {
        assertArrayEquals(SHORTS123, OrderedShortCollection.unionOf(collection123).toArray());
    }

    /**
     * Verifies that the union of one collections is the collection itself.
     */
    @Test
    public void unionOfOneCollectionsWithElementCardinalityShouldBeItself() {
        assertArrayEquals(SHORTS123, OrderedShortCollection.unionOf(DISTINCT_ELEMENTS, collection123).toArray());
    }

    /**
     * Verifies that the union of two collections is a collection with all elements.
     */
    @Test
    public void unionOfTwoCollectionsShouldContainAllElements() {
        assertArrayEquals(new Short[] {(short) 0, (short) 1, (short) 2, (short) 1, (short) 2, SHORT_THREE},
                OrderedShortCollection.unionOf(collection012, collection123).toArray());
    }

    /**
     * Verifies that the union of two collections is a collection with all distinct elements.
     */
    @Test
    public void unionOfTwoCollectionsWithElementCardinalityShouldContainAllDistinctElements() {
        assertArrayEquals(new Short[] {(short) 0, (short) 1, (short) 2, SHORT_THREE},
                OrderedShortCollection.unionOf(DISTINCT_ELEMENTS, collection012, collection123).toArray());
    }
}
