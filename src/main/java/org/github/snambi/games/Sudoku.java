package org.github.snambi.games;

import java.util.ArrayList;
import java.util.List;

public class Sudoku {

    Grid[][] grids = new Grid[3][3];

    public List<Integer> getRow(int rowNum){
        List<Integer> ints = new ArrayList<>();

        /**
         *  00 01 02
         *  10 11 12
         *  20 21 22
         */
        Grid[] row = grids[rowNum];

        return ints;
    }

    public static void main(String[] args){

        int[][] input = {{3, 1, 6, 5, 7, 8, 4, 9, 2 },
                            { 5, 2, 9, 1, 3, 4, 7, 6, 8 },
                            { 4, 8, 7, 6, 2, 9, 5, 3, 1 },
                            { 2, 6, 3, 0, 1, 5, 9, 8, 7 },
                            { 9, 7, 4, 8, 6, 0, 1, 2, 5 },
                            { 8, 5, 1, 7, 9, 2, 6, 4, 3 },
                            { 1, 3, 8, 0, 4, 7, 2, 0, 6 },
                            { 6, 9, 2, 3, 5, 1, 8, 7, 4 },
                            { 7, 4, 5, 0, 8, 6, 3, 1, 0 } };

        int[][] arr = {{3, 1, 6}, {5, 8, 8}, {4, 9, 2} };

        Grid grid = new Grid(arr);

        System.out.println("Grid is valid: " + grid.isValid() );
    }
}
