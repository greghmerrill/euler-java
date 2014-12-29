package ghm.euler;

import java.util.Optional;

public class Euler0002 extends EulerSolution<Integer> {

  @Override
  public Integer solve() {
    int nm1 = 1, n = 2, sum = 2;
    while (n < 4_000_000) {
      int np1 = n + nm1;
      if (np1 % 2 == 0) sum += np1;
      nm1 = n;
      n = np1;
    }
    return sum;
  }

  @Override
  public Optional<Integer> expect() {
    return Optional.of(4613732);
  }

  public static void main(String[] args) {
    new Euler0002().run();
  }

}
