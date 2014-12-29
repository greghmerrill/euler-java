package ghm.euler;

import java.util.Optional;
import java.util.stream.IntStream;

public class Euler0001 extends EulerSolution<Integer> {

  private int sumOfMultiples(int n) {
    return IntStream.range(3, 1000).filter(i -> i % n == 0).sum();
  }

  @Override
  public Integer solve() {
    return sumOfMultiples(3) + sumOfMultiples(5) - sumOfMultiples(15);
  }

  @Override
  public Optional<Integer> expect() {
    return Optional.of(233168);
  }

  public static void main(String[] args) {
    new Euler0001().run();
  }

}
