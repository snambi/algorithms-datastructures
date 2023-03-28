package org.github.snambi.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class Fib {

    public static long fib( long n, boolean cache ){
        Map<Long, Long> memo = null;
        if(cache){
            memo = new HashMap<>();
        }
        return fib(n-1, memo) + fib(n-2, memo);
    }


    public static long fib( long n , Map<Long,Long> memo ){

        long result =0;

        if( n <= 2 ){
            return 1;
        }

        if( memo == null ){
            throw new IllegalArgumentException("memo cannot be null");
        }

        if(memo.containsKey(n)){
            result = memo.get(n);
            //System.out.printf("Cached %d = %d", n, result);
        }

        assert memo == null : "memo cannot be null";

        if( result == 0 ) {
            result = fib((n - 1), memo) + fib((n - 2), memo);
            memo.put(n, result);
        }

        return result;
    }
    public static void main(String[] args){

        System.out.printf("Fib(2) = %d \n", fib(2, true));
        System.out.printf("Fib(5) = %d \n", fib(5, true));
        System.out.printf("Fib(7) = %d \n", fib(7, true));
        System.out.printf("Fib(30) = %d \n", fib(30, true));
        System.out.printf("Fib(40) = %d \n", fib(40, true));
        System.out.printf("Fib(45) = %d \n", fib(45, true));
        System.out.printf("Fib(47) = %d \n", fib(47, true));
        System.out.printf("Fib(48) = %d \n", fib(48, true));
        System.out.printf("Fib(49) = %d \n", fib(49, true));
        System.out.printf("Fib(50) = %d \n", fib(50, true));

    }
}
