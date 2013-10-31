import java.math.BigInteger;
import java.util.*;

class RiskyStatic {
    
    // is this method threadsafe?  How can we make it threadsafe?
    /**
     * @param x integer to test for primeness; requires x > 1
     * @return true if and only if x is prime
     */
    public static boolean isPrime(int x) {
        if (cache.containsKey(x)) return cache.get(x);
        boolean answer = BigInteger.valueOf(x).isProbablePrime(100);
        cache.put(x, answer);
        return answer;
    }
    
    private static Map<Integer,Boolean> cache = new HashMap<Integer,Boolean>();
    
}

/** Immutable */
class RiskyInstance {
    
    private int x;
    
    // is this method threadsafe?  How can we make it threadsafe?
    /**
     * @return true if and only if this has prime x
     */
    public boolean isPrimeX() {
        if (cache.containsKey(x)) return cache.get(x);
        boolean answer = BigInteger.valueOf(x).isProbablePrime(100);
        cache.put(x, answer);
        return answer;
    }
    
    private Map<Integer,Boolean> cache = new HashMap<Integer,Boolean>();
    
}
