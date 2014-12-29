package ghm.euler.p0020;

import java.util.BitSet;
import java.util.Optional;

import ghm.euler.EulerSolution;

public class Euler0003 extends EulerSolution<Integer> {

  private BitSet primesUpTo(int val) {
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

    return primes;
  }

  private int largestPrimeFactor(long number, BitSet primes) {
    for (int i = primes.length() - 1; i >= 2; i--) {
      if (primes.get(i) && number % i == 0) {
        return i;
      }
    }
    throw new RuntimeException("Prime factor not found");
  }

  @Override
  public Integer solve() {
    long number = 600851475143L;
    BitSet primes = primesUpTo((int) Math.sqrt(number));

    return largestPrimeFactor(number, primes);
  }

  @Override
  public Optional<Integer> expect() {
    return Optional.of(6857);
  }

  public static void main(String[] args) {
    new Euler0003().run();
  }

}
