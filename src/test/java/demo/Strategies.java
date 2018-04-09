package demo;

import com.google.common.collect.Lists;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitQuickcheck.class)
public class Strategies {

    @Property
    public void identity(long n, @InRange(minLong = 1, maxLong = 1) long one) {
        assertThat(n * one).isEqualTo(n);
    }

    @Property
    public void differentPaths(String s1, String s2) {
        assertThat(s1.length() + s2.length()).isEqualTo((s1 + s2).length());
    }

    @Property
    public void thereAndBack(List<Object> list) {
        assertThat(Lists.reverse(Lists.reverse(list))).isEqualTo(list);
    }

    @Property
    public void idempotency(double d, @InRange(minInt = 1, maxInt = 100) int reps) {
        var result = d;
        for (int i = 0; i < reps; i++) result = Math.abs(result);

        assertThat(result).isEqualTo(Math.abs(d));
    }

}
