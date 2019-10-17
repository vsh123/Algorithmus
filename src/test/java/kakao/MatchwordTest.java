package kakao;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MatchwordTest {

    @Test
    void name() {
        Matchword matchWord = new Matchword();
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};
        int[] result = {3, 2, 4, 1, 0};
        assertThat(matchWord.solution(words, queries)).isEqualTo(result);
    }
}