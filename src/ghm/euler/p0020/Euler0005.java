package ghm.euler.p0020;

import ghm.euler.EulerSolution;
import ghm.euler.Primes;
import ghm.euler.Range;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Euler0005 extends EulerSolution<Integer> {

  private static List<Integer> PRIMES = Primes.upTo(20);

  private int firstPrimeFactor(int n) {
    return PRIMES.stream().filter(p -> n % p == 0).findFirst().get();
  }

  private List<Integer> primeFactors(int n) {
    List<Integer> factors = new ArrayList<>();
    int rem = n;
    while (rem > 1) {
      int prime = firstPrimeFactor(rem);
      factors.add(prime);
      rem /= prime;
    }
    return factors;
  }

  @Override
  public Integer solve() {
    Map<Integer, Integer> countByPrime = new HashMap<>();
    Range.of(10, 21, 1).boxed().map(i -> primeFactors(i)).forEach(primes -> {
      primes.stream().collect(Collectors.groupingBy(i -> i)).forEach((p, v) -> {
        int count = countByPrime.getOrDefault(p, 0);
        countByPrime.put(p, Math.max(count, v.size()));
      });
    });

    return countByPrime.entrySet().stream().map(e -> (int) Math.pow(e.getKey(), e.getValue())).reduce(1, (acc, i) -> acc * i);
  }

  @Override
  public Optional<Integer> expect() {
    return Optional.of(232792560);
  }

  public static void main(String[] args) {
    new Euler0005().run();
  }

}
