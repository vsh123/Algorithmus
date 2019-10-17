package kakao;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MuziTest {
    int[][] board = {{0, 0, 0, 1, 1}, {0, 0, 0, 1, 0}, {0, 1, 0, 1, 1}, {1, 1, 0, 0, 1}, {0, 0, 0, 0, 0}};

    @Test
    void name() {
        Muzi muzi = new Muzi();

        assertThat(muzi.solution(board)).isEqualTo(7);
    }
}