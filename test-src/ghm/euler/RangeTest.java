package ghm.euler;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

public class RangeTest {

  @Test
  public void ascending() {
    List<Integer> actual = Range.of(0, 10, 1).boxed().collect(Collectors.toList());
    Assert.assertEquals(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9), actual);

    actual = Range.of(0, 10, 2).boxed().collect(Collectors.toList());
    Assert.assertEquals(Arrays.asList(0, 2, 4, 6, 8), actual);

    actual = Range.of(0, 0, 1).boxed().collect(Collectors.toList());
    Assert.assertEquals(Arrays.asList(), actual);
  }

  public void descending() {
    List<Integer> actual = Range.of(10, 0, -1).boxed().collect(Collectors.toList());
    Assert.assertEquals(Arrays.asList(10, 9, 8, 7, 6, 5, 4, 3, 2, 1), actual);

    actual = Range.of(10, 0, -2).boxed().collect(Collectors.toList());
    Assert.assertEquals(Arrays.asList(8, 6, 4, 2), actual);

    actual = Range.of(0, 0, -1).boxed().collect(Collectors.toList());
    Assert.assertEquals(Arrays.asList(), actual);
  }

}
