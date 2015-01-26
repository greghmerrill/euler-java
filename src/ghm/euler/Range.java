package ghm.euler;

import java.util.PrimitiveIterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

/**
 * Provides functions for creating "range" sequences of integers, for example
 * (0, 2, 4, 6, 8) or (10, 9, 8, 7, 5).
 */
public class Range {

  /**
   * Creates a new range as an IntStream.  Examples:
   * 
   * (0, 10, 1) = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
   * (10, 0, -2) = [10, 8, 6, 4, 2]
   * 
   * @param startInclusive start value of the range, inclusive
   * @param endExclusive end value of the range, exclusive
   * @param step step function - may be positive or negative
   * @return range as IntStream
   */
  public static IntStream of(int startInclusive, int endExclusive, int step) {
    boolean ascending = startInclusive < endExclusive;
    Spliterator.OfInt spliterator = Spliterators.spliteratorUnknownSize(new PrimitiveIterator.OfInt() {
      private int next = startInclusive;

      @Override
      public int nextInt() {
        int val = next;
        next = next + step;
        return val;
      }

      @Override
      public boolean hasNext() {
        return ascending ? next < endExclusive : next > endExclusive;
      }
    }, 0);
    return StreamSupport.intStream(spliterator, false);
  }

}
