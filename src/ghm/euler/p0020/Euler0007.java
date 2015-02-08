package ghm.euler.p0020;

import ghm.euler.EulerSolution;
import ghm.euler.Range;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Euler0007 extends EulerSolution<Integer> {

  @Override
  public Integer solve() {
    List<Integer> primes = new ArrayList<Integer>(Arrays.asList(2));
    Range.unbounded(3, 2).allMatch(i -> {
      if (!primes.stream().filter(p -> i % p == 0).findAny().isPresent()) {
        primes.add(i);
      }
      return primes.size() < 10001;
    });
    return primes.get(10000);
  }

  @Override
  public Optional<Integer> expect() {
    return Optional.of(104743);
  }

  public static void main(String[] args) {
    new Euler0007().run();
  }

}
