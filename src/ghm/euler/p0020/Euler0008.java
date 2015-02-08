package ghm.euler.p0020;

import ghm.euler.EulerSolution;
import ghm.euler.Range;

import java.io.File;
import java.util.Optional;
import java.util.Scanner;

public class Euler0008 extends EulerSolution<Long> {

  private String getNumber() throws Exception {
    try (Scanner scanner = new Scanner(new File(getClass().getResource("Euler0008.txt").toURI()))) {
      return scanner.useDelimiter("NONE").next().replaceAll("\r\n", "");
    }
  }

  @Override
  public Long solve() throws Exception {
    String number = getNumber();
    return Range.of(0, number.length() - 13, 1).asLongStream().boxed().reduce(0L, (acc, i) -> {
      long product = Range.of(0, 13, 1).asLongStream().boxed().reduce(1L, (pacc, j) -> {
        int index = (int) (i + j);
        return pacc * new Long(number.substring(index, index + 1));
      });
      return Math.max(product, acc);
    });
  }

  @Override
  public Optional<Long> expect() {
    return Optional.of(23514624000L);
  }

  public static void main(String[] args) {
    new Euler0008().run();
  }

}
