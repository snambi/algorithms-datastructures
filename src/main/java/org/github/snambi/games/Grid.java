package org.github.snambi.games;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Getter
@Setter
@Builder
public class Grid {

    private int[][] array = new int[3][3];

    public Grid( int[][] arr ){
        if( arr != null ){
            array = arr;
        }
    }

    public int[] getRow( int rowNum){
        if( rowNum <0 || rowNum > 3){
            throw new IllegalArgumentException("Illegal row number "+ rowNum + " passed.");
        }
        return array[rowNum];
    }

    public int[] getColumn(int colNum){
        if( colNum <0 || colNum > 3){
            throw new IllegalArgumentException("Illegal Col number "+ colNum + " passed.");
        }

        int[] column = new int[3];
        int colIndex = 0;
        for( int[] row : array ){
            column[colIndex] = row[colNum];
            colIndex++;
        }

        return column;
    }

    public boolean isValid(){

        // check whether there are 3 rows and 3 columns
        int rowCount =0;
        for( int[] row : array){
            rowCount++;
            if( row.length != 3 ){
                throw new IllegalArgumentException("Row doesn't have 3 elements "+ Arrays.toString(row));
            }
        }

        if( rowCount != 3 ){
            throw new IllegalArgumentException("Number of rows= "+ rowCount + ", it must be 3");
        }

        // convert to one dimensional array
        int[] single = new int[9];

        int i=0;
        for( int[] arr : array ){
            for( int a : arr ){
                single[i] = a;
                i++;
            }
        }

        return isValidArray(single);
    }

    public static boolean isValidArray(int[] array){

        // array must be size 9
        if( array == null || array.length == 0 ){
            throw new IllegalArgumentException("Array is null or empty");
        }

        if( array.length != 9 ){
            throw new IllegalArgumentException("Array length is not 9. size "+ array.length + " is invalid");
        }

        int[] count = new int[10];

        // count the number of occurance
        for( int i : array ){
            int g = count[i];
            g++;
            count[i] = g;
        }

        // check the whether any number has count more than 1
        for(int i=1; i<10 ; i++){
            if( count[i] != 1 ){
                return false;
            }
        }

        return true;
    }
}
