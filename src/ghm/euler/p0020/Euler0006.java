package ghm.euler.p0020;

import ghm.euler.EulerSolution;
import ghm.euler.Range;

import java.util.Optional;

public class Euler0006 extends EulerSolution<Integer> {

  @Override
  public Integer solve() {
    int sqSum = (int) Math.pow(Range.of(1, 101, 1).sum(), 2);
    int sumSq = Range.of(1, 101, 1).map(i -> i * i).sum();
    return sqSum - sumSq;
  }

  @Override
  public Optional<Integer> expect() {
    return Optional.of(25164150);
  }

  public static void main(String[] args) {
    new Euler0006().run();
  }

}
