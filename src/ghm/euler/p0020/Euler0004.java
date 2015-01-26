package ghm.euler.p0020;

import ghm.euler.EulerSolution;
import ghm.euler.Range;

import java.util.Optional;

public class Euler0004 extends EulerSolution<Integer> {

  private boolean isPalindrome(int n) {
    return String.valueOf(n).equals(new StringBuilder(String.valueOf(n)).reverse().toString());
  }

  @Override
  public Integer solve() {
    return Range.of(999, 0, -1).boxed().map(i -> {
      return Range.of(i, 0, -1).boxed().map(j -> i * j).filter(this::isPalindrome).max(Integer::compareTo);
    }).filter(o -> o.isPresent()).map(o -> o.get()).max(Integer::compareTo).get();
  }

  @Override
  public Optional<Integer> expect() {
    return Optional.of(906609);
  }

  public static void main(String[] args) {
    new Euler0004().run();
  }

}
