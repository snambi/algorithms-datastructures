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

//    public List<Integer> getRow(int r){
//        List<Integer> row = new ArrayList<>();
//
//        return Arrays.asList(array[r]);
//    }
    public boolean isValid(){

        HashMap<Integer,Integer> numberCount = new HashMap<>();
        for( int i=1; i<=9 ; i++ ){
            numberCount.put( Integer.valueOf(i),0);
        }

        int l =0;
        for( int[] row : array ){
            if( row.length != 3){
                break;
            }else{
                for ( int x : row ) {
                    Integer count = numberCount.get(x);
                    count++;
                    numberCount.put(x, count);
                }
            }
            l++;
        }

        if(l != 3 ){
            return false;
        }

        for( int x : numberCount.keySet()){
            int count = numberCount.get(x);
            if( count == 0 || count > 1){
                return false;
            }
        }

        return true;
    }
}
