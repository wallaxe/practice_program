import mars_rover.Direction;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CreatingDirectionTest {
    @Test
    public void creating_directions_given_their_encoding() {
        assertThat(Direction.create("N"), is(Direction.N));
        assertThat(Direction.create("S"), is(Direction.S));
        assertThat(Direction.create("E"), is(Direction.E));
        assertThat(Direction.create("W"), is(Direction.W));
    }

    @Test(expected = IllegalArgumentException.class)
    public void trying_to_create_an_unknown_direction() {
        Direction.create("X");
    }
}
