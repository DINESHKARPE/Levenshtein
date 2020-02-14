package com.quoori;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LevenshteinTest {


    private Levenshtein levenshtein;

    @Before
    public void setUp() throws Exception {
        levenshtein = new Levenshtein();
    }

    @Test
    public void testComputeLevenshteinDistance() {
        assertEquals (1,levenshtein.computeLevenshteinDistance("Haus","Maus"));
        assertEquals (2,levenshtein.computeLevenshteinDistance("Haus","Mausi"));
        assertEquals (12,levenshtein.computeLevenshteinDistance("Kartoffelsalat","Runkelrüben"));
    }
    @Test
    public void testComputeLevenshteinDistanceWithMaxDist() {
        assertEquals (1,levenshtein.computeLevenshteinDistance("Haus","Maus",2));
        assertEquals (2,levenshtein.computeLevenshteinDistance("Haus","Mausi",2));
        assertEquals (3,levenshtein.computeLevenshteinDistance("Kartoffelsalat","Runkelrüben",2));
    }


}
