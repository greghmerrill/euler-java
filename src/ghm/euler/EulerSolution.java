package ghm.euler;

import java.util.Optional;

public abstract class EulerSolution<S> {

  public abstract S solve();

  public Optional<S> expect() {
    return Optional.empty();
  }

  public void run() {
    long start = System.currentTimeMillis();
    S answer = solve();
    long end = System.currentTimeMillis();

    System.out.println("Answer: " + answer + "  " + validate(answer));
    System.out.println(String.format("Time elapsed: %.2fs", 1.0 * (end - start) / 1000.0));
  }

  private String validate(S answer) {
    String validation = "[Not validated]";
    Optional<S> expect = expect();
    if (expect.isPresent()) {
      if (expect.get().equals(answer)) {
        validation = "[Validated]";
      } else {
        validation = "[INCORRECT.  Expected: " + expect.get() + "]";
      }
    }
    return validation;
  }

}
