package ghm.euler.p0020;

import ghm.euler.EulerSolution;
import ghm.euler.Primes;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Euler0003 extends EulerSolution<Integer> {

  private int largestPrimeFactor(long number, List<Integer> primes) {
    Collections.reverse(primes);
    return primes.stream().filter(p -> number % p == 0).findFirst().get();
  }

  @Override
  public Integer solve() {
    long number = 600851475143L;
    return largestPrimeFactor(number, Primes.upTo((int) Math.sqrt(number)));
  }

  @Override
  public Optional<Integer> expect() {
    return Optional.of(6857);
  }

  public static void main(String[] args) {
    new Euler0003().run();
  }

}
