package ghm.euler;

import java.util.BitSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Prime number generator.
 */
public class Primes {

  /**
   * Generates all primes between 2 and the given value (inclusive)
   * @param val all primes up to and possibly including this value are returned
   * @return primes, ordered ascending
   */
  public static List<Integer> upTo(int val) {
    BitSet primes = new BitSet(val + 1);
    primes.set(0, val);
    primes.clear(0);
    primes.clear(1);
    for (int i = 2; i <= val; i++) {
      if (primes.get(i)) {
        for (int j = i + i; j <= val; j += i) {
          primes.clear(j);
        }
      }
    }

    return IntStream.range(2, val + 1).boxed().filter(i -> primes.get(i)).collect(Collectors.toList());
  }

}
