package kakao;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TreasureTest {
    @Test
    void name() {
        Treasure treasure = new Treasure();
        int[][] key ={
                {0, 0, 0},
                {1, 0, 0},
                {0, 1, 1}};
        int[][] lock = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}};

        assertThat(treasure.solution(key,lock)).isTrue();
    }
}