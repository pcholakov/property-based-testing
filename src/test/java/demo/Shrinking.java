package demo;

import com.google.common.math.IntMath;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.When;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.Ignore;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitQuickcheck.class)
@Ignore
public class Shrinking {

    @Property(shrink = false)
    public void primeNumbers(@InRange(minInt = 2) @When(seed = 42) int i) {
        assertThat(IntMath.isPrime(i)).as("%s is a prime", i).isTrue();
    }

    @Property(maxShrinkDepth = 100)
    public void primeNumbersWithShrinkingAndFixedSeed(
            @InRange(minInt = 2) @When(seed = 42) int i) {

        assertThat(IntMath.isPrime(i)).as("%s is a prime", i).isTrue();
    }

}
