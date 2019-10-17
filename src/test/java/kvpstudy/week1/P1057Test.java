package kvpstudy.week1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class P1057Test {
    @Test
    void name() {
        List<Integer> rounds = Arrays.asList(16, 8, 9);
        assertThat(P1057.answer(rounds)).isEqualTo(4);
    }
}