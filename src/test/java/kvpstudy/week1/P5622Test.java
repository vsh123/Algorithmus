package kvpstudy.week1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class P5622Test {
    @Test
    void name() {
        assertThat(P5622.answer("UNUCIC")).isEqualTo(36);
    }
}