package it.unical.demacs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlgorithmsTest {

    private Algorithms algorithms;

    @BeforeEach
    void setUp() {
        algorithms = new Algorithms();
    }

    // Tests for sort()

    @Test
    void sortShouldOrderUnsortedArray() {
        int[] array = {5, 2, 4, 1, 3};

        algorithms.sort(array);

        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, array);
    }

    @Test
    void sortShouldHandleAlreadySortedArray() {
        int[] array = {1, 2, 3, 4, 5};

        algorithms.sort(array);

        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, array);
    }

    @Test
    void sortShouldHandleArrayWithDuplicatesAndNegativeNumbers() {
        int[] array = {3, -1, 3, 0, -5, 2};

        algorithms.sort(array);

        assertArrayEquals(new int[]{-5, -1, 0, 2, 3, 3}, array);
    }

    @Test
    void sortShouldHandleEmptyArray() {
        int[] array = {};

        algorithms.sort(array);

        assertArrayEquals(new int[]{}, array);
    }

    @Test
    void sortShouldHandleArrayWithOneElement() {
        int[] array = {42};

        algorithms.sort(array);

        assertArrayEquals(new int[]{42}, array);
    }

    @Test
    void sortShouldThrowExceptionWhenArrayIsNull() {
        assertThrows(
                IllegalArgumentException.class,
                () -> algorithms.sort(null)
        );
    }

    // Tests for areAnagrams()

    @Test
    void areAnagramsShouldReturnTrueForAnagrams() {
        assertTrue(algorithms.areAnagrams("roma", "amor"));
    }

    @Test
    void areAnagramsShouldReturnTrueForIdenticalStrings() {
        assertTrue(algorithms.areAnagrams("amore", "amore"));
    }

    @Test
    void areAnagramsShouldReturnFalseForNonAnagrams() {
        assertFalse(algorithms.areAnagrams("roma", "luna"));
    }

    @Test
    void areAnagramsShouldReturnFalseForStringsWithDifferentLengths() {
        assertFalse(algorithms.areAnagrams("roma", "amori"));
    }

    @Test
    void areAnagramsShouldHandleRepeatedCharacters() {
        assertTrue(algorithms.areAnagrams("aabb", "abab"));
    }

    @Test
    void areAnagramsShouldReturnTrueForTwoEmptyStrings() {
        assertTrue(algorithms.areAnagrams("", ""));
    }

    @Test
    void areAnagramsShouldThrowExceptionWhenFirstStringIsNull() {
        assertThrows(
                IllegalArgumentException.class,
                () -> algorithms.areAnagrams(null, "roma")
        );
    }

    @Test
    void areAnagramsShouldThrowExceptionWhenSecondStringIsNull() {
        assertThrows(
                IllegalArgumentException.class,
                () -> algorithms.areAnagrams("roma", null)
        );
    }

    @Test
    void areAnagramsShouldThrowExceptionWhenBothStringsAreNull() {
        assertThrows(
                IllegalArgumentException.class,
                () -> algorithms.areAnagrams(null, null)
        );
    }
}