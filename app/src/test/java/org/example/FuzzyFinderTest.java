package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class FuzzyFinderTest {
    @Test
    void linearSearchFindsGoldInSortedList() {
        FuzzyFinder finder = new FuzzyFinder();
        ArrayList<Fuzzy> fuzzies = new FuzzyListGenerator().sortedRainbowFuzzies();

        int index = finder.linearSearch(fuzzies);

        assertEquals(1000, index);
    }

    @Test
    void binarySearchFindsGoldInSortedList() {
        FuzzyFinder finder = new FuzzyFinder();
        ArrayList<Fuzzy> fuzzies = new FuzzyListGenerator().sortedRainbowFuzzies();

        int index = finder.binarySearch(fuzzies);

        assertEquals(1000, index);
    }

    @Test
    void linearSearchFindsGoldInRandomList() {
        FuzzyFinder finder = new FuzzyFinder();
        ArrayList<Fuzzy> fuzzies = new FuzzyListGenerator().randomizedRainbowFuzzies();

        int index = finder.linearSearch(fuzzies);

        assertEquals("gold", fuzzies.get(index).color);
    }

    @Test
    void binarySearchOnRandomListUsuallyFails() {
        FuzzyFinder finder = new FuzzyFinder();
        ArrayList<Fuzzy> fuzzies = new FuzzyListGenerator().randomizedRainbowFuzzies();

        int index = finder.binarySearch(fuzzies);

        assertTrue(index == -1 || fuzzies.get(index).color.equals("gold"));
    }

    @Test
    void emptyListReturnsNegativeOne() {
        FuzzyFinder finder = new FuzzyFinder();
        ArrayList<Fuzzy> fuzzies = new ArrayList<>();

        assertEquals(-1, finder.linearSearch(fuzzies));
        assertEquals(-1, finder.binarySearch(fuzzies));
    }

    @Test
    void listWithNoGoldReturnsNegativeOne() {
        FuzzyFinder finder = new FuzzyFinder();
        ArrayList<Fuzzy> fuzzies = new ArrayList<>();
        fuzzies.add(new Fuzzy("blue"));
        fuzzies.add(new Fuzzy("green"));
        fuzzies.add(new Fuzzy("red"));

        assertEquals(-1, finder.linearSearch(fuzzies));
        assertEquals(-1, finder.binarySearch(fuzzies));
    }

    @Test
    void goldAtTheStartIsFound() {
        FuzzyFinder finder = new FuzzyFinder();
        ArrayList<Fuzzy> fuzzies = new ArrayList<>();
        fuzzies.add(new Fuzzy("gold"));
        fuzzies.add(new Fuzzy("green"));
        fuzzies.add(new Fuzzy("red"));

        assertEquals(0, finder.linearSearch(fuzzies));
        assertEquals(0, finder.binarySearch(fuzzies));
    }

    @Test
    void goldAtTheEndIsFound() {
        FuzzyFinder finder = new FuzzyFinder();
        ArrayList<Fuzzy> fuzzies = new ArrayList<>();
        fuzzies.add(new Fuzzy("blue"));
        fuzzies.add(new Fuzzy("cyan"));
        fuzzies.add(new Fuzzy("gold"));

        assertEquals(2, finder.linearSearch(fuzzies));
        assertEquals(2, finder.binarySearch(fuzzies));
    }
}
