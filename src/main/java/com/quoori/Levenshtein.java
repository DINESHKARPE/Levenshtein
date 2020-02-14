package com.quoori;

public class Levenshtein {


    private static int minimum(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    private static int[][] createMatrix(CharSequence lhs, CharSequence rhs) {
        int[][] distance = new int[lhs.length() + 1][rhs.length() + 1];

        for (int i = 0; i <= lhs.length(); i++)
            distance[i][0] = i;
        for (int j = 1; j <= rhs.length(); j++)
            distance[0][j] = j;

        return distance;
    }
    private static void calculateMinimum(final CharSequence lhs, final CharSequence rhs, final int[][] distance, final int i) {
        for (int j = 1; j <= rhs.length(); j++)
            distance[i][j] = minimum(
                    distance[i - 1][j] + 1,
                    distance[i][j - 1] + 1,
                    distance[i - 1][j - 1] + ((lhs.charAt(i - 1) == rhs.charAt(j - 1)) ? 0 : 1));
    }
    public  int computeLevenshteinDistance(final CharSequence lhs, final CharSequence rhs) {

        int[][] distance = createMatrix(lhs, rhs);

        for (int i = 1; i <= lhs.length(); i++) {

            calculateMinimum(lhs, rhs, distance, i);
        }

        return distance[lhs.length()][rhs.length()];
    }

    public int computeLevenshteinDistance(final CharSequence lhs, final CharSequence rhs, final int maxDist) {

        int[][] distance = createMatrix(lhs, rhs);

        for (int i = 1; i <= lhs.length(); i++) {

            calculateMinimum(lhs, rhs, distance, i);

            if (distance[lhs.length()][rhs.length()] > maxDist) {
                return maxDist + 1;
            }
        }
        return distance[lhs.length()][rhs.length()];
    }




}