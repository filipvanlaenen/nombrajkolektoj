package net.filipvanlaenen.nombrajkolektoj.floats;

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
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.floats.OrderedFloatCollection} class.
 */
public final class OrderedFloatCollectionTest extends OrderedFloatCollectionTestBase<OrderedFloatCollection> {
    /**
     * The float three.
     */
    private static final Float FLOAT_THREE = 3F;
    /**
     * The float four.
     */
    private static final Float FLOAT_FOUR = 4F;
    /**
     * The float six.
     */
    private static final Float FLOAT_SIX = 6F;
    /**
     * Array with the floats zero, one and two.
     */
    private static final Float[] FLOATS012 = new Float[] {0F, 1F, 2F};
    /**
     * Array with the floats one, two and three.
     */
    private static final Float[] FLOATS123 = new Float[] {1F, 2F, 3F};
    /**
     * Collection with the floats 0, 1 and 2.
     */
    private final OrderedFloatCollection collection012 = createFloatCollection(0F, 1F, 2F);
    /**
     * Collection with the floats 1, 2 and 3.
     */
    private final OrderedFloatCollection collection123 = createFloatCollection(1F, 2F, 3F);

    protected OrderedFloatCollection createFloatCollection(final Float... numbers) {
        return OrderedFloatCollection.of(numbers);
    }

    @Override
    protected OrderedFloatCollection createFloatCollection(final ElementCardinality elementCardinality,
            final Float... numbers) {
        return OrderedFloatCollection.of(elementCardinality, numbers);
    }

    @Override
    protected OrderedFloatCollection createFloatCollection(final ElementCardinality elementCardinality,
            final OrderedFloatCollection source) {
        return OrderedFloatCollection.of(elementCardinality,
                OrderedFloatCollection.of(source.toArray(EmptyArrays.FLOATS)));
    }

    @Override
    protected OrderedFloatCollection createFloatCollection(final OrderedFloatCollection source) {
        return OrderedFloatCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.FLOATS));
    }

    @Override
    protected OrderedFloatCollection createOrderedFloatCollection(final Float... numbers) {
        return OrderedFloatCollection.of(numbers);
    }

    @Override
    protected OrderedFloatCollection createOrderedFloatCollection(final ElementCardinality elementCardinality,
            final Float... numbers) {
        return OrderedFloatCollection.of(elementCardinality, numbers);
    }

    @Override
    protected OrderedFloatCollection createOrderedFloatCollection(final OrderedFloatCollection source) {
        return OrderedFloatCollection.of(source);
    }

    @Override
    protected OrderedFloatCollection createOrderedFloatCollection(final OrderedFloatCollection source,
            final int fromIndex, final int toIndex) {
        return OrderedFloatCollection.of(source, fromIndex, toIndex);
    }

    /**
     * Verifies that the matrix direct product factory method produces a correct ordered floats collection.
     */
    @Test
    public void ofMatrixDirectProductShouldProduceACorrectOrderedCollection() {
        OrderedFloatCollection collectionA = createOrderedFloatCollection(1F, 2F);
        OrderedFloatCollection collectionB = createOrderedFloatCollection(1F, 2F, FLOAT_THREE);
        OrderedFloatCollection actual = OrderedFloatCollection.matrixDirectProductOf(collectionA, collectionB);
        assertArrayEquals(new Float[] {1F, 2F, FLOAT_THREE, 2F, FLOAT_FOUR, FLOAT_SIX}, actual.toArray());
    }

    /**
     * Verifies that <code>ofMatrixDirectProduct</code> throws an exception when called with a collection containing
     * <code>null</code>.
     */
    @Test
    public void ofMatrixDirectProductShouldThrowExceptionWhenCollectionContainsNull() {
        OrderedFloatCollection collectionA = createOrderedFloatCollection(1F, 2F);
        OrderedFloatCollection collectionB = createOrderedFloatCollection(1F, null, FLOAT_THREE);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> OrderedFloatCollection.matrixDirectProductOf(collectionA, collectionB));
        assertEquals("Cannot produce a matrix direct product when one of the collections contains null.",
                exception.getMessage());
        exception = assertThrows(IllegalArgumentException.class,
                () -> OrderedFloatCollection.matrixDirectProductOf(collectionB, collectionA));
        assertEquals("Cannot produce a matrix direct product when one of the collections contains null.",
                exception.getMessage());
    }

    /**
     * Verifies that <code>createSequence</code> with first element, generator and number of elements creates an empty
     * collection when the number of elements is less than one.
     */
    @Test
    public void createSequenceShouldProduceAnEmptyCollectionWhenTheNumberOfElementsIsLessThanOne() {
        OrderedFloatCollection actual = OrderedFloatCollection.createSequence(0F, n -> n, 0);
        assertTrue(actual.isEmpty());
    }

    /**
     * Verifies that <code>createSequence</code> with first element, generator and number of elements creates a
     * collection with one element.
     */
    @Test
    public void createSequenceShouldProduceACollectionWithOneElement() {
        OrderedFloatCollection actual = OrderedFloatCollection.createSequence(0F, n -> n, 1);
        assertArrayEquals(new Float[] {0F}, actual.toArray());
    }

    /**
     * Verifies that <code>createSequence</code> with first element, generator and number of elements creates a
     * collection with two elements.
     */
    @Test
    public void createSequenceShouldProduceACollectionWithTwoElements() {
        OrderedFloatCollection actual = OrderedFloatCollection.createSequence(0F, n -> n, 2);
        assertArrayEquals(new Float[] {0F, 0F}, actual.toArray());
    }

    /**
     * Verifies that <code>createSequence</code> with first element, generator and while condition creates an empty
     * collection when the predicate is always false.
     */
    @Test
    public void createSequenceWithWhileConditionShouldProduceAnEmptyCollectionWhenTheNumberOfElementsIsLessThanOne() {
        OrderedFloatCollection actual = OrderedFloatCollection.createSequence(0F, n -> n, n -> false);
        assertTrue(actual.isEmpty());
    }

    /**
     * Verifies that <code>createSequence</code> with first element, generator and while condition creates a collection
     * with one element.
     */
    @Test
    public void createSequenceWithWhileConditionShouldProduceACollectionWithOneElement() {
        OrderedFloatCollection actual =
                OrderedFloatCollection.createSequence(0F, n -> n + 1F, n -> !Objects.equals(n, 1F));
        assertArrayEquals(new Float[] {0F}, actual.toArray());
    }

    /**
     * Verifies that <code>createSequence</code> with first element, generator and while condition ccreates a collection
     * with two elements.
     */
    @Test
    public void createSequenceWithWhileConditionShouldProduceACollectionWithTwoElements() {
        OrderedFloatCollection actual =
                OrderedFloatCollection.createSequence(0F, n -> n + 1F, n -> !Objects.equals(n, 2F));
        assertArrayEquals(new Float[] {0F, 1F}, actual.toArray());
    }

    /**
     * Verifies that <code>createSequence</code> with generator and number of elements creates an empty collection when
     * the number of elements is less than one.
     */
    @Test
    public void createSequenceWithIndexShouldProduceAnEmptyCollectionWhenTheNumberOfElementsIsLessThanOne() {
        OrderedFloatCollection actual = OrderedFloatCollection.createSequence(i -> FLOATS012[i], 0);
        assertTrue(actual.isEmpty());
    }

    /**
     * Verifies that <code>createSequence</code> with generator and number of elements creates a collection with one
     * element.
     */
    @Test
    public void createSequenceWithIndexShouldProduceACollectionWithOneElement() {
        OrderedFloatCollection actual = OrderedFloatCollection.createSequence(i -> FLOATS012[i], 1);
        assertArrayEquals(new Float[] {0F}, actual.toArray());
    }

    /**
     * Verifies that <code>createSequence</code> with generator and number of elements creates a collection with two
     * elements.
     */
    @Test
    public void createSequenceWithIndexShouldProduceACollectionWithTwoElements() {
        OrderedFloatCollection actual = OrderedFloatCollection.createSequence(i -> FLOATS012[i], 2);
        assertArrayEquals(new Float[] {0F, 1F}, actual.toArray());
    }

    /**
     * Verifies that <code>createSequence</code> with generator and while condition creates an empty collection when the
     * number of elements is less than one.
     */
    @Test
    public void createSequenceWithGeneratorAndWhileConditionIndexShouldProduceAnEmptyCollection() {
        OrderedFloatCollection actual = OrderedFloatCollection.createSequence(i -> FLOATS012[i], n -> false);
        assertTrue(actual.isEmpty());
    }

    /**
     * Verifies that <code>createSequence</code> with generator and while condition creates a collection with one
     * element.
     */
    @Test
    public void createSequenceWithGeneratorAndWhileConditionShouldProduceACollectionWithOneElement() {
        OrderedFloatCollection actual =
                OrderedFloatCollection.createSequence(i -> FLOATS012[i], n -> !Objects.equals(n, 1F));
        assertArrayEquals(new Float[] {0F}, actual.toArray());
    }

    /**
     * Verifies that <code>createSequence</code> with generator and while condition creates a collection with two
     * elements.
     */
    @Test
    public void createSequenceWithGeneratorAndWhileConditionShouldProduceACollectionWithTwoElements() {
        OrderedFloatCollection actual =
                OrderedFloatCollection.createSequence(i -> FLOATS012[i], n -> !Objects.equals(n, 2F));
        assertArrayEquals(new Float[] {0F, 1F}, actual.toArray());
    }

    /**
     * Verifies that the union of no collections is an empty collection.
     */
    @Test
    public void unionOfNoCollectionsShouldBeEmpty() {
        assertTrue(OrderedFloatCollection.unionOf().isEmpty());
    }

    /**
     * Verifies that the union of no collections is an empty collection.
     */
    @Test
    public void unionOfNoCollectionsWithElementCardinalityShouldBeEmpty() {
        assertTrue(OrderedFloatCollection.unionOf(DISTINCT_ELEMENTS).isEmpty());
    }

    /**
     * Verifies that the union of one collections is the collection itself.
     */
    @Test
    public void unionOfOneCollectionsShouldBeItself() {
        assertArrayEquals(FLOATS123, OrderedFloatCollection.unionOf(collection123).toArray());
    }

    /**
     * Verifies that the union of one collections is the collection itself.
     */
    @Test
    public void unionOfOneCollectionsWithElementCardinalityShouldBeItself() {
        assertArrayEquals(FLOATS123, OrderedFloatCollection.unionOf(DISTINCT_ELEMENTS, collection123).toArray());
    }

    /**
     * Verifies that the union of two collections is a collection with all elements.
     */
    @Test
    public void unionOfTwoCollectionsShouldContainAllElements() {
        assertArrayEquals(new Float[] {0F, 1F, 2F, 1F, 2F, FLOAT_THREE},
                OrderedFloatCollection.unionOf(collection012, collection123).toArray());
    }

    /**
     * Verifies that the union of two collections is a collection with all distinct elements.
     */
    @Test
    public void unionOfTwoCollectionsWithElementCardinalityShouldContainAllDistinctElements() {
        assertArrayEquals(new Float[] {0F, 1F, 2F, FLOAT_THREE},
                OrderedFloatCollection.unionOf(DISTINCT_ELEMENTS, collection012, collection123).toArray());
    }
}
