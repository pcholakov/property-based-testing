package demo;

import org.junit.Test;

import static demo.MutatedFunctions.foo;
import static org.assertj.core.api.Assertions.assertThat;

// Examples stolen wholesale from http://pitest.org/weak_tests/
public class WeakTest {

    @Test
    public void shouldReturnFooWhenGiven1() {
        assertThat(foo(1)).isEqualTo("foo");
    }

    @Test
    public void shouldReturnBarWhenGivenMinus1() {
        assertThat(foo(-1)).isEqualTo("bar");
    }

    @Test
    public void shouldFailWhenGivenFalse() {
        assertThat(foo(false)).isEqualTo("FAIL");
    }

    @Test
    public void shouldBeOkWhenGivenTrue() {
        assertThat(foo(true)).isEqualTo("OK");
    }

}
