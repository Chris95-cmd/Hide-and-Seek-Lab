package org.example;

import java.util.ArrayList;

public class App {
  public static void main(String[] args) {
    FuzzyListGenerator generator = new FuzzyListGenerator();
    FuzzyFinder finder = new FuzzyFinder();

    ArrayList<Fuzzy> sortedFuzzies = generator.sortedRainbowFuzzies();
    ArrayList<Fuzzy> randomFuzzies = generator.randomizedRainbowFuzzies();

    int testOne = finder.linearSearch(sortedFuzzies);
    int testTwo = finder.binarySearch(sortedFuzzies);
    int testThree = finder.linearSearch(randomFuzzies);
    int testFour = finder.binarySearch(randomFuzzies);

    System.out.println("Linear search, sorted list: " + testOne);
    System.out.println("Binary search, sorted list: " + testTwo);
    System.out.println("Linear search, random list: " + testThree);
    System.out.println("Binary search, random list: " + testFour);
    System.out.println("(-1 means the golden fuzzy was not found)");
  }
}
